import java.util.*
import kotlin.math.max

fun main() {
	val n = readLine()!!.toInt()
	val arr = Array<IntArray>(n + 1) { IntArray(n + 1) { -1 } }
	val cost = Array<IntArray>(n + 1) { IntArray(n + 1) { 0 } }
	val sc = Scanner(System.`in`)

	repeat(n) {
		for (i in 0..it) {
			arr[it + 1][i + 1] = sc.nextInt()
		}
	}

	cost[1][1] = arr[1][1]

	for(i in 2..n){
		for(j in 1 .. i){
			cost[i][j] = max(cost[i-1][j],cost[i-1][j-1]) + arr[i][j]
		}
	}


	print(cost[n].maxOf { it })
}
