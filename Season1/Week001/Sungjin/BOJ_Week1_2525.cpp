#include <iostream>

using namespace std;

//오븐의 시각/분
int hour, minute;

//오븐 시계의 총합 출력 함수
void calculate(int time) {
    int total = minute + time;
    //60단위로 시간 올림
    hour+=total/60;
    //올림수를 뺀 나머지
    minute=total%60;
    //만일 다음날로 넘어간다면 00시부터 시작
    if(hour>=24)
        hour-=24;

    cout<<hour<<" "<<minute;
}

int main() {
    cin >> hour >> minute;
    int time;
    cin >> time;
    calculate(time);

    return 0;
}
