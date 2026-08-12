import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = new String[players.length];
        
        Map<Integer, String> rankPer = new HashMap<>();
        Map<String, Integer> perRank = new HashMap<>();
        for(int i=0; i<players.length; i++) {
            rankPer.put(i, players[i]);  //  등수와 사람이름을 차례대로 넣음
            perRank.put(players[i], i);  // 사람이름과 등수를 차례대로 넣음
        }
        
        for(int i=0; i<callings.length; i++) {
            // 불린 사람의 등수를 찾는다.
            int curr = perRank.get(callings[i]);
            
            // 그 앞사람
            String prev_per = rankPer.get(curr-1);
            
            rankPer.put(curr, prev_per);
            rankPer.put(curr-1, callings[i]);
            
            perRank.put(prev_per, curr);
            perRank.put(callings[i], curr-1);
        }
        
        int idx = 0;
        for(int i=0; i<players.length; i++) {
            answer[i] = rankPer.get(i);
        }
        
        return answer;
    }
}
