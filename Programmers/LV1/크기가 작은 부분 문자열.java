class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        
        int len1 = t.length();
        int len2 = p.length();
        long numP = Long.parseLong(p);
        
        for(int i=0; i<=len1-len2; i++) {
            String sub = t.substring(i, i+len2);
            
            if(Long.parseLong(sub) <= numP) {
                answer ++;
            }
        }
        
        return answer;
    }
}
