#include <iostream>
#include <algorithm>
#include <string>

using namespace std;

int main(){

    int testCase;
    cin>>testCase;
    string input;
    //현재 O시 받는 점수 , 현재 누적 점수
    int Score=0,Result=0;

    //테스트 케이스 입력 받은 후 그만큼 반복
    for (int i = 0; i < testCase; ++i) {
        cin>>input;
        //결과값 변수 초기화
        Score=0; Result=0;
        //입력받은 문자열 수만큼 반복
        for (int j = 0; j < input.length(); ++j) {
            //만약 X라면 현재 받는 점수 0
            if(input[j]=='X') Score=0;
            //O라면 현재 받는 점수 하나 증가
            else Score++;
            //누적 점수에 현재 받는 점수 추가
            Result+=Score;
        }
        //결과출력
        cout<<Result<<"\n";
    }
}