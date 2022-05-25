package generics

import java.util.*
import kotlin.collections.ArrayList


fun <T, K: MutableCollection<T>> Collection<T>.partitionTo(collection: K, anotherCollection: K, func: (T) -> Boolean): Pair<K,K>
    {
       forEach {
            if(func(it)){
                collection.add(it)
            } else {
                anotherCollection.add(it)
            }
       }
        return Pair(collection, anotherCollection)
    }

fun partitionWordsAndLines() {
    val (words, lines) = listOf("a", "a b", "c", "d e")
        .partitionTo(ArrayList(), ArrayList()) { s -> !s.contains(" ") }
    check(words == listOf("a", "c"))
    check(lines == listOf("a b", "d e"))
}

fun partitionLettersAndOtherSymbols() {
    val (letters, other) = setOf('a', '%', 'r', '}')
        .partitionTo(HashSet(), HashSet()) { c -> c in 'a'..'z' || c in 'A'..'Z' }
    check(letters == setOf('a', 'r'))
    check(other == setOf('%', '}'))
}