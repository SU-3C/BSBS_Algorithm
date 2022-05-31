#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main(){
//페어의 형태로 저장
    vector<pair<int,int>> Numbers;

    int n;
    for (int i = 0; i < 9; ++i) {
        cin>>n;
        Numbers.push_back({n,i+1});
    }

    //정렬정렬
    sort(Numbers.begin(), Numbers.end());

    cout<<Numbers[8].first<<endl;
    cout<<Numbers[8].second<<endl;

}