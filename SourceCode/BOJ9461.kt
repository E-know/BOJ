import java.math.BigInteger

val arr = Array<BigInteger>(101) { BigInteger.ONE }
fun main() {
	arr[4] = "2".toBigInteger()
	arr[5] = "2".toBigInteger()
	repeat(readLine()!!.toInt()) {
		println(padoban(readLine()!!.toInt()))
	}
}

fun padoban(n: Int): BigInteger {
	if (n < 6)
		return arr[n]
	for (i in 6..n) {
		arr[i] = arr[i - 5] + arr[i - 1]
	}
	return arr[n]
}