fun main() {
	while (true) {
		val arr = readLine()!!.split(" ").map { it.toInt() }.toIntArray()
		if (arr[0] == 0 && arr[1] == 0)
			break
		when {
			arr[1] % arr[0] == 0 -> println("factor")
			arr[0] % arr[1] == 0 -> println("multiple")
			else -> println("neither")
		}
	}
}