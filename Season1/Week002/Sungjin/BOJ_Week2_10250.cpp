#include <iostream>

using namespace std;

int main(){
    //테스트케이스
    int testCase;
    cin>>testCase;
    //호텔의 층 개수, 한층의 방개수, 배정받은 손님의 순서
    int H,W,N;
    //배정할 층/방번호
    int floor,room;
    //테스트케이스만큼 반복
    for (int i = 0; i < testCase; ++i) {
    cin>>H>>W>>N;
    //만약 맨 꼭대층이라면 입력받은층이고, 아니라면 +1(나머지 연산자)
    floor=(N%H==0)?H:N%H;
    room=(N%H==0)?N/H:N/H+1;
    cout<<floor*100+room<<"\n";
    }
}