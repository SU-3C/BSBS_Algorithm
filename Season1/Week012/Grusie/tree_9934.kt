package grusie.tree

fun main() {
    var level = readLine()!!.toInt()
    var input = readLine()!!.split(" ").map { it.toInt() }
    var result = MutableList(input.size) { mutableListOf(0) }
    var count = 0
    val queue = ArrayDeque<List<Int>>()


    fun devide(input: List<Int>) {
        try {
            var half = MutableList(input.size / 2) { 0 }
            var rest_half = MutableList(input.size / 2) { 0 }

            for (i in 0 until input.size / 2) {
                half[i] = input[i]
            }
            for (i in input.size / 2 + 1 until input.size) {
                rest_half[i - (input.size / 2 + 1)] = input[i]
            }
            print("${input[input.size / 2]} ")
            queue.add(half)
            queue.add(rest_half)
        } catch (e: Exception) {}
    }
    queue.add(input)
    while(!queue.isEmpty()){
        devide(queue.removeFirst())
        count++
    }
}
