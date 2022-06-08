#include <iostream>
#include <cmath>

using namespace std;

int main(){

    int TestCase;
    cin>>TestCase;

    for (int i = 0; i < TestCase; ++i) {
        int d;
        cin>>d;

        for (int j = 0;; ++j) {
            if(pow(j,2)+j>d)
            {
                cout<<j-1<<"\n";
                break;
            }
        }
    }
}