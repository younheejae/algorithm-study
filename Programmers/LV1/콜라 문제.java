class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        
        // a 개를 가져갔을때 b 개를 준다.
        while(n >= a) {
            int temp = (n / a) * b;
            answer += temp;
            n = n % a + temp;
        }
        return answer;
    }
}
