#include <iostream>
#include <vector>

using namespace std;

vector<int> dwarf;

int main(){

    int n;
    int all_sum=0;
    for (int i = 0; i < 9; ++i) {
        cin>>n;
        dwarf.push_back(n);
        all_sum+=n;
    }

    int firstIndex,secondIndex;

    for (int i = 0; i < 9; ++i)
        for (int j = 0; j < 9; ++j)
            if(i!=j)
                if(all_sum-dwarf[i]-dwarf[j]==100){
                    firstIndex=i;
                    secondIndex=j;
                }

    for (int i = 0; i < 9; ++i) {
        if(i!=firstIndex&&i!=secondIndex)
            cout<<dwarf[i]<<endl;
    }
}