package visitors

import org.antlr.v4.runtime.tree.TerminalNode
import antlr.aadl.*

class ConditionsVisitor: AadlBaseVisitor<Map<String, List<AgreeCondition>>>() {

    override fun visitObject(ctx: AadlParser.ObjectContext?): Map<String, List<AgreeCondition>> {

        val name = ctx?.IDENTIFIER(0)?.text ?: ""

        return mapOf(name to ConditionsVisitorAssumeGuarantee().visit(ctx))
    }

    override fun aggregateResult(a: Map<String, List<AgreeCondition>>, b: Map<String, List<AgreeCondition>>): Map<String, List<AgreeCondition>> = a + b

    override fun defaultResult(): Map<String, List<AgreeCondition>> = mapOf()
}

class ConditionsVisitorAssumeGuarantee: AadlBaseVisitor<List<AgreeCondition>>() {

    override fun visitAssume(ctx: AadlParser.AssumeContext): List<AgreeCondition> =
            listOf(AgreeCondition(
                    type = AgreeCondition.ConditionType.ASSUME,
                    expr = ConditionsVisitorExpression().visit(ctx.expression()),
                    operands = ConditionsOperandVisitor().visit(ctx.expression())))

    override fun visitGuarantee(ctx: AadlParser.GuaranteeContext): List<AgreeCondition> =
            listOf(AgreeCondition(
                    type = AgreeCondition.ConditionType.GUARANTEE,
                    expr = ConditionsVisitorExpression().visit(ctx.expression()),
                    operands = ConditionsOperandVisitor().visit(ctx.expression())))

    override fun visitAssignment(ctx: AadlParser.AssignmentContext): List<AgreeCondition> =
            if (ctx.expression() != null) {
                listOf(AgreeCondition(
                        type = AgreeCondition.ConditionType.EQ,
                        expr = ConditionsVisitorExpression().visit(ctx.expression()),
                        operands = ctx.var_declaration().map { it.text }
                ))
            } else {
                listOf()
            }

    override fun aggregateResult(a: List<AgreeCondition>, b: List<AgreeCondition>): List<AgreeCondition> = a + b

    override fun defaultResult(): List<AgreeCondition> = listOf()
}

class ConditionsVisitorExpression: AadlBaseVisitor<String>() {

    override fun visitExpression(ctx: AadlParser.ExpressionContext): String =
            if (ctx.operation() != null
                    && "=>" in ctx.operation().text) {
                cleanImplicationStatements(ctx)
            } else {
                visitChildren(ctx)
            }

    private fun cleanImplicationStatements(ctx: AadlParser.ExpressionContext): String {
        val beforeImplication = ctx.leftHandSide()
        val afterImplication = ctx.expression()

        if ( !beforeImplication.text.startsWith("(")
                || !beforeImplication.text.endsWith(")")
                || !afterImplication.text.startsWith("(")
                || !afterImplication.text.endsWith(")")) {
            System.err.println("Warning! Parsing the implication operator '=>' Ensure the expression is in the " +
                    "form (a) => (b) or it may not parse correctly.")
        }

        return "(!(${visit(beforeImplication)}) || (${visit(afterImplication)}))"
    }

    //todo this logic doesn't really belong here but oh well
    override fun visitValue(ctx: AadlParser.ValueContext) = when (ctx.IDENTIFIER()) {
        null -> visitChildren(ctx)
        else -> " ${ctx.IDENTIFIER().text}.get() "
    }

    //todo this logic doesn't really belong here but oh well
    override fun visitFunction_call(ctx: AadlParser.Function_callContext) = when (ctx.IDENTIFIER().text) {
        "pre" -> "AadlUtil.${ctx.text}"
        else -> visitChildren(ctx)
    }

    override fun visitTerminal(node: TerminalNode): String =
            when (node.text) {
                "=" -> "=="
                "and" -> "&&"
                "or" -> "||"
                else -> node.text
            }

    override fun aggregateResult(a: String, b: String): String = a + b

    override fun defaultResult(): String = ""
}

class ConditionsOperandVisitor: AadlBaseVisitor<List<String>>() {

    override fun visitValue(ctx: AadlParser.ValueContext): List<String> = when {
                ctx.IDENTIFIER() != null -> listOf(ctx.IDENTIFIER().text)
                else -> visitChildren(ctx)
            }

    override fun aggregateResult(a: List<String>, b: List<String>): List<String> = a + b

    override fun defaultResult(): List<String> = listOf()
}