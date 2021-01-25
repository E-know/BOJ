fun main() {
	val n = readLine()!!.toInt()
	val arr = Array<LongArray>(n + 1) { LongArray(10) { if (it == 0) 0 else 1 } }

	for (i in 2..n) {
		arr[i][0] = arr[i - 1][1] % 1000000000
		arr[i][9] = arr[i - 1][8] % 1000000000

		for (j in 1..8) {
			arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j + 1]
			arr[i][j] = arr[i][j] % 1000000000
		}
	}
	print(arr[n].sum() % 1000000000)
}
