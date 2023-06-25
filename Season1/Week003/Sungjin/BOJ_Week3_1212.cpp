#include <iostream>
#include <string>
#include <algorithm>
#include <stack>

using namespace std;

int main(){
    //8진수 입력 받기
    string octalNumber;
    cin>>octalNumber;

    //0인 경우에는 0만 출력
    if(octalNumber=="0") {
        cout << "0";
        return 0;
    }
        //결과값 저장 변수
        string result = "";
        //입력받은 문자열만큼 반복
        for (int i = 0; i < octalNumber.size(); ++i) {
            //각 숫자에 해당되는 세자리 이진수 삽입
            if (octalNumber[i] == '0')result += "000";
            else if (octalNumber[i] == '1')result += "001";
            else if (octalNumber[i] == '2')result += "010";
            else if (octalNumber[i] == '3')result += "011";
            else if (octalNumber[i] == '4')result += "100";
            else if (octalNumber[i] == '5')result += "101";
            else if (octalNumber[i] == '6')result += "110";
            else result += "111";
        }
        //맨 처음 글자가 0이 아닐 때까지 반복
        while (result[0] == '0') {
            result = result.substr(1);
        }

        cout <<result<<endl;

        return 0;
}