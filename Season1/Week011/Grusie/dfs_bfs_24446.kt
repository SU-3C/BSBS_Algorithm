package grusie.dfs_bfs2

fun main() {
    val input = readLine()!!.split(" ")
    val nodes = input[0].toInt()
    val lines = input[1].toInt()
    val start = input[2].toInt()
    val queue = ArrayDeque<Int>()
    val visited = Array(nodes+1){false}
    var count: Int
    val result = Array(nodes+1){-1}

    val list = MutableList(nodes+1){ mutableListOf<Int>() }

    for(i in 0 until lines){
        val (v1,v2) = readLine()!!.split(" ").map { it.toInt() }

        list[v1].add(v2)
        list[v2].add(v1)
    }

    queue.add(start)
    visited[start] = true
    result[start] = 0

    while (!queue.isEmpty()) {
        val parent = queue.removeFirst()
        count = result[parent]
        count++
        for (i in list[parent]) {
            if (!visited[i]) {
                queue.add(i)
                visited[i] = true
                result[i] = count
            }
        }
    }
   for(i in 1 until result.size)
       println(result[i])
}