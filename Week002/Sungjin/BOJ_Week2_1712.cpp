#include <iostream>
using namespace std;

int main()
{
    //A : 고정 비용 B : 가변 비용 C : 상품 가격
    int A, B, C;
    cin >> A >> B >> C;
    
    //상품가격보다 가변비용이크다면 손익분기점이 존재할 수 없음
    if (B >= C) cout << -1;
    //상품가격에서 가변비용을 뺀 값이 수익이므로,
    //이 수익이 고정 비용을 넘어선 해(+1)가 손익분기점이다.
    else cout << A / (C - B) + 1;
}