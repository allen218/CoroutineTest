import kotlinx.coroutines.*
import kotlin.coroutines.EmptyCoroutineContext

fun main() {
    testLaunch()
    Thread.sleep(4000)
    var test = "aaaabb"
    val array = test.toCharArray()
    array.size
    println(test.split(" "))
    println(array[0])

    for (i in 0..2) {

    }
}

fun testLaunch() {
    val launch = CoroutineScope(Dispatchers.IO).launch {
        println(Thread.currentThread().name)
        val user = getUser()
        val friendList = getFriendList(user)
        val feedList = getFeedList(friendList)
        println(feedList)
    }

    launch.fold(EmptyCoroutineContext) { emptyCoroutineContext, element ->


        emptyCoroutineContext
    }

    launch.cancel()
}

suspend fun getFeedList(friendList: String): String {
    delay(1000)

    return "FeedList....."
}

suspend fun getFriendList(user: String): String {
    delay(1000)

    return "Jack, Tom, Elon"
}

suspend fun getUser(): String {
    delay(1000)

    return "CowBoy"
}