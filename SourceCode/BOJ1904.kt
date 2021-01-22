val arr = IntArray(1000001) { 0 }

fun main() {
	arr[0] = 0
	arr[1] = 1
	arr[2] = 2
	tile(readLine()!!.toInt())
}

fun tile(n: Int) {

	for (i in 3..n) {
		arr[i] = arr[i - 1] + arr[i - 2]
		arr[i] %= 15746
	}

	print(arr[n])
}