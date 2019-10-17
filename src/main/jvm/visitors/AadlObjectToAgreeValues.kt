package visitors

import antlr.aadl.*
import constructs.AadlObjectName
import constructs.AgreeValue

class AadlObjectToAgreeValues: AadlBaseVisitor<Map<AadlObjectName, List<AgreeValue>>>() {

    override fun visitObject(ctx: AadlParser.ObjectContext?): Map<String, List<AgreeValue>> {

        val name = ctx?.IDENTIFIER(0)?.text ?: ""

        return mapOf(name to AgreeValuesVisitor().visit(ctx))
    }

    override fun aggregateResult(a: Map<String, List<AgreeValue>>, b: Map<String, List<AgreeValue>>): Map<String, List<AgreeValue>> = a + b

    override fun defaultResult(): Map<String, List<AgreeValue>> = mapOf()
}
