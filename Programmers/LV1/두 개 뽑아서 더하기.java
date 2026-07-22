import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i=0; i<numbers.length; i++) {
            for(int j=i+1; j<numbers.length; j++) {
                int sum = numbers[i] + numbers[j];
                
                boolean found = false;
                for(int k=0; k<list.size(); k++) {
                    if(sum == list.get(k)) {
                        found = true;
                        break;
                    }
                }
                
                if(!found) list.add(sum);
            }
        }
        
        Collections.sort(list);
        
        int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}
