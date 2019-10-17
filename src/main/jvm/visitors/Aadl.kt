package visitors

import constructs.AadlPort.PortType
import antlr.aadl.*
import constructs.*

class StructureVisitor : AadlBaseVisitor<Map<AadlObjectName, AadlObject>>() {

    override fun visitObject(ctx: AadlParser.ObjectContext): Map<String, AadlObject> {
        val subcomponentMapping = SubcomponentVisitor().visit(ctx)
        val objectName: String = ctx.IDENTIFIER(0).text

        val objectStructure = StructureInnerVisitor(subcomponentMapping, objectName).visit(ctx)

        return mapOf(objectName to objectStructure)
    }

    override fun aggregateResult(aggregate: Map<String, AadlObject>, nextResult: Map<String, AadlObject>): Map<String, AadlObject> = aggregate + nextResult

    override fun defaultResult(): Map<String, AadlObject> = mapOf()
}

class SubcomponentVisitor: AadlBaseVisitor<Map<String, String>>() {

    override fun visitSubcomponent(ctx: AadlParser.SubcomponentContext): Map<String, String> {
        return mapOf(ctx.IDENTIFIER(0).text to ctx.IDENTIFIER(1).text)
    }

    override fun aggregateResult(aggregate: Map<String, String>, nextResult: Map<String, String>): Map<String, String> = aggregate + nextResult

    override fun defaultResult(): Map<String, String> = mapOf()
}

class StructureInnerVisitor(val subcomponentMapping: Map<String, String>, val currentPackageName: String) : AadlBaseVisitor<AadlObject>() {

    override fun visitPort(ctx: AadlParser.PortContext): AadlObject {

        val varName = ctx.IDENTIFIER().text
        val varType = TypeVisitor().visit(ctx.type())
        val portType: PortType = if (ctx.PORT_TYPE().text == "in") PortType.IN else PortType.OUT

        return AadlPort(varName, varType, portType).asContext()
    }

    override fun visitConnection(ctx: AadlParser.ConnectionContext): AadlObject {

        val connName = ctx.IDENTIFIER(0).text
        val src = ctx.IDENTIFIER(1).text.split(".").toMutableList()
        val dest = ctx.IDENTIFIER(2).text.split(".").toMutableList()

        if (src.size == 1) {
            src.add(1, src[0])
            src[0] = currentPackageName
        } else {
            if (src[0] in subcomponentMapping) {
                src[0] = subcomponentMapping[src[0]]!!
            }
        }

        if (dest.size == 1) {
            dest.add(1, dest[0])
            dest[0] = currentPackageName
        } else {
            if (dest[0] in subcomponentMapping) {
                dest[0] = subcomponentMapping[dest[0]]!!
            }
        }

        return AadlConnection(connName = connName,
                srcObjectName = src[0],
                srcPortName = src[1],
                destObjectName = dest[0],
                destPortName = dest[1])
                .asContext()
    }

    override fun visitSubcomponent(ctx: AadlParser.SubcomponentContext): AadlObject {

        val instanceName = ctx.IDENTIFIER(0).text
        val compType = ctx.objectType().text
        val compName = ctx.IDENTIFIER(1).text

        return AadlSubcomponent(instanceName, compType, compName).asContext()
    }

    override fun aggregateResult(aggregate: AadlObject, nextResult: AadlObject): AadlObject = aggregate + nextResult

    override fun defaultResult(): AadlObject = AadlObject()
}

class TypeVisitor: AadlBaseVisitor<String>() {

    override fun visitType(ctx: AadlParser.TypeContext): String =
        when(ctx.IDENTIFIER().last().text) {
            "real" -> "Double"
            "bool" -> "Boolean"
            else -> ctx.text
    }
}

fun Map<AadlObjectName, AadlObject>.combineObjects(): Map<AadlObjectName, AadlObject> =
        this.filterKeys { !it.endsWith(".impl") }
                .mapValues { removeImpl(this[it.key]!! + this[it.key + ".impl"]!!) }

private fun removeImpl(obj: AadlObject): AadlObject = obj.apply {
    for (connection in connections) {
        connection.destObjectName = connection.destObjectName.removeSuffix(".impl")
        connection.srcObjectName = connection.srcObjectName.removeSuffix(".impl")
    }
}

fun Map<AadlObjectName, AadlObject>.propagateConnections(): Map<AadlObjectName, AadlObject> = this.apply {
    for (obj in values) {
        for (sc in obj.subcomponents) {
            this[sc.objectName]?.let {
                it.connections += obj.connections
            }
        }
    }
}