import java.util.*;

class Solution {
    public int solution(String s) {
        StringBuilder answer = new StringBuilder();
        StringBuilder sb = new StringBuilder();
        
        Map<String, String> map = new HashMap<>();
        map.put("zero", "0");
        map.put("one", "1");
        map.put("two", "2");
        map.put("three", "3");
        map.put("four", "4");
        map.put("five", "5");
        map.put("six", "6");
        map.put("seven", "7");
        map.put("eight", "8");
        map.put("nine", "9");
        
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            // 숫자라면
            if(Character.isDigit(c)) {
                answer.append(c);
            }
            // 문자라면
            else {
                sb.append(c);
                if(map.containsKey(sb.toString())) {
                    answer.append(map.get(sb.toString()));
                    sb.setLength(0);
                }
            }
        }
        
        return Integer.parseInt(answer.toString());
        
//         s = s.replace("zero", "0");
//         s = s.replace("one", "1");
//         s = s.replace("two", "2");
//         s = s.replace("three", "3");
//         s = s.replace("four", "4");
//         s = s.replace("five", "5");
//         s = s.replace("six", "6");
//         s = s.replace("seven", "7");
//         s = s.replace("eight", "8");
//         s = s.replace("nine", "9");
        
//         return Integer.parseInt(s);
    }
}
