package javaast

import visitors.*

class JavaFromAgreeNodes(val agreeNodes: Map< String, Map<NodeName, AgreeNode>>) {

    private fun nodeToJava(nodeName: String, node: AgreeNode): Pair<JavaMethod, JavaClass> {

        val javaMethodType = nodeName.capitalize()

        val nodeAsMethod = JavaMethod(
                arguments = node.arguments.map { JavaValue(it.name, it.type) },
                name = nodeName,
                visibility = JavaVisibility.PUBLIC,
                type = javaMethodType,
                static = true,
                body = assignments(node) + returnCall(javaMethodType, node.returns))

        val nodeInterfaceClass = JavaClass(name = javaMethodType).apply {
            members += node.returns.map { JavaMember(name = it.name, type = it.type, initialValue = null) }
            addTrivialConstructor()
        }

        return nodeAsMethod to nodeInterfaceClass
    }

    private fun assignments(node: AgreeNode) =
            node.assignments.map { (value, expr) -> "${value.type} ${value.name} = ${expr.toJava()}" }

    private fun returnCall(returnType: String, returns: List<AgreeValue>) = "return new $returnType(${returns.joinToString(separator = ", ") {it.name}})"

    fun AgreeExpression.toJava() = when(this) {
        is AgreeIfExpression -> toJava()
        is AgreeOperationExpression -> toJava()
        is AgreeExpressionLiteral -> expr
        is AgreeFunctionCallExpression -> toJava()
        AgreeExpression -> error("Reached Empty.... might be bad....")
    }

    fun AgreeOperationExpression.toJava():String = "(${leftExpr.toJava()} ${operator.toJavaOperator()} ${rightExpr.toJava()})"

    fun AgreeIfExpression.toJava():String = "(${predicate.toJava()}) ? (" +
            trueBlock.toJava().indent() +
            ") : (" +
            falseBlock.toJava().indent() +
            ")"

    fun AgreeFunctionCallExpression.toJava() = "$functionName(" +
            functionArgs.joinToString(separator = ", ") +
            ")"

    fun String.toJavaOperator() = when(this) {
        "and" -> "&&"
        "or" -> "||"
        else -> this
    }

    fun build(): String {

        val translatedMethods = mutableListOf<JavaMethod>()
        val helperClasses = mutableListOf<JavaClass>()
        val allClasses = mutableListOf<JavaClass>()

        for (pkg in agreeNodes) {
            for (pair in pkg.value) {
                val methodAndClass = nodeToJava(pair.key, pair.value)
                translatedMethods += methodAndClass.first
                helperClasses += methodAndClass.second
            }

            val allTranslatedMethodsClass = JavaClass(name = pkg.key, methods = translatedMethods)
            allClasses += helperClasses + allTranslatedMethodsClass
        }


        return allClasses.joinToString(separator = "\n\n")
    }

}
fun String.indent(): String = lines().indent()
fun List<String>.indent(): String = map { "\n    $it" }.joinToString(separator = "") + "\n"

