package week8;
// 키패드 누르기
class Solution_1 {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        Position l = new Position('*',0, 3), r = new Position('#',2, 3);
        int num=0;
        for (int i=0;i<numbers.length;i++){
            num=numbers[i];
            answer += switch (num) {
                case 1,4,7 ->{
                    if (num==1)
                        l.setPos(0, 0);
                    else if(num==4)
                        l.setPos(0, 1);
                    else
                        l.setPos(0, 2);
                    yield "L";
                }
                case 3,6,9 -> {
                    if (num==3)
                        r.setPos(2, 0);
                    else if(num==6)
                        r.setPos(2, 1);
                    else
                        r.setPos(2, 2);
                    yield "R";
                }
                case 2,5,8,0 -> {
                    if (l.getN()==num) yield "L";
                    else if (r.getN()==num) yield "R";
                    int cY;
                    if(num==2){
                        cY=0;
                    } else if (num==5){
                        cY=1;
                    } else if (num==8){
                        cY=2;
                    } else {
                        cY=3;
                    }
                    if (1-l.getX()+Math.abs(l.getY()-cY) < r.getX()-1+Math.abs(r.getY()-cY)){
                        l.setPos(1,cY);
                        yield "L";
                    } else if (1-l.getX()+Math.abs(l.getY()-cY) > r.getX()-1+Math.abs(r.getY()-cY)){
                        r.setPos(1,cY);
                        yield "R";
                    } else {
                        if (hand.equals("left")) {
                            l.setPos(1,cY);
                            yield "L";
                        }
                        else {
                            r.setPos(1,cY);
                            yield "R";
                        }
                    }
                }
                default -> "";
            };
        }
        return answer;
    }

    class Position{
        private int n;
        private int x;
        private int y;
        Position(int n, int x, int y){
            this.n=n;
            this.x = x;
            this.y = y;
        }
        void setPos(int x, int y){
            this.x=x;
            this.y=y;
        }
        int getN(){
            return n;
        }
        int getX(){
            return x;
        }
        int getY(){
            return y;
        }
    }
}