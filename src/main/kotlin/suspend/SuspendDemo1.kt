import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlin.coroutines.Continuation
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext

fun main() {
    val coroutineScope = CoroutineScope(EmptyCoroutineContext)
    coroutineScope.launch {
        // 协程体 block 调用
        testSuspend1()
    }
}

suspend fun testSuspend1(): String {
    // 另一个挂起函数调用
    testSuspend2()
    return ""
}

suspend fun testSuspend2() {

}

fun normalMethod() {
//    testSuspend2()
}