import java.math.BigInteger

val arr = Array<IntArray>(1001) { IntArray(3) { 0 } }
val cost = Array<Array<BigInteger>>(1001) { Array<BigInteger>(3) { "-1".toBigInteger() } }
fun main() {
	val n = readLine()!!.toInt()
	repeat(n) { it ->
		arr[it + 1] = readLine()!!.split(" ").map { num -> num.toInt() }.toIntArray()
	}
	cost[1][0] = arr[1][0].toBigInteger()
	cost[1][1] = arr[1][1].toBigInteger()
	cost[1][2] = arr[1][2].toBigInteger()

	for (i in 2..n) {
		cost[i][0] = min(cost[i - 1][1], cost[i - 1][2]) + arr[i][0].toBigInteger()
		cost[i][1] = min(cost[i - 1][0], cost[i - 1][2]) + arr[i][1].toBigInteger()
		cost[i][2] = min(cost[i - 1][0], cost[i - 1][1]) + arr[i][2].toBigInteger()
	}

	print(cost[n].minOf { it })
}

fun min(n1: BigInteger, n2: BigInteger): BigInteger = if (n1 > n2) n2 else n1