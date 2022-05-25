package builders

import java.util.HashMap

fun <K,V> buildMutableMap(build: HashMap<K, V>.() -> Unit) :Map<K, V> {
    val hashMap = HashMap<K,V>()
    hashMap.build()
    return hashMap
}
fun usage(): Map<Int, String> {
    return buildMutableMap {
        put(0, "0")
        for (i in 1..10) {
            put(i, "$i")
        }
    }
}

fun <T> T.myApply(f: T.() -> Unit): T {
    return this
}

fun createString(): String {
    return StringBuilder().myApply {
        append("Numbers: ")
        for (i in 1..10) {
            append(i)
        }
    }.toString()
}

fun createMap(): Map<Int, String> {
    return hashMapOf<Int, String>().myApply {
        put(0, "0")
        for (i in 1..10) {
            put(i, "$i")
        }
    }
}