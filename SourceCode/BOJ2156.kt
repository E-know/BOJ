import java.util.*

fun main() {
	val n = readLine()!!.toInt()
	val sc = Scanner(System.`in`)

	val arr = IntArray(n + 1) { 0 }
	val cost = Array<IntArray>(n + 1) { IntArray(3) { 0 } }
	for (i in 1..n) {
		arr[i] = sc.nextInt()
	}

	cost[1][0] = 0
	cost[1][1] = arr[1]
	cost[1][2] = arr[1]

	if(n>= 2){
		cost[2][0] = arr[1]
		cost[2][1] = arr[2]
		cost[2][2] = arr[1] + arr[2]
	}

	for(i in 3..n){
		cost[i][0] = cost[i-1][2]
		cost[i][1] = cost[i-1][0] + arr[i]
		cost[i][2] = cost[i-1][1] + arr[i]
	}


	print(cost[n].maxOf { it })
}