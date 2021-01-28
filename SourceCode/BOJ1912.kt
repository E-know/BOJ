fun main() {
	val n = readLine()!!.toInt()
	val arr = readLine()!!.split(" ").map { it.toInt() }.toIntArray()
	val dp = IntArray(n) { 0 }

	dp[0] = arr[0]

	for (i in 1 until arr.size) {
		if(dp[i-1] < 0){
			dp[i] = arr[i]
		}else{
			dp[i] = dp[i-1] + arr[i]
		}
	}
	print(dp.maxOf { it })
}