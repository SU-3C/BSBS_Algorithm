package com.grusie.algorithm

fun main() {
    val order = readLine()!!.toInt()
    val input = arrayListOf<String>()

    for(i in 0 until order) {
        val left = arrayListOf<Boolean>()
        val right = arrayListOf<Boolean>()
        input.add(readLine()!!)
        for(j in input[i].indices){ //각 줄의 문자열 길이만큼
            if(input[i][j]== '('){  //'('이면 left에 추가
                left.add(true)
            }
            else if(input[i][j] == ')'){    //')' 이면
                if(left.isNotEmpty()) {     //left가 비어있으면 left값 지우고
                    left.removeAt(left.lastIndex)
                }else right.add(true)   //아니면 right에 추가
            }
        }
        if(left.isEmpty() && right.isEmpty())   //left, right 둘다 비어있으면 YES
            println("YES")
        else println("NO")
    }
}