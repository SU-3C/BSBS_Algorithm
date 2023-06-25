package com.grusie.algorithm

fun main() {
    val order = readLine()!!.toInt()        //입력받을 명령어 수
    val input = MutableList(order){0}
    var sum = 0
    var last = MutableList(order){0}        //마지막 숫자

    for(i in 0 until order) {
        input[i] = readLine()!!.toInt()!!
        sum += input[i]         //입력받으면 무조건 더함
        if(input[i] != 0){      //입력값이 0이 아니면 마지막 숫자에 추가
            last.add(input[i])
        }
        if(i>0 && input[i] == 0){       //0이면 더한 값에서 마지막 숫자를 빼고, 리스트에서 제거
            sum-= last[last.lastIndex]
            last.removeAt(last.lastIndex)
        }
    }
    print(sum)
}