class Solution {
    public int[] solution(String s) {
        
        int zeroSum = 0;
        int round = 0;
        
        while(!s.equals("1")) {
            round++;
            StringBuilder sb = new StringBuilder();
            StringBuilder twoSb = new StringBuilder();
            
            for(char c: s.toCharArray()) {
                if(c == '1') sb.append(c);
                else zeroSum++;
            }
            
            // 0 제거 후 길이
            int num = sb.length();
            while(num > 0) {
                int n = num % 2;
                num /= 2;
                
                twoSb.append(n);
            }
            
            twoSb.reverse();
            s = twoSb.toString();
        }
        
        int[] answer = { round, zeroSum };
        
        return answer;
    }
}
