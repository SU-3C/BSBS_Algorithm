#include <iostream>

using namespace std;

int dp[13]{};

//동적 계획법 이용
int dpfactorial(int n){
//0과1의경우
    if(n==0 || n==1) return 1;
    //이미 할당된 값일 경우
    else if(dp[n]>0) return dp[n];
    else{
    //새로운 값일 경우
        dp[n]=n* dpfactorial(n-1);
        return dp[n];
    }

}


int factorial(int n) {
    if(n==0 || n==1)
        return 1;
    else
        return n* factorial(n-1);
}

int forfunc(int n){
    int result=1;

    for (int i = n; i >0; --i)
        result*=i;

    return result;
}

int main(){
    int N;
    cin>>N;

    //cout<<factorial(N);
    cout<<dpfactorial(N);
    //cout<<forfunc(N);
}

