private val n = readLine()!!.toInt()
private var count = 0
fun main() {
	nQueen(0, IntArray(n) { -1 })
	print(count)
}

private fun nQueen(level: Int, board: IntArray, a: Int? = null) {
	if (level == n) {
		count++
		return
	}
	if (a != null && level > 0) {
		board[level - 1] = a
	}

	for (num in 0 until n) {
		if (isEmpty(num, level, board)) {
			nQueen(level + 1, board, num)
		}
	}
}

private fun isEmpty(num: Int, level: Int, board: IntArray): Boolean {
	for (i in level - 1 downTo 0) {
		if (num == board[i])
			return false
		if (num == board[i] - (level - i) || num == board[i] + (level - i))
			return false
	}
	return true
}
