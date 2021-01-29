import kotlin.math.max

fun main() {
	val n = readLine()!!.split(" ").map { it.toInt() }
	val arr = Array<IntArray>(n[0] + 1) { IntArray(2) { 0 } }

	repeat(n[0]) {
		arr[it + 1] = readLine()!!.split(" ").map { num -> num.toInt() }.toIntArray()
	}
	arr.sortBy { it[0] }
	val dp = Array<IntArray>(n[0] + 1) { IntArray(n[1] + 1) { 0 } }

	for (i in 1..n[0]) {
		for (w in 1..n[1]) {
			if(w-arr[i][0] >= 0)
				dp[i][w] = max(dp[i - 1][w], dp[i - 1][w - arr[i][0]] + arr[i][1])
			else
				dp[i][w] = dp[i-1][w]
		}
	}

	print(dp[n[0]][n[1]])
}