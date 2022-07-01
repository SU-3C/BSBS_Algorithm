package com.grusie.algorithm.Stack2.Grusie

import java.util.*

fun main() {
    var input : String
    var stack = Stack<Boolean>()
    while (true) {
        stack.clear()
        input = readLine()!!
        if(input == ".")
            break
        for (i in input) {
            when (i) {
                '[' -> {
                    stack.push(true)
                }
                '(' -> {
                    stack.push(false)
                }
                ']' -> {
                    if (stack.isNotEmpty() && stack.peek()) {
                        stack.pop()
                    }
                    else {
                        stack.push(true)
                        break
                    }
                }
                ')' -> {
                    if (stack.isNotEmpty() && !stack.peek()) {
                        stack.pop()
                    }
                    else {
                        stack.push(true)
                        break
                    }
                }
            }
        }
        if(stack.isEmpty()) println("yes") else println("no")
    }
}