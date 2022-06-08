#include <iostream>
#include <vector>

using namespace std;

vector<int> dwarf;

int main(){

    int n;
    int all_sum=0;
    //벡터에9개의 수를 삽입
    for (int i = 0; i < 9; ++i) {
        cin>>n;
        dwarf.push_back(n);
        all_sum+=n;
    }

    int firstIndex,secondIndex;

    //9개의 수 중에서 2개를 골랐을 때, 합이 100이 되는 
    //경우의 수를 탐색
    for (int i = 0; i < 9; ++i)
        for (int j = 0; j < 9; ++j)
            if(i!=j)
                if(all_sum-dwarf[i]-dwarf[j]==100){
                    firstIndex=i;
                    secondIndex=j;
                }

    //저장된 두 인덱스가 아닌 경우만 출력            
    for (int i = 0; i < 9; ++i) {
        if(i!=firstIndex&&i!=secondIndex)
            cout<<dwarf[i]<<endl;
    }
}