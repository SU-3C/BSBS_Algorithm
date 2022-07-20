package grusie.DataStructure

fun main() {
    var line = ArrayList<Int>()
    val order = readLine()!!.toInt()
    var temp = readLine()!!.split(" ")

    for(i in 0 until order){
        line.add(line.lastIndex+1-temp[i].toInt(), i+1)     //처음은 -1이라서 0부터 채워주기 위함
    }
    print(line.joinToString ( " "))
}