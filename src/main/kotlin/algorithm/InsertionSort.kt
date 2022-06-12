package algorithm

fun main() {
    val arr = intArrayOf(4, 2, 1, 3, 6)
    println(insertionSort(arr).toList())
}

fun insertionSort(nums: IntArray): IntArray {
    for (i in 0 until nums.size - 1) {
        var j = i + 1
        var k = i
        var unsortedFirst = nums[j]
        while (k >= 0) {
            if (nums[k] > unsortedFirst) {
                nums[j--] = nums[k]
            } else {
                break
            }

            k--
        }
        nums[j] = unsortedFirst
    }

    return nums
}