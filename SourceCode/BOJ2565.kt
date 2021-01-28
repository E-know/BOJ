import java.util.*

fun main() {
	val n = readLine()!!.toInt()
	val sc = Scanner(System.`in`)
	val arr = Array<IntArray>(n){ IntArray(2) }
	val dp = IntArray(n) { 1 }
	var max = 0
	repeat(n) { it ->
		arr[it][0] = sc.nextInt()
		arr[it][1] = sc.nextInt()
	}
	arr.sortBy { it[0] }


	for (i in 0 until n) {
		for (j in i - 1 downTo 0) {
			if (dp[j] >= dp[i] && arr[i][1] > arr[j][1])
				dp[i] = dp[j] + 1
		}
	}

	print(n - dp.maxOf { it })
}