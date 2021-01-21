import kotlin.math.abs
import kotlin.math.min

private val n = readLine()!!.toInt()
private var intervals: Int = 10000
private val stats = Array<IntArray>(n + 1) {
	if (it == 0)
		IntArray(n + 1)
	else
		("0 " + readLine()!!).split(" ").map { it.toInt() }.toIntArray()
}

fun main() {

	val isUsed = BooleanArray(n + 1) { it == 0 }

	val team = IntArray(n / 2) { 0 }

	statANDLink(isUsed, team)

	print(intervals)
}

fun statANDLink(isUsed: BooleanArray, team: IntArray, last: Int = 1) {
	if (team[n / 2 - 1] != 0) {
		//마무으리
		intervals = min(intervals, interval(team))
		return
	}

	for (num in last..n) {
		if (!isUsed[num]) {
			for (i in 0 until n / 2)
				if (team[i] == 0) {
					team[i] = num
					break
				}
			isUsed[num] = true

			statANDLink(isUsed, team, num)

			for (i in 0 until n / 2)
				if (team[i] == num) {
					team[i] = 0
					break
				}
			isUsed[num] = false
		}
	}
}

fun interval(team: IntArray): Int {

	val team2 = IntArray(n / 2) { 0 }
	var index = 0

	for (i in 1..n) {
		if (!team.contains(i))
			team2[index++] = i
	}

	val score1 = calculate(team)
	val score2 = calculate(team2)
	return abs(score1 - score2)
}

fun calculate(member: IntArray): Int {
	var sum = 0
	for (i in 0 until n / 2) {
		for (j in i + 1 until n / 2) {
			sum += stats[member[i]][member[j]]
			sum += stats[member[j]][member[i]]
		}
	}
	return sum
}
