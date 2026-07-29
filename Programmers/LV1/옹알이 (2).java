class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        
        String[] arr = { "aya", "ye", "woo", "ma" };
        
        for(String s: babbling) {
            String prev = "";
            int idx = 0;
            boolean available = true;
            
            while(idx < s.length()) {    
                boolean found = false;
                
                for(int i=0; i<4; i++) {
                    if(s.startsWith(arr[i], idx)) {
                        found = true;
                        String curr = arr[i];
                        
                        if(curr.equals(prev)) {
                            available = false;
                            break;
                        }
                        
                        idx += arr[i].length();
                        prev = curr;
                        break;
                    }
                }
                
                // 같은 발음이 두번나와 안되는 경우
                if(!available) {
                    break;
                }
                
                // 발음 가능한 문자가 없는 경우
                if(!found) {
                    available = false;
                    break;
                }
            }
            
            if(available) answer++;
        }
        return answer;
    }
}
