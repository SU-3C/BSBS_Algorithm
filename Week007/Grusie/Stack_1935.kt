package com.grusie.algorithm.grusie

import java.util.*

fun main() {
    val order = readLine()!!.toInt()
    val calc = readLine()!!
    val oper = Stack<Char>()
    val num = Stack<Int>()
    var flag = false

    for(i in calc){
        when(i){
            '+', '-', '*', '/' -> {
                oper.push(i)
                flag= true
            }
            else -> {
                num.push(i.toString().toInt())
                if(flag){

                }
            }
        }
    }

    for(i in 1..order){

    }

}