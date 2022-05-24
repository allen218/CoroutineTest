import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
        launch { testSuspend() }
    }
}

suspend fun testSuspend(): String {
    delay(1000)
    return "Jack"
}