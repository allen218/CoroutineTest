package algorithm

fun main() {
    val arr = intArrayOf(5, 2, 3, 6, 4, 9, 7, 8, 1)
    quickSort(arr, 0, arr.size - 1)
    println(arr.toList())
}

fun quickSort(nums: IntArray, start: Int, end: Int) {
    if (start >= end) {
        return
    }
    val pivot = partition(nums, start, end)
    quickSort(nums, start, pivot - 1)
    quickSort(nums, pivot + 1, end)
}

fun partition(nums: IntArray, start: Int, end: Int): Int {
    val pivot = nums[end]
    var i = start
    var j = start

    for (j in start until end) {
        if (nums[j] < pivot) {
            swap(nums, i, j)
            i += 1
        }
    }

    swap(nums, i, end)
    return i
}

fun swap(nums: IntArray, i: Int, j: Int) {
    val tmp = nums[i]
    nums[i] = nums[j]
    nums[j] = tmp
}