class Solution {
    public int solution(String s) {
        int answer = 0;
        
        int idx = 0;
        int curr = 0;
        int same = 0, diff = 0;
        char first = 'a';
        
        while(idx < s.length()) {
            char currchar = s.charAt(idx);
            
            if(curr == 0) {
                // 덩어리의 첫번째 일때
                first = currchar;
                same++;
            } else {
                // 덩어리의 첫번째가 아닐 때
                if(currchar == first) same++;
                else diff++;
            }
            
            if(same == diff) {
                answer++;
                curr = 0;
                idx++; 
                continue;
            }
            
            idx++;
            curr++;
            if(curr !=0 && idx == s.length()) answer++;
        }
        
        return answer;
    }
}
