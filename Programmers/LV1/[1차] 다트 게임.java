import java.util.*;

class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        
        Map<Character, Integer> map = new HashMap<>();
        map.put('S', 1);
        map.put('D', 2);
        map.put('T', 3);
        
        int idx = 0;
        int prev = 0;
        while(idx < dartResult.length() - 1) {
            int num1 = 0, num2 = 0;
            // 10일때
            if(dartResult.charAt(idx) == '1' && dartResult.charAt(idx+1) == '0') {
                num1 = 10;
                idx++;
            // 10이 아닐 때
            } else {
                num1 = dartResult.charAt(idx) - '0';
            }
            
            num2 = map.get(dartResult.charAt(idx + 1));
            int temp = (int) Math.pow(num1, num2);
            int curr = temp;
                        
            if(idx+2 < dartResult.length() && dartResult.charAt(idx + 2) == '*') {
                // 스타상
                answer += prev;  // 이전 점수를 두배
                curr *= 2;  // 본인을 두배
                idx++;
            } else if(idx+2 < dartResult.length() && dartResult.charAt(idx + 2) == '#') {
                // 아차상
                curr *= (-1);  // 본인을 -1배    
                idx++;
            }
            
            idx += 2;
            answer += curr;
            prev = curr;
        }
        
        return answer;
    }
}
