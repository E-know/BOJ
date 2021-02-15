fun main() {
	val n = readLine()!!.split(" ").map { it.toInt() }
	val min = n.minOf { it }
	val max = n.maxOf { it }
	for (i in min downTo 1){
		if (n[0] % i == 0 && n[1] % i == 0) {
			println(i)
			break
		}
	}

	for(i in 1..10000){
		if((min * i) % max == 0){
			println(min * i)
			break
		}
	}
}