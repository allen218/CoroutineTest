package suspend

import kotlin.coroutines.Continuation
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext
import kotlin.coroutines.startCoroutine

fun main() {
    block.startCoroutine(myContinuation)
}

val block: suspend () -> String = {
    println("block run")
    "block return"
}

val myContinuation = object : Continuation<String> {
    override val context: CoroutineContext
        get() = EmptyCoroutineContext

    override fun resumeWith(result: Result<String>) {
        println("myContinuation run, result: ${result.getOrNull()}")
    }
}