package com.grusie.algorithm

fun main() {
    var order = readLine()!!.toInt()
    val stack = MutableList(order,{0})

    var count = 1
    for(i in 0 until order){
        stack[i] = readLine()!!.toInt()
    }

    var compare = stack[order-1]    //비교할 마지막 스택 값
    for(i in order-1 downTo 0) {
        if(stack[i] > compare){     //스택값이 마지막 값보다 큰 값이 있으면
            compare = stack[i]      //비교할 값을 그것으로 변경
            count++
        }
    }
    println(count)
}