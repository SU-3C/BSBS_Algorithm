package grusie.Queue

fun main() {
    val queue = ArrayDeque<Int>()
    var input = readLine()!!.toInt()
    for(i in 1.. input){
        queue.add(i)
    }
    while(queue.size != 1){
        queue.removeFirst()
        queue.add(queue.removeFirst())
    }
    print(queue.first())
}