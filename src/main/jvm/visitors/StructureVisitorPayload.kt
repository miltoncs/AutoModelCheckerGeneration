package visitors

data class AadlObject(var features: List<AadlFeature> = listOf(),
                      var connections: List<AadlConnection> = listOf(),
                      var subcomponents: List<AadlSubcomponent> = listOf()) {

    operator fun plus(other: AadlObject): AadlObject =
            AadlObject(
                    features + other.features,
                    connections + other.connections,
                    subcomponents + other.subcomponents)
}

abstract class AadlFeature

data class AadlPort(val name: String, val type: String, val portType: PortType): AadlFeature() {
    fun asContext(): AadlObject = AadlObject(features = listOf(this))
    enum class PortType { IN, OUT }
}


data class AadlConnection(val connName: String, var srcObjectName: String, val srcPortName: String, var destObjectName: String, val destPortName: String) {
    fun asContext(): AadlObject = AadlObject(connections = listOf(this))
}

data class AadlSubcomponent(val instanceName: String, val objectType: String, val objectName: String) {
    fun asContext(): AadlObject = AadlObject(subcomponents = listOf(this))
}

