fun main() {
	val n = readLine()!!.toInt()
	val arr = IntArray(n) { readLine()!!.toInt() }
	var flag = true
	var d : Int? = null
	for (i in 2..arr.maxOf { it }) {
		d = null
		flag = true
		arr.forEach {
			if(flag){
				if (d == null) {
					d = it % i
				} else if (d != it % i)
					flag = false
			}
		}
		if(flag)
			print("$i ")
	}
}