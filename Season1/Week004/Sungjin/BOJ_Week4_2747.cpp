#include <iostream>

using namespace std;

int pibo[46];

int pibonachi(int n) {
    if(n==0)
        return 0;
    else if(n==1)
        return 1;
    else if(pibo[n]>0)
        return pibo[n];
    else{
        pibo[n]=pibonachi(n-1)+ pibonachi(n-2);
        return pibo[n];
    }
}

/*
int pibonachi(int n) {
    if(n==0)
        return 0;
    else if(n==1)
        return 1;
    else
        return pibonachi(n-1)+ pibonachi(n-2);
}
*/

int main(){
    int N;
    cin>>N;

    cout<<pibonachi(N);
}

