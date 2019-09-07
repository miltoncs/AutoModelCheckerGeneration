package visitors

import antlr.aadl.*

data class AgreeValue(val name: String, var type: String)

typealias AadlObjectName = String

class AgreePackageValuesVisitor: AadlBaseVisitor<Map<AadlObjectName, List<AgreeValue>>>() {

    override fun visitObject(ctx: AadlParser.ObjectContext?): Map<String, List<AgreeValue>> {

        val name = ctx?.IDENTIFIER(0)?.text ?: ""

        return mapOf(name to AgreeValuesVisitor().visit(ctx))
    }

    override fun aggregateResult(a: Map<String, List<AgreeValue>>, b: Map<String, List<AgreeValue>>): Map<String, List<AgreeValue>> = a + b

    override fun defaultResult(): Map<String, List<AgreeValue>> = mapOf()
}

class AgreeValuesVisitor : AadlBaseVisitor<List<AgreeValue>>() {

    override fun visitAssign(ctx: AadlParser.AssignContext?): List<AgreeValue> {
        return listOf()
    }

    override fun visitVar_declaration(ctx: AadlParser.Var_declarationContext): List<AgreeValue> {

        val type: String = if (ctx.type() == null)
        {
            "Object"
        }
        else {
            TypeVisitor().visitType(ctx.type())
        }

        return listOf(AgreeValue(ctx.IDENTIFIER().text, type))
    }

    override fun aggregateResult(a: List<AgreeValue>, b: List<AgreeValue>): List<AgreeValue> = a + b

    override fun defaultResult(): List<AgreeValue> = listOf()
}
