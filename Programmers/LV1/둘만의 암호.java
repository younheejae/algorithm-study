class Solution {
    public String solution(String s, String skip, int index) {
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<s.length(); i++) {
            char moved = s.charAt(i);
            int cnt = 0;
            
            while(cnt < index) {
                moved++;
                if(moved > 'z') {
                    moved = 'a';
                }
                
                if(!skip.contains(Character.toString(moved)))  cnt++;
            }
            
            sb.append(moved);
        }
        
        return sb.toString();
    }
}
