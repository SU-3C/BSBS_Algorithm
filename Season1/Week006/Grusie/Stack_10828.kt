package com.grusie.algorithm

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val order = br.readLine()!!.toInt()     //입력받을 명령어 수
    val stack = Stack<Int>()

    for(i in 0 until order){
        when(val input = br.readLine()){        //입력
            "pop" -> {
                if(!stack.empty()){
                    println(stack.peek())
                    stack.pop()
                } else println("-1")
            }
            "empty" -> {
                println(if(stack.empty()) "1" else "0")
            }
            "size" -> {
                println(stack.size)
            }
            "top" -> {
                if(!stack.empty())
                    println(stack.peek())
                else
                    println("-1")
            }
            else -> {
                stack.push(input.split(" ")[1].toInt()) //push 처리를 위한 split
            }
        }
    }
}