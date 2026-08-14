import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        // 두 사람의 기록이 있는 경우
        // 더 많이 줬던 사람이 하나 받는다.
        
        // 두 사람의 기록이 없거나 기록이 같은 경우
        // 선물 지수가 더 큰 사람이 하나 받는다.
        
        // 선물 지수: 친구들에게 준 선물 수 - 받은 선물 수
        
        int n = friends.length;
        
        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<friends.length; i++) {
            map.put(friends[i], i);
        }
        
        int[][] arr = new int[n][n];
        
        for(int i=0; i<gifts.length; i++) {
            String[] gift = gifts[i].split(" ");
            String give = gift[0];  // 선물 준 사람
            String receive = gift[1];  // 선물 받은 사람
            
            arr[map.get(give)][map.get(receive)]++;
        }
        
        // 선물 지수
        Map<String, Integer> giftScore = new HashMap<>();
        for(int i=0; i<n; i++) {
            int idx = map.get(friends[i]);
            
            int gave = 0, received = 0;
            // 준 선물 수
            for(int j=0; j<n; j++) gave += arr[idx][j];
            // 받은 선물 수
            for(int j=0; j<n; j++) received += arr[j][idx];
            
            giftScore.put(friends[i], gave - received);
        }
        
        // 각자 받을 선물의 개수
        int[] answer = new int[n];
        for(int i=0; i<n; i++) {
            for(int j=i+1; j<n; j++) {
                // 이제 친구 두명을 꺼내서 비교
                String friend1 = friends[i];
                String friend2 = friends[j];
                
                int idx1 = map.get(friend1);
                int idx2 = map.get(friend2);
                
                // friend1이 friend2에게 준 선물 수
                int gift1To2 = arr[idx1][idx2];
                // friend2이 friend1에게 준 선물 수
                int gift2To1 = arr[idx2][idx1];
                
                if(gift1To2 > gift2To1) {
                    answer[idx1]++;   // 친구1이 더 많이 주었으므로 친구1이 받는다
                } else if(gift1To2 < gift2To1) {
                    answer[idx2]++;   // 친구2가 더 많이 주었으므로 친구2가 받는다
                } else {
                    if(giftScore.get(friend1) > giftScore.get(friend2)) answer[idx1]++;
                    else if(giftScore.get(friend1) < giftScore.get(friend2))answer[idx2]++;
                }              
            }
        }
        
        int max = -1;
        for(int i=0; i<n; i++) {
            if(answer[i] > max) max = answer[i];
        }
        
        return max;
    }
}
