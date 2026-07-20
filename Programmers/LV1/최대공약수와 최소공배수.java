class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int [2];
        
        int bigger = Math.max(n, m);
        int smaller = Math.min(n, m);
        
        // 최대공약수 구하기
        long num1 = 0;
        for(int i=1; i<=smaller; i++) {
            if(n % i == 0 && m % i == 0) {
                num1 = i;
            }
        }
        
        // 최소공배수 구하기
        long num2 = 0;
        for(long i=n*m; i>=bigger; i--) {
            if(i % n == 0 && i % m  == 0) {
                num2 = i;
            }
        }
        
        answer[0] = (int) num1;
        answer[1] = (int) num2;
        
        return answer;
    }
}
