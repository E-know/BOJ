fun main() {
	val n = readLine()!!.toInt()
	val time = readLine()!!.split(" ").map { it.toInt() }.toIntArray()

	time.sort()

	var sum = 0
	for(i in time.indices){
		sum += time[i] * ((time.size) - i)
	}
	print(sum)
}