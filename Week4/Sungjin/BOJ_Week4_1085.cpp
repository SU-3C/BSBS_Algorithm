#include <iostream>

using namespace std;

int main(){
//한수는 지금 (x, y)
//오른쪽 위 꼭짓점은 (w, h)에 있다.
    int x,y,w,h;
    cin>>x>>y>>w>>h;

    //min(x,y)는 좌표축과 가까운 경우
    //min(w-x,h-y) 는 높이와 너비에 가까운 경우
    int result=min(min(x,y),min(w-x,h-y));
    cout<<result;

    return 0;
}