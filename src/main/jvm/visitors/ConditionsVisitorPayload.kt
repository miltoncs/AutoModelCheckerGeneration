package visitors

data class AgreeCondition(val type: ConditionType, val expr: String, val operands: List<String>) {
    enum class ConditionType { ASSUME, GUARANTEE, EQ }
    override fun toString(): String = expr
}