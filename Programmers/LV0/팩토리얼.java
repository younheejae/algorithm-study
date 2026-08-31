class Solution {
    public int solution(int n) {
        
        for(int i=10; i>=1; i--) {
            int num = i;
            for(int j=i-1; j>=1; j--) {
                num *= j;
            }
            
            if(num > n) continue;
            else return i;
        }
        
        return 0;
    }
}
