package grusie.DataStructure

fun main() {
    val order = readLine()!!.toInt()
    var t : List<String>

    for(i in 0 until order){
        t = readLine()!!.split(" ")
        for(j in 0 until t[1].toInt()){
            readLine()!!        //그냥 버림
        }
        println(t[0].toInt()-1)
    }
}