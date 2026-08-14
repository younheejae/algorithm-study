import java.util.*;

class Solution {
    public int solution(int n, int w, int num) {
        int answer = 0;
                
        // n개의 택배 상자를 다 놓을 때까지 한 층에 w개씩
        Map<Integer, Stack<Integer>> map = new HashMap<>();
        
        int idx = 1;
        boolean isRight = true;
        
        // 나머지와 stack을 매핑
        for(int i=1; i<=n; i++) {
                
            map.putIfAbsent(idx, new Stack<>());
            map.get(idx).add(i);
            
            if(isRight) {
                // 오른쪽으로 이동
                idx++;
                if(idx > w) {
                    idx = w;
                    isRight = false;
                }
            } else {
                // 왼쪽으로 이동
                idx--;
                if(idx < 1) {
                    idx = 1;
                    isRight = true;
                }
            }
        }
        
        int targetIdx = 0;
        for(int key: map.keySet()) {
            if(map.get(key).contains(num)) {
                targetIdx = key;
                break;
            }
        }
        
        while(!map.get(targetIdx).isEmpty()) {            
            answer++; 
            if(map.get(targetIdx).peek() == num) break;
            
            map.get(targetIdx).pop();
        }
        
        return answer;
    }
}
