package algorithm

fun main() {
    val arr1 = intArrayOf(1, 3, 5, 7)
    val arr2 = intArrayOf(1, 2, 4, 5, 6)
    findMedianSortedArrays(arr1, arr2)
}

fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
    val m = nums1.size
    val n = nums2.size
    val left = (m + n + 1) / 2
    val right = (m + n + 2) / 2
    return (findKth(nums1, 0, nums2, 0, left) + findKth(nums1, 0, nums2, 0, right)) / 2.0
}

fun findKth(nums1: IntArray, i: Int, nums2: IntArray, j: Int, k: Int): Int {
    if (i >= nums1.size) return nums2[j + k - 1]
    if (j >= nums2.size) return nums1[i + k - 1]
    if (k == 1) return Math.min(nums1[i], nums2[j])
    val midVal1 = if (i + k / 2 - 1 < nums1.size) nums1[i + k / 2 - 1] else Int.MAX_VALUE
    val midVal2 = if (j + k / 2 - 1 < nums2.size) nums2[j + k / 2 - 1] else Int.MAX_VALUE
    return if (midVal1 < midVal2) {
        findKth(nums1, i + k / 2, nums2, j, k - k / 2)
    } else {
        findKth(nums1, i, nums2, j + k / 2, k - k / 2)
    }
}