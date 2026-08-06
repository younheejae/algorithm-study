import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        
        int[] cntX = new int[10];
        int[] cntY = new int[10];
        
        for(char c: X.toCharArray()) {
            int num = c - '0';
            cntX[num]++;
        }
        for(char c: Y.toCharArray()) {
            int num = c - '0';
            cntY[num]++;
        }
        
        List<Integer> list = new ArrayList<>();
        
        for(int i=0; i<10; i++) {
            if(cntX[i] > 0 && cntY[i] > 0) {
                int min = Math.min(cntX[i], cntY[i]);
                
                for(int j=0; j<min; j++) list.add(i);
            }
        }
                
        Collections.sort(list, Collections.reverseOrder());  // 내림차순 정렬
        
        StringBuilder sb = new StringBuilder();
        for(int i: list) sb.append(i);
    
        if(sb.length() == 0) return "-1";
        if(sb.charAt(0) == '0') return "0";
        
        return sb.toString();
    }
}
