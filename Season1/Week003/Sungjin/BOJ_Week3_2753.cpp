#include <iostream>

using namespace std;

int main(){
        int year;
        cin>>year;
        //4의 배수이면서, 100의 배수가 아닐 때 또는 400의 배수일 때
        if(year%4==0 && year%100!=0 || year%400==0)
            cout<<"1"<<endl;
        else
            cout<<"0"<<endl;

        return 0;
}