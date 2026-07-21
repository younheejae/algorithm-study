class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder(s);
        
        int idx = 0;
        
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == ' ') {
                idx = 0;
                continue;
            }
            
            char c = s.charAt(i);
            if(idx % 2 == 0) {
                c = Character.toUpperCase(c);
            } else {
                c = Character.toLowerCase(c);
            }
            
            sb.setCharAt(i, c);
            idx++;
        }
        
        return sb.toString();
    }
}
