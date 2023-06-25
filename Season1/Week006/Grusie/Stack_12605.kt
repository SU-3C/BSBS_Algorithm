package com.grusie.algorithm

fun main() {

    val order = readLine()!!.toInt()

    val input = MutableList(order) { "" }

    for (i in 1..order){
        input[i-1] = readLine()!!
        val word = input[i-1].split(" ")    //각 단어를 구분하기 위함
        val stack = MutableList(word.size){""}
        for(j in word.lastIndex downTo 0){      //역으로 하기 위해 word 갯수만큼 뒤에서 부터 for문 사용
            stack[word.lastIndex- j] = word[j]  //stack배열이 word의 마지막 값부터 채워짐
        }
        println("Case #$i: ${stack.joinToString(" ")}")
    }
}