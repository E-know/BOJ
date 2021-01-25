fun main() {
	val n = readLine()!!.toInt()
	val cost = IntArray(n + 1) { it-1 }

	for (i in 2..n) {
		if (i % 3 == 0) {
			if (cost[i] > cost[i / 3] + 1)
				cost[i] = cost[i / 3] + 1
		}
		if (i % 2 == 0) {
			if (cost[i] > cost[i / 2] + 1)
				cost[i] = cost[i / 2] + 1
		}
		if (cost[i] > cost[i - 1] + 1)
			cost[i] = cost[i - 1] + 1
	}
	print(cost[n])
}