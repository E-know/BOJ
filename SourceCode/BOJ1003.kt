val arr = Array<IntArray>(41) { IntArray(2) { 0 } }

fun main() {
	arr[0][0] = 1
	arr[0][1] = 0
	arr[1][0] = 0
	arr[1][1] = 1

	repeat(readLine()!!.toInt()){
		fib(readLine()!!.toInt())
	}

}

fun fib(n : Int){
	if(n == 0){
		println("1 0")
		return
	}
	if(n == 1){
		println("0 1")
		return
	}

	for(i in 2..n){
		arr[i][0] = arr[i-1][1]
		arr[i][1] = arr[i-1][0] + arr[i-1][1]
	}
	println("${arr[n][0]} ${arr[n][1]}")
}