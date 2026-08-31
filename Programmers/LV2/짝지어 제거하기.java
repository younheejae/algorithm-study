class Solution {
    public int solution(String s) {
        
        char[] stack = new char[s.length()];
        int top = 0;
        
        for(char c: s.toCharArray()) {
            if(top > 0 && stack[top-1] == c) {
                top--;
            } else {
                stack[top++] = c;
            }
        }
        
        return top == 0 ? 1 : 0;
        
//         while(s.length() > 0) {        
//             for(int i=0; i<s.length() - 1; i++) {
                
//                 if(s.charAt(i) == s.charAt(i+1)) {
//                     String sub1 = s.substring(0, i);
//                     String sub2 = s.substring(i+2);

//                     s = sub1 + sub2;
//                     break;
                    
//                 } else {

//                     if(i == s.length() -2) return 0;
//                 }
//             }
//         }
        
//         return 1;
    }
}
