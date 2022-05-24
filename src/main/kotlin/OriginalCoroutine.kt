import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlin.concurrent.thread
import kotlin.coroutines.*
import kotlin.coroutines.intrinsics.createCoroutineUnintercepted
import kotlin.coroutines.intrinsics.suspendCoroutineUninterceptedOrReturn
import kotlin.coroutines.intrinsics.COROUTINE_SUSPENDED

fun main() {
    val myCoroutine = MyCoroutine()
    val createCoroutine = launchSuspendLambdaBlock.createCoroutineUnintercepted(myCoroutine)
    createCoroutine.resume(Unit)
}

class MyCoroutine : Continuation<String> {
    override val context: CoroutineContext
        get() = EmptyCoroutineContext

    override fun resumeWith(result: Result<String>) {
        println("MyCoroutine resumeWith called: $result")
    }
}

val launchSuspendLambdaBlock: suspend () -> String = {
    val one = suspendMethod1()
    val two = suspendMethod2()
    val three = suspendMethod3()

    one + two + three
}

suspend fun suspendMethod1(): String {
    delay(1000)
    return "suspend1"
}

suspend fun suspendMethod2(): String {
    return "suspend2"
}

suspend fun suspendMethod3() = suspendCoroutineUninterceptedOrReturn<String> {
    thread {
        // task
        it.resume("suspend3")
    }

    COROUTINE_SUSPENDED
}