#include <iostream>
#include <cmath>

using namespace std;

int main(){

    int B,N;

    while (true){
        cin>>B>>N;
        //만일 0 0이 입력된 경우
        if(B==0 && N==0) break;

        //B는 100만까지므로
        int previousValue=1000001;

        //i는 1부터 시작, 종료 조건 없음
        for (int i = 1; ; ++i) {
            //만일 이번의 제곱 계산 결과가 이전 값보다 커질 때
            if(int(abs(B-pow(i,N)))>previousValue)
            {
                //이전 값이 정답
                cout<<i-1<<"\n";
                break;
            }
            //이전 변수 재할당
            previousValue= int(abs(B-pow(i,N)));
        }
    }
}