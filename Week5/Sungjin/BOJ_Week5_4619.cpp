#include <iostream>
#include <cmath>

using namespace std;

int main(){
    int B,N;

    while (true){
        cin>>B>>N;
        if(B==0 && N==0) break;
        int previousValue=1000001;

        for (int i = 1; ; ++i) {
            if(int(abs(B-pow(i,N)))>previousValue)
            {
                cout<<i-1<<"\n";
                break;
            }
            previousValue= int(abs(B-pow(i,N)));
        }
    }
}