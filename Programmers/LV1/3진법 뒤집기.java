import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        
        ArrayList<Integer> list = new ArrayList<>();
        
        while(n > 0) {
            int a = n % 3;  // 나머지
            n = n / 3;
            
            list.add(a);
        }
        
        int k = 0;
        for(int i=list.size() - 1; i >= 0; i--) {
            answer += list.get(i) * Math.pow(3, k);
            k++;
        }
        
        return answer;
    }
}
