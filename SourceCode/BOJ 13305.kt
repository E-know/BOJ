import java.math.BigInteger

fun main() {
	val n = readLine()!!.toInt()
	val road = readLine()!!.split(" ").map { it.toInt() }.toIntArray()
	val city = readLine()!!.split(" ").map { it.toInt() }.toIntArray()
	//city[city.lastIndex] = 1000000001
	var gas: BigInteger = "0".toBigInteger()
	var money: BigInteger = "0".toBigInteger()
	var togo: BigInteger= "0".toBigInteger()

	for (i in road.indices) {
		if (gas == "0".toBigInteger()) {
			for (j in i until city.size) {
				if (city[i] > city[j] || j + 1 == city.size) {
					gas += togo
					money += togo * city[i].toBigInteger()
					togo = "0".toBigInteger()
					break
				} else {
					togo += road[j].toBigInteger()
				}
			}
		}
		gas -= road[i].toBigInteger()
	}
	print(money)
}