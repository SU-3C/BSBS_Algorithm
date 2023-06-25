package grusie.dfs_bfs2

fun main() {
    val input = readLine()!!.split(" ")
    val nodes = input[0].toInt()
    val lines = input[1].toInt()
    val start = input[2].toInt()
    val visited = Array(nodes+1){false}
    val result = Array(nodes+1){-1}
    val list = MutableList(nodes+1){ mutableListOf<Int>() }

    for(i in 0 until lines){
        val (v1,v2) = readLine()!!.split(" ").map { it.toInt() }

        list[v1].add(v2)
        list[v2].add(v1)
    }
    for(i in list)
        i.sort()

    result[start] = 0
    fun dfsR(node : Int){
        visited[node] = true
        var count = result[node]
        count++

        for(i in list[node]) {
            if (!visited[i]) {
                result[i] = count
                dfsR(i)
            }
        }
    }

    dfsR(start)
    for(i in 1 until result.size){
        println(result[i])
    }
}