package aadl

abstract class IRTree<T> {

    abstract var body: T?
    abstract val children: MutableList<IRTree<T>>?

    fun addChild(ctx: IRTree<T>) {
        children?.add(ctx)
    }

    fun addLeaf(elem: T) {
        children?.add(IRNode(elem))
    }

    fun addChildren(newChildren: Iterable<IRTree<T>>) {
        children?.addAll(newChildren)
    }

    fun prune() {
        children?.forEach { it.prune() }
        children?.removeIf { c -> c.children.isNullOrEmpty() && c.body == null }

        if (children?.size == 1 && body == null) {
            children?.apply {
                val singleChild = get(0)
                clear()
                addAll(singleChild.children ?: listOf())
                body = singleChild.body
            }
        }
    }

    override fun toString(): String {
        return body?.toString() ?: ""
    }
}

//class IRLeaf<T>(override var body: T? = null) : IRTree<T>() {
//
//    override val children: MutableList<IRTree<T>>? =  null
//}

class IRNode<T>(override var body: T? = null): IRTree<T>() {

    override val children: MutableList<IRTree<T>> = mutableListOf()
}

fun <T> IRTree<T>.prettyString(): String =

        if (this.children.isNullOrEmpty()) {
            "\"$this\"\n"
        } else {
            "\"$this\" --> \n" + children?.joinToString(separator = "\n") { child ->
                child.prettyString().lines().joinToString(separator = "\n") { line -> "    $line" }
            }
        }