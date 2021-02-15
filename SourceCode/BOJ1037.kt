fun main() {
	val n = readLine()!!.toInt()
	val arr = readLine()!!.split(" ").map { it.toInt() }.toIntArray()
	arr.sort()
	println(arr[0] * arr[arr.lastIndex])
}