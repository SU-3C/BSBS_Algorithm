#include <iostream>

using namespace std;

//별찍기 출력 함수
void printStar16(int num){
    //사용자가 입력한 열만큼 출력
    for(int i=1;i<=num;i++){
        //num-1 부터 0 이 될 떄 까지
        for (int j=1;j<=num-i;j++)
            cout<<" ";
        //현재 i값 대로의 출력
        for (int k = 1; k <= i; ++k)
            cout<<"* ";
        cout<<"\n";
    }
}

int main(){
    int number;
    cin>>number;
    printStar16(number);

    return 0;
}