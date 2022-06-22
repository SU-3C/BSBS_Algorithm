#include <iostream>
#include <algorithm>

using namespace std;

int main(){
    //상근이가 배달할 설탕의 KG
    int N;
    cin>>N;

    //3킬로그램 봉지와 5킬로그램 봉지가 있다.
    int Kg5=0,Kg3=0;

    //5의 배수가 될 때 까지 반복
    while (N%5!=0){
        //3Kg봉지에 하난씩 챙겨주며 3씩 감소
        N-=3;
        Kg3++;

        //N이 음수라는 것은 가져갈 방법의 수가 없다는 것
        if(N<0)
        {
            cout<<"-1";
            return 0;
        }
    }
    //5키로그램 봉지는 N을 5로 나눈 값
    Kg5=N/5;

    //두 봉지의 수를 합한 결과 출력
    cout<<Kg3+Kg5;
}