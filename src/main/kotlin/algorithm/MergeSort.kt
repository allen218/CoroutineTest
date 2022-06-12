package algorithm

fun main() {
    val arr = intArrayOf(3, 5, 2, 1, 6, 9, 8, 7, 4)
    mergeSort(arr, 0, arr.size - 1)
    println(arr.toList())
}

fun mergeSort(nums: IntArray, start: Int, end: Int) {
    if (start >= end) {
        return
    }
    var mid = (start + end) / 2
    mergeSort(nums, start, mid)
    mergeSort(nums, mid + 1, end)
    merge(nums, start, mid, end)
}

fun merge(nums: IntArray, start: Int, mid: Int, end: Int) {
    var k = 0
    val newArr = IntArray(end - start + 1) { 0 }
    var i = start
    var j = mid + 1
    while (i <= mid && j <= end) {
        if (nums[i] <= nums[j]) {
            newArr[k++] = nums[i++]
        } else {
            newArr[k++] = nums[j++]
        }
    }

    var s = i
    var e = mid
    if (j <= end) {
        s = j
        e = end
    }

    for (x in s..e) {
        newArr[k++] = nums[x]
    }

    for (y in 0 until k) {
        nums[start + y] = newArr[y]
    }
}