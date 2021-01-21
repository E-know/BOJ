import java.math.BigInteger

fun main() {
	val arr = readLine()!!.split(" ")
	val n1 : BigInteger = arr[0].toBigInteger()
	val n2 : BigInteger = arr[1].toBigInteger()
	println(n1+n2)
}
