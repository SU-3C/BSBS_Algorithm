#include <iostream>
#include <algorithm>

using namespace std;

//문양과 숫자를 담을 pair 선언
vector<pair<char,short>> Card;

//정렬 규칙 정의
bool compare(pair<char,short>a, pair<char,short>b){
    return a.second<b.second;
}

//스트레이트 플러쉬
bool Straight_Flush(){
    bool isYes= true;
    //만일 숫자가 연속되지 않거나, 문양이 다르면
    for(int i=0;i<4;i++)
    {
        if(Card[i].first!=Card[i+1].first || (Card[i].second+1!= Card[i+1].second))
        {
            isYes= false;
            break;
        }
    }
    return isYes;
}
//포카드
bool Four_Card(){
    bool isYes= false;
    
    //같은 숫자가 카운트가 4가 될 때
    for(int i=1;i<10;i++){
        int Count=0;
        for (int j = 0; j < 5; ++j) {
            if(Card[j].second==i)
                Count++;
        }
        if(Count==4) {
            isYes= true;
            break;
        }
    }

    return isYes;
}
//풀하우스
bool Full_House(){
    bool isYes= false;
    
    //정렬이 되어 있으므로, 앞3뒤2, 앞2뒤3의 경우에
    if(Card[0].second==Card[1].second)
        if(Card[2].second==Card[3].second&&Card[3].second==Card[4].second)
            isYes= true;

    if(Card[0].second==Card[1].second&&Card[1].second==Card[2].second)
        if(Card[3].second==Card[4].second)
            isYes= true;

    return isYes;
}
//플러시
bool Flush(){
    bool isYes= true;
    
    //모든 문양이 같은 때
    for (int i = 0; i < 4; ++i) {
        if(Card[i].first!=Card[i+1].first){
            isYes= false;
            break;
        }
    }

    return isYes;
}
//스트레이트
bool Straight(){
    bool isYes= true;
    //모든 숫자가 연속될 때
    for (int i = 0; i < 4; ++i) {
        if(Card[i].second+1!=Card[i+1].second){
            isYes= false;
            break;
        }
    }
    return isYes;
}
//트리플
bool Triple(){
    bool isYes= false;
    
    //012 / 123 / 234 의 숫자가 같을 때
    for (int i = 0; i < 3; ++i) {
        if(Card[i].second==Card[i+1].second&&Card[i+1].second==Card[i+2].second)
            isYes=true;
    }

    return isYes;
}
//투 페어
int Two_Pair(){
    bool isYes= false;
    //경우의 수를 모두 포함
    if(Card[0].second==Card[1].second && Card[2].second==Card[3].second)
       return 300+max(Card[0].second,Card[2].second)*10+ min(Card[0].second,Card[2].second);

    if(Card[0].second==Card[1].second && Card[3].second==Card[4].second)
        return 300+max(Card[0].second,Card[3].second)*10+ min(Card[0].second,Card[3].second);

    if(Card[1].second==Card[2].second && Card[3].second==Card[4].second)
        return 300+max(Card[1].second,Card[3].second)*10+ min(Card[1].second,Card[3].second);


    return 0;
}
//원 페어
bool One_Pair(){
    bool isYes= false;

    for (int i = 0; i < 4; ++i) {
        if(Card[i].second==Card[i+1].second)
            isYes= true;
    }

    return isYes;
}
bool High(){
    return true;
}

int main(){
    char color;
    short number;
    for(int i=0;i<5;i++){
        cin>>color>>number;
        Card.push_back({color,number});
    }
    sort(Card.begin(),Card.end(), compare);

    int Score=0;
    if(Straight_Flush()){
        Score=900+Card[4].second;
        cout<<Score<<endl;
        return 0;
    }
    if(Four_Card()){
        Score=800+Card[3].second;
        cout<<Score<<endl;
        return 0;
    }
    if(Full_House()){
        int big,small;
        if(Card[0].second==Card[2].second)
            Score=700+Card[2].second*10+Card[4].second;
        else
            Score=700+Card[4].second*10+Card[0].second;
        cout<<Score<<endl;
        return 0;
    }
    if(Flush()){
        Score=600+Card[4].second;
        cout<<Score<<endl;
        return 0;
    }
    if(Straight()) {
        Score=500+Card[4].second;
        cout<<Score<<endl;
        return 0;
    }
    if(Triple()) {
        Score=400+Card[2].second;
        cout<<Score<<endl;
        return 0;
    }
    if(Two_Pair()) {

        cout<<Two_Pair()<<endl;
        return 0;
    }
    if(One_Pair()) {

        for (int i = 0; i < 4; ++i) {
            if(Card[i].second==Card[i+1].second){
                Score=Card[i].second+200;
                break;
            }
        }
        cout<<Score<<endl;
        return 0;
    }
    if(High()) {
        Score=100+Card[4].second;
        cout<<Score<<endl;
        return 0;
    }
}