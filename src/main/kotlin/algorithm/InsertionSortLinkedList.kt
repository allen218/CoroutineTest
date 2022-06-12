package algorithm

fun main() {
    val l4 = ListNode(3)
    val l3 = ListNode(1, l4)
    val l2 = ListNode(2, l3)
    val l1 = ListNode(4, l2)
    printListNode(l1)
    printListNode(insertionSortList(l1))
}

fun printListNode(insertionSortList: ListNode?) {
    var tmp: ListNode? = insertionSortList
    while (tmp != null) {
        println(tmp.`val`)
        tmp = tmp.next
    }
}

fun insertionSortList(head: ListNode?): ListNode? {
    var node = ListNode(-Int.MAX_VALUE)
    node.next = head
    var pre = node
    var cur = head
    var next = head?.next

    l1@ while (next?.next != null) {
       l2@ while (cur != next) {
            if (cur!!.`val` <= next.`val`) {
                pre = pre.next!!
                cur = cur.next
            } else {
                val tmp = next.next
                pre.next = next
                next.next = cur
                cur.next = tmp
                break@l2
            }
        }

        next = cur?.next
        println("${pre.`val`}, ${cur?.`val`}, ${next?.`val`}")
        pre = node
        cur = pre.next
    }

    return node.next
}

data class ListNode(
    val `val`: Int,
    var next: ListNode? = null
)