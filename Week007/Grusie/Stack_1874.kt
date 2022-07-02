package com.grusie.algorithm.Stack2.Grusie

import java.util.Stack

fun main() {
    val order = readLine()!!.toInt()
    var input: Int
    var stack = Stack<Int>()
    var count = 1
    var print = ArrayList<String>()
    var flag = true

    for(i in 0 until order){
        input = readLine()!!.toInt()
        while(count <= input) {
            stack.push(count)
            count++
            print.add("+")
        }
            if(stack.peek() == input) {
                stack.pop()
                print.add("-")
            }
            else{
                flag = false
                println("NO")
                break
            }
    }
    if(flag) for(i in print) println(i)
}