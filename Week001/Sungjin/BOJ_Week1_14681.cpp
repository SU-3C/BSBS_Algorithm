#include <iostream>

using namespace std;

int main(){

    //x,y 좌표 입력
    int x,y;
    cin>>x>>y;

    //1사분면의 경우
    if(x>0 && y>0)
    cout<<"1"<<endl;
    //2사분면의 경우
    else if(x<0 && y>0)
        cout<<"2"<<endl;
    //3사분면의 경우
    else if(x<0 && y<0)
        cout<<"3"<<endl;
    //4사분면의 경우
    else
        cout<<"4"<<endl;

    return 0;
}