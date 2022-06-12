package suspend

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlin.coroutines.Continuation
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext
import kotlin.coroutines.startCoroutine

fun main() {
    block.startCoroutine(myContinuation)

    Thread.sleep(5000)
}

val block: suspend () -> String = {
    println("${Thread.currentThread().name} - block run")
    val test1 = suspendMethod1()
    val test2 = suspendMethod2()

    println("${Thread.currentThread().name} - test1 + test2: ${test1 + test2}")
    "block return"
}

val myContinuation = object : Continuation<String> {
    override val context: CoroutineContext
        get() = EmptyCoroutineContext

    override fun resumeWith(result: Result<String>) {
        println("${Thread.currentThread().name} - myContinuation run, result: ${result.getOrNull()}")
    }
}

suspend fun suspendMethod1(): String {
    delay(1000)
    return "suspendMethod1"
}

suspend fun suspendMethod2(): String {
    delay(1000)
    return "suspendMethod2"
}