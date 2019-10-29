package java_transformation

import constructs.*

class JavaFromAadlSystem(private val structure: Map<String, AadlObject>,
                         private val conditions: Map<String, List<AgreeCondition>>,
                         private val agreeVars: Map<String, List<AgreeValue>>,
                         private val agreeNodes: Map<String, Map<NodeName, AgreeNode>>) {

    private val javaVoidType = "void"

    private fun build(): List<JavaClass> = structure.flatMap { (name, pkg) ->
        listOf(buildAbstractClass(
                        objectName = name,
                        objectStructure = pkg,
                        objectConditions = conditions[name]!!,
                        agreeVars = agreeVars[name]!!),
                buildStubClass(name))
        }

    private fun buildAbstractClass(objectName: String,
                                   objectStructure: AadlObject,
                                   objectConditions: List<AgreeCondition>,
                                   agreeVars: List<AgreeValue>) =

        JavaClass(
                abstract = true,
                name = objectName)
            .apply {
                members.addAll(
                    objectStructure.features
                        .filterIsInstance<AadlPort>()
                        .map { JavaMember(it.name, it.type.asJavaMemoryObject(),static = true) }
                )

                members.addAll(
                        agreeVars.map { JavaMember(it.name, it.type.asJavaMemoryObject(), static = true) }
                )

                val assignments = objectConditions
                        .filter { it.type == AgreeCondition.ConditionType.ASSIGNMENT }
                        .map { it.expr.alignMethodCalls() }

                val assumptions = objectConditions
                        .filter { it.type == AgreeCondition.ConditionType.ASSUME }
                        .asJavaAssertions()

                val guarantees = objectConditions
                        .filter { it.type == AgreeCondition.ConditionType.GUARANTEE }
                        .asJavaAssertions()

                val updatePorts = objectStructure.connections
                        .filter { it.srcObjectName == objectName }
                        .map { javaUpdatePortValue(it) }

                val checkedMethodName = objectName.asCheckedMethodName()
                val uncheckedMethodName = objectName.asUnCheckedMethodName()

                methods.addAll(listOf(

                        JavaMethod(name = checkedMethodName,
                                type = javaVoidType,
                                body = assumptions + assignments + "$uncheckedMethodName()" + guarantees + updatePorts),

                        JavaMethod(name = uncheckedMethodName,
                                type = javaVoidType,
                                abstract = true)
                ))
    }

    private fun javaUpdatePortValue(it: AadlConnection): String =
            "${JavaName(it.destObjectName)}.${JavaName(it.destPortName)}.set(${it.srcPortName}.get())"

    private fun String.alignMethodCalls(): String = when {
        "[[" in this -> {

            val fullFunName = substringAfter("[[").substringBefore("//")
            val (packageName, funName) = fullFunName.split(".").let { it[0] to it[1] }
            val fieldNumber: Int = substringAfter("//").substringBefore("]]").toInt()
            val field = agreeNodes[packageName]!![funName]!!.returns[fieldNumber].name

            substringBefore("[[") + ".$field" + substringAfter("]]")
        }
        else -> this
    }

    private fun String.asUnCheckedMethodName() = "unchecked_$this"
    private fun String.asCheckedMethodName() = "checked_$this"

    private fun buildStubClass(name: String) =
            JavaClass(
                    name = name.asCheckedMethodName(),
                    superClass = name)
                .apply {
                    methods.add(JavaMethod(
                            name = name.asUnCheckedMethodName(),
                            type = javaVoidType))
        }

    private fun String.asJavaMemoryObject(): String {
        val innerType = when(this) {
            "boolean" -> "Boolean"
            "int" -> "Integer"
            "double" -> "Double"
            "float" -> "Float"
            else -> this
        }
        return "AadlMemoryObject<$innerType>"
    }

    private fun List<AgreeCondition>.asJavaAssertions() = this.map { "assert ${it.expr.alignMethodCalls()}" }

    override fun toString(): String = build().joinToString(separator = "\n\n")
}

