import java.util.*;

class Solution {
    public String[] solution(String[] strings, int n) {
        // 두 문자열이 해당 인덱스에서의 동일한 문자값을 가진다면 사전순으로 정렬한다
        Arrays.sort(strings, (s1, s2) -> {
            if(s1.charAt(n) == s2.charAt(n)) {
                return s1.compareTo(s2);
            }
            
            return s1.charAt(n) - s2.charAt(n);
        });
        
        return strings;
    }
}
