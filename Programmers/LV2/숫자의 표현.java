class Solution {
    public int solution(int n) {
        int answer = 0;
        
        // 시작지점이 어디인지에 따른 for문을 돌린다.
        for(int i=1; i<n; i++) {
            boolean isPossible = false;
            int sum = 0;
            sum += i;
            
            int j=i+1;
            
            while(sum <= n) {
                sum += j;
                if(sum == n) {
                    isPossible = true;
                    break;
                }
                j++;
            }
            
            if(isPossible) answer++;
        }
        
        return answer + 1;
    }
}
