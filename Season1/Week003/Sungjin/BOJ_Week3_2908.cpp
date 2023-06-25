#include <iostream>
#include <string>
#include <algorithm>

using namespace std;

int main(){

    //두 수를 문자열로 입력받음
    string A,B;
    cin>>A>>B;

    //문자열 역전
    reverse(A.begin(), A.end());
    reverse(B.begin(), B.end());
    
    //두 수중 큰 값을 출력
    cout<<max(A,B);

    return 0;
}