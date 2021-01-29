fun main() {
	var n = readLine()!!.split(" ").map { it.toInt() }.toIntArray()
	val coin = IntArray(n[0]) { readLine()!!.toInt() }
	var count = 0
	for (i in n[0] - 1 downTo 0) {
		if (n[1] == 0)
			break
		else if (n[1] / coin[i] != 0) {
			count += n[1] / coin[i]
			n[1] -= (n[1] / coin[i]) * coin[i]
		}
	}
	print(count)
}