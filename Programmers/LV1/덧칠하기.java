class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        
        int cover = section[0] - 1;  // 어디까지 커버했는지
        
        
        for(int s: section) {
            if(s > cover) {
                cover = s + m - 1;
                answer++;
            }
        }
        
        return answer;
    }
}
