package com.grusie.algorithm


fun main() {
    val input = arrayListOf<String>()
    val problem = arrayListOf<Boolean>()
    while (true) {
        input.add(readLine()!!)
        if (input[0] == "고무오리 디버깅 시작") {        //처음 입력 값이 "고무오리 디버깅 시작"일 경우
            when (input[input.lastIndex]) {     //따로 명령어 수를 입력 안 받기에, while true로 주고 돌 때마다 추가하도록 함
                "고무오리" -> {                    //"고무오리" 일 경우
                    if (problem.isNotEmpty())
                        problem.removeAt(problem.lastIndex)     //문제가 비어있지 않으면 지우고
                    else {
                        problem.add(true)       //아니면 두개를 추가함
                        problem.add(true)
                    }
                }
                "문제" -> {
                    problem.add(true)       //"문제"일 경우 문제 추가
                }
                "고무오리 디버깅 끝" -> {       //"고무오리 디버깅 끝"일 경우 결과 출력 및 프로그램 종료
                    if (problem.isEmpty()) print("고무오리야 사랑해")
                    else print("힝구")
                    break
                }
            }
        }
    }
}