#include <iostream>

using namespace std;

int main() {
    //3개정수
    int number[3];
    //배열 입력
    for (int i = 0; i < 3; i++)
        cin>>number[i];

    //모든 수가 같은 경우
    if(number[0]==number[1] && number[1]==number[2])
        cout<<10000+number[0]*1000;
    //첫번째와 두번째가 같은 경우
    else if(number[0]==number[1])
        cout<<1000+(number[0]*100);
    //두번째와 세번째가 같은 경우
    else if(number[1]==number[2])
        cout<<1000+(number[1]*100);
    //첫번째와 세번째가 같은 경우
    else if(number[0]==number[2])
        cout<<1000+(number[2]*100);
    //모든 수의 경우가 다 틀릴 경우 (최대값 구함)
    else
        cout<<100*max(number[0], max(number[1],number[2]));

}
