fun main() {
	val n = readLine()!!.toInt()
	val arr = readLine()!!.split(" ").map { it.toInt() }.toIntArray()
	val dp = Array<IntArray>(2) { IntArray(n) { 1 } }

	for (i in 0 until n) {
		for (j in i - 1 downTo 0) {
			if (dp[0][j] >= dp[0][i] && arr[i] > arr[j])
				dp[0][i] = dp[0][j] + 1
		}
	}

	for (i in n - 1 downTo 0) {
		for (j in i until n) {
			if (dp[1][j] >= dp[1][i] && arr[i] > arr[j])
				dp[1][i] = dp[1][j] + 1
		}
	}

	for(i in 0 until n){
		dp[0][i] += dp[1][i]
	}

	print(dp[0].maxOf { it } - 1)
}