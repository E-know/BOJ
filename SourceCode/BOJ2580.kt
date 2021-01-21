import kotlin.system.exitProcess

fun main() {
	val board = Array<IntArray>(9) { readLine()!!.split(" ").map { it.toInt() }.toIntArray() }
	val empty = mutableListOf<Int>()
	for (y in 0 until 9) {
		for (x in 0 until 9) {
			if (board[y][x] == 0)
				empty.add(y * 10 + x)
		}
	}
	sudoku(board, empty)
}

fun sudoku(board: Array<IntArray>, empty: MutableList<Int>, level: Int = 0) {

	for (n in 1..9) {
		if (square(n, board, empty[level]) && row(n, board, empty[level]) && column(n, board, empty[level])) {
			val newBoard = Array<IntArray>(9) { index -> board[index].clone() }
			newBoard[empty[level] / 10][empty[level] % 10] = n
			if (level == empty.lastIndex) {
				printBoard(newBoard)
				exitProcess(0)
			} else {
				sudoku(newBoard, empty, level + 1)
			}
		}
	}
}

fun square(num: Int, board: Array<IntArray>, locate: Int): Boolean {
	val y = locate / 10
	val x = locate % 10
	for (i in 0 until 3) {
		for (j in 0 until 3) {
			if (board[(y / 3) * 3 + i][(x / 3) * 3 + j] == num)
				return false
		}
	}
	return true
}

fun row(num: Int, board: Array<IntArray>, locate: Int): Boolean {
	val y = locate / 10
	for (i in 0 until 9) {
		if (board[y][i] == num)
			return false
	}
	return true
}

fun column(num: Int, board: Array<IntArray>, locate: Int): Boolean {
	val x = locate % 10
	for (i in 0 until 9) {
		if (board[i][x] == num)
			return false
	}
	return true
}

fun printBoard(board: Array<IntArray>): Unit {
	for (i in 0 until 9) {
		for (j in 0 until 9)
			print("${board[i][j]} ")
		println()
	}
}
