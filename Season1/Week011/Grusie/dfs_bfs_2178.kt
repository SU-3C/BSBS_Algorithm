package grusie.dfs_bfs2

fun main() {
    val (n, m) = readLine()!!.split(" ").map { it.toInt() }
    val array = Array(n) { Array(m) { 0 } }
    val visited = Array(n) { Array(m) { false } }
    val dx = arrayOf(-1, 0, 1, 0)
    val dy = arrayOf(0, 1, 0, -1)
    var x : Int
    var y : Int
    val result = Array(n) { Array(m) { 0 } }
    val queue = ArrayDeque<Pair<Int,Int>>()

    for (i in 0 until n) {
        val line = readLine()!!
        for (j in 0 until m) {
            array[i][j] = if (line[j] == '1') 1 else 0
        }
    }

    queue.add(Pair(0,0))
    visited[0][0] = true

    while (!queue.isEmpty()) {
        val parent = queue.removeFirst()
        x = parent.first
        y = parent.second
        for (i in dx.indices) {
            val currentX = x + dx[i]
            val currentY = y + dy[i]
            try {
                if (array[currentX][currentY] == 1 && !visited[currentX][currentY]) {
                    result[currentX][currentY] = result[x][y] + 1
                    visited[currentX][currentY] = true
                    queue.add(Pair(currentX,currentY))
                }
            } catch (e: Exception) {
                continue
            }
        }
    }
    print(result[n-1][m-1]+1)
}