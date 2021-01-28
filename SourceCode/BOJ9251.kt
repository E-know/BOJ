import kotlin.math.max

fun main() {
	val s1 = readLine()!!
	val s2 = readLine()!!
	val dp = Array<IntArray>(s1.length+1) { IntArray(s2.length+1) { 0 } }


	for (y in 1..s1.length) {
		for (x in 1..s2.length) {
			if(s1[y-1] == s2[x-1])
				dp[y][x] = dp[y-1][x-1] + 1
			else
				dp[y][x] = max(dp[y-1][x],dp[y][x-1])
		}
	}
	println(dp[s1.length][s2.length])
}