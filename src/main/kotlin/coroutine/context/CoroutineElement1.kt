package coroutine.context

import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.AbstractCoroutineContextElement
import kotlin.coroutines.CoroutineContext

fun main() {
    // e1 + e3
    val el = CustomCoroutineElement1()
    val e3 = CustomCoroutineElement3()
    val r1 = el + e3
    println(r1)

    // e1 + e3 + e4
    val e4 = CustomCoroutineElement4()
    val r2 = r1 + e4
    println(r2)

    // add e3 twice
    val r3 = r1 + e3
    println(r3)

    // add a ContinuationInterceptor instance
    val r4 = r1 + Dispatchers.IO
    println(r4)
}

class CustomCoroutineElement1 : CoroutineContext.Element {
    override val key: CoroutineContext.Key<*>
        get() = object : CoroutineContext.Key<CustomCoroutineElement1> {}
}

//class CustomCoroutineElement2 : CoroutineContext.Element {
//    companion object key : CoroutineContext.Key<CustomCoroutineElement2>
//}

class CustomCoroutineElement3 : CoroutineContext.Element {
    companion object Key : CoroutineContext.Key<CustomCoroutineElement3>

    override val key: CoroutineContext.Key<*>
        get() = Key
}

class CustomCoroutineElement4 : AbstractCoroutineContextElement(CustomCoroutineElement4) {
    companion object Key : CoroutineContext.Key<CustomCoroutineElement4>
}

class CustomCoroutineElement5 : AbstractCoroutineContextElement(CustomCoroutineElement5) {
    companion object Key : CoroutineContext.Key<CustomCoroutineElement5>
}
