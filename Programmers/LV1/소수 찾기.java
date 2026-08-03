import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
                
//         for(int i=1; i<=n; i++) {
//             int count = 0;
//             for(int j=1; j * j<=i; j++) {
//                 if(i % j == 0) {
//                     if(j * j == i) count ++;
//                     else count += 2;
//                 }
//             } 
//             if(count == 2) answer++;
//         }
        
        
        // 에라토스테네스의 체
        boolean[] prime = new boolean[n+1];
        Arrays.fill(prime, true);  // 모두 소수라고 가정
        
        // 0과 1은 소수가 아님
        prime[0] = false;
        prime[1] = false;
        
        // 모든 소수들에 대해 소수의 배수는 false 처리함
        for(int i=2; i * i <=n; i++) {
            if(prime[i]) {
                for(int j= i * i; j<=n; j+=i) {
                    prime[j] = false;
                }
            }   
        }
        
        for(int i=2; i<=n; i++) {
            if(prime[i]) answer++;
        }
         
        return answer;
    }
}
