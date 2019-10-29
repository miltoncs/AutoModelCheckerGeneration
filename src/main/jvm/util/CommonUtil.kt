package util

fun String.add(before: String? = null, after: String? = null, startIndex: Int = 0, count: Int = length, alwaysAdd: Boolean = false, addition: String): String =
        when {
            count <= 0 -> this
            startIndex > 0 -> substring(startIndex..length).add(before, after, 0, count, alwaysAdd, addition)
            else -> when {
                before != null && before !in this -> this
                before != null -> substringBefore(before) + addition + before + substringAfter(before)
                after != null && after !in this -> this
                after != null -> substringBefore(after) + after + addition + substringAfter(after)
                else -> this + addition
            }
        }