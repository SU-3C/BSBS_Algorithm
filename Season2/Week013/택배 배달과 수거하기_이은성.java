import java.util.Stack;

class Solution {
   public static void main(String[] args) {
        int cap = 2;
        int n = 2;
        int[] deliveries = {5, 0};
        int[] pickups = {0, 3};

        Solution deliveryAndCollection = new Solution();
        long solution = deliveryAndCollection.solution(cap, n, deliveries, pickups);
        System.out.print(solution);

    }

    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        Stack<CollectionInfo> pickupTrack = new Stack<>();
        Stack<CollectionInfo> deliveryTrack = new Stack<>();

        //초기화
        initCollectionAndDelivery(n, deliveries, pickups, deliveryTrack, pickupTrack);

        //수거 및 배달이 비었다. 즉 전부 완료를 진행했을 때 종료
        while (!pickupTrack.isEmpty() || !deliveryTrack.isEmpty()) {

            //더 먼 거리를 계산하는 메서드
            if (pickupTrack.isEmpty()) {
                answer += deliveryTrack.peek().getHomeDistance();
            } else if (deliveryTrack.isEmpty()) {
                answer += pickupTrack.peek().getHomeDistance();
            } else {
                if (pickupTrack.peek().getHomeDistance() >= deliveryTrack.peek().getHomeDistance()) {
                    answer += pickupTrack.peek().getHomeDistance();
                } else {
                    answer += deliveryTrack.peek().getHomeDistance();
                }
            }

            //스택에서 값을 꺼내 삭제를 해주는 메서드
            int capTmp = cap;
            while (capTmp != 0) {
                if (pickupTrack.isEmpty()) {
                    break;
                } else {
                    CollectionInfo pickUpValue = pickupTrack.pop();
                    int value = pickUpValue.getValue();
                    int homeDistance = pickUpValue.getHomeDistance();
                    for (int i = 0; i < capTmp; i++) {
                        capTmp--;
                        value--;
                        if (value == 0) break;
                    }
                    if (value != 0) {
                        CollectionInfo collectionInfo = new CollectionInfo();
                        collectionInfo.setValue(value);
                        collectionInfo.setHomeDistance(homeDistance);
                        pickupTrack.push(collectionInfo);
                    }
                }

            }

            capTmp = cap;
            while (capTmp != 0) {
                if (deliveryTrack.isEmpty()) {
                    break;
                } else {
                    CollectionInfo deliveryValue = deliveryTrack.pop();
                    int value = deliveryValue.getValue();
                    int homeDistance = deliveryValue.getHomeDistance();

                    for (int i = 0; i < capTmp; i++) {
                        capTmp--;
                        value--;
                        if (value == 0) break;
                    }

                    if (value != 0) {
                        CollectionInfo collectionInfo = new CollectionInfo();
                        collectionInfo.setValue(value);
                        collectionInfo.setHomeDistance(homeDistance);
                        deliveryTrack.push(collectionInfo);
                    }
                }

            }

        }

        return answer * 2;
    }

    private static void initCollectionAndDelivery(int n, int[] deliveries, int[] pickups, Stack<CollectionInfo> deliveryTrack, Stack<CollectionInfo> pickupTrack) {
        for (int i = 0; i < n; i++) {
            if (deliveries[i] != 0) {
                CollectionInfo collectionInfo = new CollectionInfo();
                collectionInfo.setHomeDistance(i + 1);
                collectionInfo.setValue(deliveries[i]);
                deliveryTrack.push(collectionInfo);
            }
        }

        for (int i = 0; i < n; i++) {
            if (pickups[i] != 0) {
                CollectionInfo collectionInfo = new CollectionInfo();
                collectionInfo.setHomeDistance(i + 1);
                collectionInfo.setValue(pickups[i]);
                pickupTrack.push(collectionInfo);
            }
        }
    }

    static class CollectionInfo {
        int homeDistance = 0;
        int value = 0;

        public int getHomeDistance() {
            return homeDistance;
        }

        public void setHomeDistance(int homeDistance) {
            this.homeDistance = homeDistance;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }
}
