import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        
//         for(int i=0; i < targets.length; i++) {
//             String target = targets[i];
//             int temp = 0;
            
//             for(char c : target.toCharArray()) {
//                 int count = 0;
//                 List<Character> list = new ArrayList<>();
                
//                 while(count < 100) {
//                     for(int j=0; j<keymap.length; j++) {
//                         if(count < keymap[j].length()) list.add(keymap[j].charAt(count));
//                     }

//                     if(list.contains(c)) {
//                         temp += count + 1;
//                         break;
//                     }
                    
//                     count++;
//                     if(count == 100) temp = -1;
//                 }  
                
//                 if(temp == -1) break;
//             }
            
//             answer[i] = temp;
//         }
        
        // 각 문자 별로 최소 입력수를 저장
        int[] minPress = new int[26];
        Arrays.fill(minPress, Integer.MAX_VALUE);
        
        for(String key: keymap) {
            for(int i=0; i<key.length(); i++) {
                char c = key.charAt(i);
                minPress[c - 'A'] = Math.min(minPress[c - 'A'], i+1);
            }
        }
        
        for(int idx = 0; idx < targets.length; idx++) {
            String target = targets[idx];
            boolean possible = true;
            int temp = 0;
            
            for(int i=0; i<target.length(); i++) {
                char c = target.charAt(i);
                
                if(minPress[c - 'A'] == Integer.MAX_VALUE) possible = false;
                else temp += minPress[c - 'A'];
            }
            
            if(!possible) answer[idx] = -1;
            else answer[idx] = temp;
        }
        
        return answer;
    }
}
