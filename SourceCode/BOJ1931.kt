fun main() {
	val n = readLine()!!.toInt()
	val arr = Array<IntArray>(n) { readLine()!!.split(" ").map { it.toInt() }.toIntArray() }
	var ableStartTime: Int = 0
	var count = 0

	arr.sortWith(Comparator { a, b ->
		if(a[1] > b[1])
			1
		else if(a[1] == b[1] && a[0] >= b[0])
			1
		else
			-1

	})

	repeat(n) { i ->
		if (arr[i][0] >= ableStartTime) {
			ableStartTime = arr[i][1]
			count++
		}
	}
	print(count)
}