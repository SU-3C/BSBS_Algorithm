#include <iostream>

using namespace std;

int N,X;

void printLessX(short arr[],int num){

    //N개의 배열 안에서 X보다 작은 경우 출력
    for(int i=0;i<N;i++)
        if(arr[i]<X)
            cout<<arr[i]<<" ";

}

int main(){
    cin>>N>>X;

    //N개의 short를 가진 배열을 동적 생성
    short *array=new short[N];

    //입력
    for(int i=0;i<N;i++)
        cin>>array[i];
    //프린트 함수 호출
    printLessX(array,X);

    return 0;
}