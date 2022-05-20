#include <iostream>
#include <algorithm>

using namespace std;

int main(){
    //음계 배열 선언
    int scale[8];

    //배열 입력
    for (int i = 0; i < 8; ++i)
        cin>>scale[i];

    // ascending, descending, mixed 를 구별할 변수 선언
    bool isYes= true;

    //만약 이전값보다 하나씩 늘어난다면
    for (int i = 0; i < 7; ++i)
        //하나라도 틀리면
        if(scale[i]+1!=scale[i+1])
        {
            isYes= false;
            break;
        }
    //출력하고 리턴
    if(isYes){
        cout<<"ascending";
        return 0;
    }


    isYes= true;

    //만약 이전값보다 하나씩 줄어든다면
    for (int i = 0; i < 7; ++i)
        //하나라도 틀리면
        if(scale[i]-1!=scale[i+1])
        {
            isYes= false;
            break;
        }
    //출력하고 리턴
    if(isYes){
        cout<<"descending";
        return 0;
    }

    //모든 경우가 아니면
    cout<<"mixed";
    return 0;
}