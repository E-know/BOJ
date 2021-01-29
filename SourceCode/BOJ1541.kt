fun main() {
	val str = readLine()!!
	var plus = 0
	var minus = 0
	var num = 0
	var flag = true

	for (i in str.indices) {
		when {
			str[i] in '0'..'9' -> {
				num = num * 10 + (str[i] - '0')
			}
			str[i] == '+' -> {
				if (flag) {
					plus += num
				} else {
					minus += num
				}
				num = 0
			}
			str[i] == '-' -> {
				if (flag) {
					plus += num
				} else {
					minus += num
				}
				num = 0
				flag = false
			}
		}
	}
	if(flag){
		plus += num
	}else{
		minus += num
	}
	print(plus - minus)
}