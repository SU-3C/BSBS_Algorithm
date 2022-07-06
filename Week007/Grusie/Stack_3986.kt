package com.grusie.algorithm.Stack2.Grusie

import java.util.*

fun main() {
    val order = readLine()!!.toInt()
    var input: String
    val stack = Stack<Boolean>()
    var count = 0

    for(i in 1..order){
        input = readLine()!!
        for(j in input){
            when(j){
                'A' -> {
                    if(stack.isNotEmpty() && stack.peek()) stack.pop()
                    else stack.push(true)
                }
                'B' -> {
                    if(stack.isNotEmpty() && !stack.peek()) stack.pop()
                    else stack.push(false)
                }
            }
        }
        if(stack.isEmpty()) count++
        stack.clear()
    }
    print(count)
}