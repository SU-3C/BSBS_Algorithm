package grusie.Grusie

fun main() {
    val input = readLine()!!.split(" ")
    val size = input[0].toInt()+1
    val list = MutableList(size) { mutableListOf<Int>() }
    val visited = Array(size){false}
    var count = 0
    val result = Array(size){0}
    val queue = ArrayDeque<Int>()

    for(i in 0 until input[1].toInt()){
        val line = readLine()!!.split(" ")
        val(v1, v2) = line.map { it.toInt() }
        list[v1].add(v2)
        list[v2].add(v1)
    }

    val root = input[2].toInt()
    for(i in list){
        i.sort()
    }

    fun bfs() {
        queue.add(root)
        visited[root] = true

        while (!queue.isEmpty()){
            var parent = queue.removeFirst()
            count++
            result[parent] = count
            for (i in list[parent]) {
                if (!visited[i]) {
                    queue.add(i)
                    visited[i] = true
                }
            }
        }
    }
    bfs()
    for(i in 1 until result.size)
        println(result[i])
}