#include <iostream>
#include <vector>

using namespace std;

vector<int> ChessBoard;
int result=0;
int main(){

    string cmd;

    for (int i = 0; i < 8; ++i) {
        cin>>cmd;
        for (int j = 0; j < 8; ++j)
        {
            if(cmd[j]=='F'&&j%2==0&&i%2==0)
                result++;
            if(cmd[j]=='F'&&j%2==1&&i%2==1)
                result++;
        }
    }

    cout<<result;
}