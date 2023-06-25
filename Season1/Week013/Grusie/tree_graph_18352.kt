package grusie.tree_graph

fun main() {
    val (cities, road, distance, start) = readLine()!!.split(" ").map { it.toInt() }
    var list = Array(cities + 1) { mutableListOf<Int>() }
    var result = Array(cities + 1) { 0 }
    val queue = ArrayDeque<Int>()
    var flag = false

    for (i in 1..road) {
        val (city1, city2) = readLine()!!.split(" ").map { it.toInt() }
        list[city1].add(city2)
    }

    queue.add(start)

    fun bfs() {
        var visited = Array(cities + 1) { false }

        while (!queue.isEmpty()) {
            val parent = queue.removeFirst()
            var count = result[parent]
            count++
            for (i in list[parent]) {
                if (!visited[i]) {
                    queue.add(i)
                    visited[i] = true
                    result[i] = count
                }
            }
        }
    }
    bfs()

    for (i in 1 until result.size) {
        if (i != start && result[i] == distance) {
            println(i)
            flag = true
        }
    }
    if (!flag)
        print(-1)
}