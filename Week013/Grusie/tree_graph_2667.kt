package grusie.tree_graph

fun main() {
    val order = readLine()!!.toInt()
    val map = Array(order) { Array(order) { '0' } }
    val dx = arrayOf(0, -1, 0, 1)
    val dy = arrayOf(-1, 0, 1, 0)
    var x = 0
    var y = 0
    var house = 0
    var count = 1
    var result = mutableListOf<Int>()

    for (i in 0 until order) {
        var input = readLine()
        for (j in 0 until order) {
            map[i][j] = input!![j]
        }
    }

    fun dfs(a: Int, b: Int) {
        for (i in dx.indices) {
            var currentX = a + dx[i]
            var currentY = b + dy[i]

            try {
                map[a][b] = 'v'
                if (map[currentX][currentY] == '1') {
                    dfs(currentX, currentY)
                    count++
                }
            } catch (e: Exception) {
            }
        }
    }


    for (i in 0 until order) {
        for (j in 0 until order) {
            try {
                if (map[x + i][y + j] == '1') {
                    count = 1
                    house++
                    dfs(x + i, y + j)
                    result.add(count)
                }
            } catch (e: Exception) {
            }
        }
    }
    println(house)
    result.sort()
    for (i in result) {
        println(i)
    }
}