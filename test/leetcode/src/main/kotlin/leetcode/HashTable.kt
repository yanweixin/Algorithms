package leetcode

class HashTable {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val map = hashMapOf<Int, Int>()
        for (i in nums.indices) {
            val complement = target - nums[i]
            if (map.containsKey(complement)) {
                return intArrayOf(map[complement] ?: error("Null exception"), i)
            }
            map[nums[i]] = i
        }
        throw IllegalArgumentException("No two sum solution")
    }
}