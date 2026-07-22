class Solution {
    public int[] solution(String s) {
        int len = s.length();
        int[] answer = new int[len];
        
        for(int i=0; i<len; i++) {
            boolean found = false;
            int num = 0;
            for(int k=i-1; k>=0; k--) {
                num++;
                
                if(s.charAt(i) == s.charAt(k)) {
                    found = true;
                    break;
                }
            }
            
            if(!found) {
                answer[i] = -1;
            } else {
                answer[i] = num;
            }
        }
        
        return answer;
    }
}
