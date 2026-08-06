import java.util.*;

class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        
        // 1: 빵, 2: 야채, 3: 고기 -> 1, 2, 3, 1
//         List<Integer> list = new ArrayList<>();
        
//         for(int i=0; i<ingredient.length; i++) {
//             list.add(ingredient[i]);
//         }
        
//         int idx = 0;
//         while(idx < list.size() - 3) {
//             if(list.get(idx) == 1 && list.get(idx+1) == 2 
//                && list.get(idx+2) == 3 && list.get(idx+3) == 1) {
//                 answer++;
                
//                 for(int i=0; i<4; i++) list.remove(idx);  // 4개를 연속으로 제거
                                
//                 idx = 0;
//                 continue;
//             }
//             idx++;
//         }
        
        Stack<Integer> stack = new Stack<>();
        
        for(int x: ingredient) {
            stack.push(x);
            
            if(stack.size() >= 4) {
                int n = stack.size();
                
                if(stack.get(n-4) == 1 &&
                  stack.get(n-3) == 2 &&
                  stack.get(n-2) == 3 &&
                  stack.get(n-1) == 1) {
                    answer++;
                    
                    for(int i=0; i<4; i++) stack.pop();
                }
            }
        }
        
        return answer;
    }
}
