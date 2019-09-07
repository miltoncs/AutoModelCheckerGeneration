package visitors

import org.antlr.v4.runtime.tree.TerminalNode
import antlr.aadl.*

class AgreeNodeVisitor: AadlBaseVisitor<Map<String, Map<NodeName, AgreeNode>>>() {

    override fun visitAadlPackage(ctx: AadlParser.AadlPackageContext): Map<String, Map<NodeName, AgreeNode>> {
        return mapOf(ctx.IDENTIFIER(0).text to AgreeNodeInnerVisitor().visit(ctx.packageBody()))
    }

    override fun defaultResult(): Map<String, Map<NodeName, AgreeNode>> = mapOf()
    override fun aggregateResult(a: Map<String, Map<NodeName, AgreeNode>>, b: Map<String, Map<NodeName, AgreeNode>>) = a + b
}

class AgreeNodeInnerVisitor: AadlBaseVisitor<Map<NodeName, AgreeNode>>(){

    override fun visitAgree_node(ctx: AadlParser.Agree_nodeContext): Map<NodeName, AgreeNode> {

        val arguments = AgreeValuesVisitor().visit(ctx.var_list(0))

        val returns = AgreeValuesVisitor().visit(ctx.var_list(1))

        val assignments = ctx.node_body().assignment()
                .associate {
                    AgreeValuesVisitor().visit(it)[0] to AgreeNodeExpressionVisitor().visit(it.expression())
                }

        assignments.keys.forEach { value ->

            (arguments + returns).firstOrNull { it.name == value.name }?.let {
                value.type = it.type
            }
        }

        val node = AgreeNode(
                arguments = arguments,
                returns = returns,
                assignments = assignments)

        return mapOf(ctx.IDENTIFIER().text to node)
    }

    override fun defaultResult(): Map<NodeName, AgreeNode> = mapOf()

    override fun aggregateResult(a: Map<NodeName, AgreeNode>, b: Map<NodeName, AgreeNode>) = a + b
}

class AgreeNodeExpressionVisitor: AadlBaseVisitor<AgreeExpression>() {

    override fun visitExpression(ctx: AadlParser.ExpressionContext): AgreeExpression = when {
                ctx.operation() == null -> visit(ctx.leftHandSide())
                else -> AgreeOperationExpression(visit(ctx.leftHandSide()), ctx.operation().text, visit(ctx.expression()))
            }

    override fun visitIf_expression(ctx: AadlParser.If_expressionContext) =
            AgreeIfExpression(
                    predicate = visit(ctx.expression(0)),
                    trueBlock = visit(ctx.expression(1)),
                    falseBlock = visit(ctx.expression(2)))

    override fun visitFunction_call(ctx: AadlParser.Function_callContext): AgreeExpression =
            AgreeFunctionCallExpression(ctx.IDENTIFIER().text, ctx.expression().map { visit(it) })

    override fun visitTerminal(node: TerminalNode) = when {
        node.text in "()" -> AgreeExpression.Empty
        else -> AgreeExpressionLiteral(node.text)
    }

    override fun defaultResult(): AgreeExpression = AgreeExpression.Empty

    override fun aggregateResult(a: AgreeExpression, b: AgreeExpression) = when {
        a == AgreeExpression.Empty && b == AgreeExpression.Empty -> AgreeExpression.Empty
        a == AgreeExpression.Empty -> b
        b == AgreeExpression.Empty -> a
        else -> error("Can't combine expressions!   $a   $b")
    }
}
