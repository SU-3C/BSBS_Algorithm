package grusie.DataStructure

fun main() {
    val deque = ArrayDeque<Int>()
    val order = readLine()!!.toInt()
    var input: String

    for (i in 0 until order) {
        input = readLine()!!
        var split = input.split(" ")
        when (split[0]) {
            "front" -> {
                if (deque.isEmpty()) println("-1")
                else println(deque.first())
            }
            "empty" -> {
                if (deque.isEmpty()) println("1")
                else println("0")
            }
            "back" -> {
                if (deque.isEmpty()) println("-1")
                else println(deque.last())
            }
            "size" -> println(deque.size)
            "pop_front" -> {
                if (deque.isEmpty()) println("-1")
                else println(deque.removeFirst())
            }
            "pop_back" -> {
                if (deque.isEmpty()) println("-1")
                else println(deque.removeLast())
            }
            "push_front" -> {
                deque.addFirst(split[1].toInt())
            }
            "push_back" ->
                deque.addLast(split[1].toInt())
        }
    }
}