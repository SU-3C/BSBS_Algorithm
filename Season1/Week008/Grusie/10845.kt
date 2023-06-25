package Queue

fun main() {
    val order = readLine()!!.toInt()
    var input : String
    val queue = ArrayDeque<Int>()
    var element: Int

    for(i in 0 until order){
        input = readLine()!!
        when (input){
            "front" -> {
                if(queue.isEmpty()) println("-1")
                else println(queue.first())
            }
            "back" -> {
                if(queue.isEmpty()) println("-1") else println(queue.last())
            }
            "pop" -> {
                if(queue.isEmpty()) println("-1") else println(queue.removeFirst())
            }
            "size" -> {
                println(queue.size)
            }
            "empty" -> {
                if(queue.isEmpty()) println("1") else println("0")
            }
            else -> {
                element = input.split(" ")[1].toInt()
                queue.add(element)
            }
        }
    }
}