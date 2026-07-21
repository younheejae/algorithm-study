import java.util.*;

// 그리디 문제: 비용이 적은 부서부터 지원해야 많이 지원해줄 수 있다.
class Solution {
    public int solution(int[] d, int budget) {        
        Arrays.sort(d);  // 오름차순 정렬
        
        int current = 0;
        int total = 0;
        
        for(int i=0; i<d.length; i++) {
            if(current + d[i] <= budget) {
                current += d[i];
                total++;
            }
        }
        
        return total;
    }
}
