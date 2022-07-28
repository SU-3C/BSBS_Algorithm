package grusie.Grusie

import java.util.*
import kotlin.collections.ArrayDeque

fun main() {
    val input = readLine()!!.split(" ")
    val list = MutableList(input[0].toInt()+1) { mutableListOf<Int>() }
    val visited = ArrayList<Int>()

    for(i in 0 until input[1].toInt()){
        val line = readLine()!!.split(" ")
        val(v1, v2) = line.map { it.toInt() }
        list[v1].add(v2)
        list[v2].add(v1)
    }

    val root = input[2].toInt()

    /*fun dfs() {           //TODO 스택 이용
        for(i in list){
            i.sortByDescending { it }
        }
        val stack = Stack<Int>()
        stack.push(root)

        while (!stack.isEmpty()) {
            var parent = stack.pop()
            if(!visited.contains(parent)) {
                visited.add(parent)
                print("$parent ")
            }
            for (i in list[parent]) {
                if (!visited.contains(i)) {
                    stack.push(i)
                }
            }
        }
        println()
        visited.clear()
    }*/

    fun dfsR(node : Int){       //TODO 재귀함수 사용
        if(!visited.contains(node)) {
            visited.add(node)
            print("$node ")
        }
        for(i in list[node]){
            if(!visited.contains(i)){
                dfsR(i)
            }
        }
    }
    fun bfs() {
        for(i in list){
            i.sort()
        }
        val queue = ArrayDeque<Int>()
        queue.add(root)
        visited.add(root)

        while (!queue.isEmpty()){
            var parent = queue.removeFirst()
            for (i in list[parent]) {
                if (!visited.contains(i)) {
                    queue.add(i)
                    visited.add(i)
                }
            }
            print("$parent ")
        }
        println()
        visited.clear()
    }
//    dfs()
    dfsR(root)
    bfs()
}