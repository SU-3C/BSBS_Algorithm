package grusie.tree_graph
/*
class Tree(size: Int) {         //class구현 해결 하려고 했으나 실패..
    var parents = Array(size + 1) { 1 }
    fun makeNode(data1: Int, data2: Int) {
        if (parents[data1] == 1 && data1 != 1)
            parents[data1] = data2

        if (parents[data2] == 1 && data2 != 1)
            parents[data2] = data1
    }

    fun printParents() {
        for (i in 2 until parents.size)
            println(parents[i])
    }
}

fun main() {
    val order = readLine()!!.toInt()
    val t = Tree(order)

    for (i in 1 until order) {
        var (x, y) = readLine()!!.split(" ").map { it.toInt() }
        t.makeNode(x, y)
    }
    t.printParents()
}*/
fun main() {
    val order = readLine()!!.toInt()
    var list = Array(order + 1) { mutableListOf<Int>() }
    val visited = Array(order + 1) { 0 }
    val queue = ArrayDeque<Int>()

    for (i in 1 until order) {
        var (x, y) = readLine()!!.split(" ").map { it.toInt() }
        list[x].add(y)
        list[y].add(x)
    }

/*    fun dfs(start: Int) {         //dfs 사용 해결
        for (i in list[start]){
            if (visited[i] == 0){
                visited[i] = start
                dfs(i)
            }
        }
    }
    dfs(1)*/

    queue.add(1)
    while (!queue.isEmpty()) {      //bfs 사용 해결
        val parent = queue.removeFirst()
        for (i in list[parent]) {
            if (visited[i] == 0) {
                visited[i] = parent
                queue.add(i)
            }
        }
    }

    for (i in 2 until visited.size) {
        println(visited[i])
    }
}
