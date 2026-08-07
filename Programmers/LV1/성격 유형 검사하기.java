import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        StringBuilder answer = new StringBuilder();
        
        Map<Character, Integer> mapType = new HashMap<>();
        mapType.put('R', 0);
        mapType.put('T', 0);
        mapType.put('C', 0);
        mapType.put('F', 0);
        mapType.put('J', 0);
        mapType.put('M', 0);
        mapType.put('A', 0);
        mapType.put('N', 0);
        
        // Map<Integer, Integer> map = new HashMap<>();
        // map.put(1, 3);  // 매우 비동의
        // map.put(2, 2);  // 비동의
        // map.put(3, 1);  // 약간 비동의
        // map.put(4, 0);  // 모르겠음
        // map.put(5, 1);  // 약간 동의
        // map.put(6, 2);  // 동의
        // map.put(7, 3);  // 매우 동의
        
        for(int i=0; i<survey.length; i++) {
            String s = survey[i];
            int choice = choices[i];
            int score = Math.abs(4 - choice);
            
            if(choice == 4) {
                continue;
            } else if(choice < 4) {
                char c = s.charAt(0);
                mapType.put(c, mapType.get(c) + score);
            } else if(choice > 4) {
                char c = s.charAt(1);
                mapType.put(c, mapType.get(c) + score);
            }
        }
        
        // 유형 뽑아내기
        if(mapType.get('R') >= mapType.get('T')) answer.append('R');
        else answer.append('T');
        
        if(mapType.get('C') >= mapType.get('F')) answer.append('C');
        else answer.append('F');
        
        if(mapType.get('J') >= mapType.get('M')) answer.append('J');
        else answer.append('M');
        
        if(mapType.get('A') >= mapType.get('N')) answer.append('A');
        else answer.append('N');
            
        return answer.toString();
    }
}
