#include <iostream>
#include <algorithm>
#include <string>

using namespace std;

int main(){
    //0~9까지의 숫자가 몇번 나왔는지 기록할 배열 선언
    int resultArr[10]={0,};
    
    //A,B,C입력
    int A,B,C;
    cin>>A>>B>>C;
    
    //정수를 스트링으로 변환
    string result= to_string(A*B*C);

    //아스키코드를 이용해 해당 배열에 수를 늘ㅇ림
    for (int i = 0; i <result.length(); ++i)
        resultArr[result[i]-48]++;
    
    //0~9가 나온 횟수 출력
    for (int i = 0; i <10; ++i)
        cout<<resultArr[i]<<"\n";
}