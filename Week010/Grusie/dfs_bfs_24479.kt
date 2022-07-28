package grusie.Grusie

fun main() {
    val input = readLine()!!.split(" ")
    val list = MutableList(input[0].toInt() + 1) { mutableListOf<Int>() }
    val visited = Array(input[0].toInt() + 1){false}
    var count = 0
    val result = Array(input[0].toInt() + 1){count}

    for (i in 0 until input[1].toInt()) {
        val line = readLine()!!.split(" ")
        val (v1, v2) = line.map { it.toInt() }
        list[v1].add(v2)
        list[v2].add(v1)
    }
    for(i in list){
        i.sort()
    }
    val root = input[2].toInt()

    fun dfsR(node : Int){       //TODO 재귀함수 사용
        if(!visited[node]) {
            visited[node] = true
            count++
            result[node] = count
        }
        for(i in list[node]){
            if(!visited[i]){
                dfsR(i)
            }
        }
    }
    dfsR(root)
    for(i in 1 until result.size)
        println(result[i])
}