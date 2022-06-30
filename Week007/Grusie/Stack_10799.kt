package com.grusie.algorithm.Stack1.Grusie

import java.util.Stack

fun main() {
    val input = readLine()!!
    var count = 0
    var flag = true     //레이저 판단용
    val stack = Stack<Boolean>()
    
    for(i in input) {
        if(i == '('){
            stack.add(true)
            flag = true
        }
        else if(i == ')'){
            if(flag){
                stack.pop()
                count += stack.size
            }
            else {
                stack.pop()
                count++
            }
            flag = false
        }
    }
    print(count)
}