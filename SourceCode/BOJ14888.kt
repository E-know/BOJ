import kotlin.math.max
import kotlin.math.min

var max: Int? = null
var min: Int? = null

fun main() {
	val n = readLine()!!.toInt()
	val arr = readLine()!!.split(" ").map { it.toInt() }.toIntArray()
	val ope = readLine()!!.split(" ").map { it.toInt() }.toIntArray()
	insertion(arr, ope, 0, arr[0])
	println(max)
	println(min)
}


fun insertion(nums: IntArray, ope: IntArray, level: Int, result: Int, o: Char? = null) {
	if (level + 1 >= nums.size) {
		if (max == null) {
			max = result
		}
		if (min == null) {
			min = result
		}
		max = max(max!!, result)
		min = min(min!!, result)
		return
	}

	when (o) {
		'+' -> ope[0]--
		'-' -> ope[1]--
		'*' -> ope[2]--
		'/' -> ope[3]--
	}

	for (i in 0 until 4) {
		if (ope[i] == 0)
			continue
		when (i) {
			0 -> { // +
				insertion(nums, ope.clone(), level + 1, result + nums[level + 1], '+')
			}
			1 -> {// -
				insertion(nums, ope.clone(), level + 1, result - nums[level + 1], '-')
			}
			2 -> {// X
				insertion(nums, ope.clone(), level + 1, result * nums[level + 1], '*')
			}
			3 -> {// /
				insertion(nums, ope.clone(), level + 1, result / nums[level + 1], '/')
			}
		}
	}
}
