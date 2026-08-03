import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        Map<Integer, Float> map = new HashMap<>();
        
        // 실패율 계산
        for(int i=1; i<=N; i++) {
            // 분모: i 이상인 수의 개수
            // 분자: i의 개수
            int a = 0, b = 0;
            for(int j=0; j<stages.length; j++) {
                if(stages[j] >= i) a++;
                if(stages[j] == i) b++;
            }
            
            float ratio = 0;
            if(a != 0) {
                ratio = (float) b / a;
            }
            
            map.put(i, ratio);
        }
        
        List<Integer> list = new ArrayList<>(map.keySet());
        list.sort((a, b) -> {
            if(map.get(a).equals(map.get(b))) return a - b;
            
            return Float.compare(map.get(b), map.get(a));
        });
                
        for(int i=0; i<N; i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}
