package constructs

typealias NodeName = String

data class AgreeValue(val name: String, var type: String)

data class AgreeNode(val arguments: List<AgreeValue>,
                     val returns: List<AgreeValue>,
                     val assignments: Map<AgreeValue, AgreeExpression>)

sealed class AgreeExpression {

    companion object Empty: AgreeExpression()
}

data class AgreeOperationExpression(val leftExpr: AgreeExpression, val operator: String, val rightExpr: AgreeExpression): AgreeExpression()

data class AgreeFunctionCallExpression(val functionName: String, val functionArgs: List<AgreeExpression> = listOf()): AgreeExpression()

data class AgreeExpressionLiteral(val expr: String): AgreeExpression()

data class AgreeIfExpression(val predicate: AgreeExpression,
                             val trueBlock: AgreeExpression,
                             val falseBlock: AgreeExpression): AgreeExpression()

data class AgreeCondition(val type: ConditionType, val expr: String, val operands: List<String>) {
    enum class ConditionType { ASSUME, GUARANTEE, ASSIGNMENT }
    override fun toString(): String = expr
}