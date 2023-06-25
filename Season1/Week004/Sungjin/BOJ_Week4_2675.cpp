#include <iostream>
using namespace std;

int main(){
    int TestCase;
    cin>>TestCase;

    for (int i = 0; i < TestCase; ++i) {
        int n;
        string s;
        cin>>n>>s;
        //각 문자에 접근
        for (int j = 0; j < s.size(); ++j)
            for (int k = 0; k < n; ++k)
                cout<<s[j];

        cout<<"\n";
    }
}