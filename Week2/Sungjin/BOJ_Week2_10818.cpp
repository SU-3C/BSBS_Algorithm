#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

int main(){
    //배열의 갯수 입력
    int size;
    cin>>size;

    //벡터와 입력받을 변수 선언
    vector<int> numbervec;
    int num;

    //size개만큼 배열 추가
    for (int i = 0; i < size; ++i)
    {
        cin>>num;
        numbervec.push_back(num);
    }

    //배열 정렬
    sort(numbervec.begin(),numbervec.end());
    
    //맨 앞과 맨 뒤 출력
    cout<<numbervec[0]<<" "<<numbervec[size-1];
}