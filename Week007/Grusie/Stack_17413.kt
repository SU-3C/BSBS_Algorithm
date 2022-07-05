package com.grusie.algorithm.grusie

import java.util.*
import kotlin.collections.ArrayList

fun main() {
    var input = readLine()!!
    val print = ArrayList<Char>(input.length)
    var temp = Stack<Char>()
    var flag = false

    for((index, i) in input.withIndex()) {
        when(i){
            '<' -> {
                if(temp.isNotEmpty()){
                    for(j in temp.size downTo 1) {
                        print.add(temp.peek())
                        temp.pop()
                    }
                }
                print.add(i)
                flag = true
            }
            '>' -> {
                flag = false
                print.add(i)
            }
            ' ' -> {
                if(!flag){
                  if(temp.isNotEmpty()){
                      for(j in temp.size downTo 1) {
                          print.add(temp.peek())
                          temp.pop()
                      }
                  }
              }
                print.add(i)
            }

            else -> {
                if(flag){
                    print.add(i)
                }
                else {
                    temp.push(i)
                }
            }
        }
        if(index == input.lastIndex){
            if(!flag){
                if(temp.isNotEmpty()){
                    for(j in temp.size downTo 1) {
                        print.add(temp.peek())
                        temp.pop()
                    }
                }
            }
        }
    }
    print(print.joinToString(""))
}