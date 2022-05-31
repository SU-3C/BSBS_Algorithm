#include <iostream>
#include <math.h>
#include <algorithm>
#include <vector>

using namespace std;

int main(){

    while (true) {
        //주어진 세변의 길이
        vector<int> Triangle;
        int Num;
        for (int i = 0; i < 3; ++i) {
            cin >> Num;
            Triangle.push_back(Num);
        }

        //0 ,0 ,0의 경우
        if (Triangle[0]==0 && Triangle[1] == 0 && Triangle[2] == 0)
            return 0;

        //큰 수 나열을 위한 정렬
        sort(Triangle.begin(), Triangle.end());

        //피타고라스의 정리
        if (pow(Triangle[0], 2) + pow(Triangle[1], 2) == pow(Triangle[2], 2))
            cout << "right\n";
        else
            cout << "wrong\n";

    }
        return 0;
}