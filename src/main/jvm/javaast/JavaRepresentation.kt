package javaast

import visitors.AgreeCondition


enum class JavaVisibility {
    PUBLIC {
        override fun toString() = "public"
    },
    PRIVATE {
        override fun toString() = "private"
    },
    PROTECTED {
        override fun toString() = "protected"
    },
    PACKAGE_PROTECTED {
        override fun toString() = ""
    }}


class JavaName(unJavaName: String) {

    private val javaName: String = unJavaName.let{
        var result = it.replace(Regex("[.:-]"), "_")

        if (result.firstOrNull()?.isDigit() == true) {
            result = "Num$result"
        }

        result
    }

    override fun toString() = javaName
}

abstract class JavaNamedConstruct(name: String, type: String) {
    val name = JavaName(name)
    val type = JavaName(type)
}


class JavaClass(val abstract: Boolean = false,
                     name: String,
                     superClass: String = "",
                     val members: MutableList<JavaMember> = mutableListOf(),
                     val methods: MutableList<JavaMethod> = mutableListOf()) : JavaNamedConstruct(name = name, type = superClass) {

    private val superClass = type

    override fun toString() = "${abstract()}class $name ${superClass()} {${members()}${methods()}\n}"

    private fun abstract() = if (abstract) "abstract " else ""
    private fun superClass() = if (superClass.toString() != "") "extends $superClass" else ""
    private fun members() =  members.map { "$it" }.indent()
    private fun methods() = methods.map { "$it" }.indent()

    fun addTrivialConstructor() {
        methods += JavaMethod(
                visibility = JavaVisibility.PUBLIC,
                name = name.toString(),
                type = "",
                arguments = members.map { JavaValue("${it.name}", it.type.toString()) },
                body = members.map { "this.${it.name} = ${it.name}" }
        )
    }
}

class JavaMember(name: String,
                      type: String,
                      val initialValue: String? = "new $type()",
                      val visibility: JavaVisibility = JavaVisibility.PACKAGE_PROTECTED,
                      val static: Boolean = false) : JavaNamedConstruct(name = name, type = type) {

    override fun toString() = "${visibility()}${static()}$type $name${initialValue()};"
    private fun visibility() = if (visibility.toString() == "") "" else "$visibility "
    private fun static() = if (static) "static " else ""
    private fun initialValue() = (if (initialValue != null) " = $initialValue" else "")
}

class JavaMethod(name: String,
                      type: String,
                      val arguments: List<JavaValue> = listOf(),
                      val body: List<String> = listOf(),
                      val abstract: Boolean = false,
                      val visibility: JavaVisibility = JavaVisibility.PACKAGE_PROTECTED,
                      val static: Boolean = false) : JavaNamedConstruct(name = name, type = type){

    override fun toString() = "${visibility()}${static()}${abstract()}$type $name(${args()})${body()}\n".indent()

    private fun visibility() = if (visibility.toString() == "") "" else "$visibility "
    private fun static() = if (static) "static " else ""
    private fun abstract() = if (abstract) "abstract " else ""
    private fun args() = arguments.joinToString(separator = ", ")
    private fun body() = if (abstract) ";" else " {" + body.map {"$it;"}.indent() + "}"
}

class JavaValue(name: String, type: String): JavaNamedConstruct(name = name, type = type) {
    override fun toString() = "$type $name"
}
