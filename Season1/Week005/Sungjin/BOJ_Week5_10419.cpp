#include <iostream>
#include <cmath>

using namespace std;

int main(){

    int TestCase;
    cin>>TestCase;

    for (int i = 0; i < TestCase; ++i) {
        //수업시간 : d
        int d;
        cin>>d;

        //지각을 하지 않는 경우의 수 0부터 시작
        for (int j = 0;; ++j) {
            //만약 수업을 일찍 마쳐준 시간 + 수업해야 하는 시간이 
            //수업시간을 초과했을 때
            if(pow(j,2)+j>d)
            {
                cout<<j-1<<"\n";
                break;
            }
        }
    }
}