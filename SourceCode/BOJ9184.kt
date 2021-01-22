val arr = Array<Array<IntArray>>(21) { Array<IntArray>(21) { IntArray(21) { 1 } } }
fun main() {
	while (true) {
		val num = readLine()!!.split(' ').map { it.toInt() }
		if (num[0] == -1 && num[1] == -1 && num[2] == -1)
			break
		println("w(${num[0]}, ${num[1]}, ${num[2]}) = ${w(num[0], num[1], num[2])}")
	}
}

fun w(a: Int, b: Int, c: Int): Int {
	val a1 : Int
	val b1 : Int
	val c1 : Int
	if (a > 20 || b > 20 || c > 20){
		a1 = 20
		b1 = 20
		c1 = 20
	}else{
		a1 = a
		b1 = b
		c1 = c
	}
	for (i in 1..a1) {
		for (j in 1..b1) {
			for (k in 1..c1) {
				arr[i][j][k] = arr[i - 1][j][k] + arr[i - 1][j - 1][k] + arr[i - 1][j][k - 1] - arr[i - 1][j - 1][k - 1]
			}
		}
	}


	if (a <= 0 || b <= 0 || c <= 0)
		return 1
	else if (a > 20 || b > 20 || c > 20)
		return arr[20][20][20]
	else
		return arr[a][b][c]
}

