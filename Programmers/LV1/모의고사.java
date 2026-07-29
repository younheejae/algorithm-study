import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        
        int[] arr1 = { 1, 2, 3, 4, 5 };  // 5개
        int[] arr2 = { 2, 1, 2, 3, 2, 4, 2, 5 };  // 8개
        int[] arr3 = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };  // 10개
        
        int[] counts = new int[3];
        
        for(int i=0; i<answers.length; i++) {
            if(answers[i] == arr1[i % 5]) counts[0]++;
            if(answers[i] == arr2[i % 8]) counts[1]++;
            if(answers[i] == arr3[i % 10]) counts[2]++;
        }
        
        int max = Math.max(counts[0], Math.max(counts[1], counts[2]));
        
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0; i<3; i++) {
            if(counts[i] == max) list.add(i+1);
        }
        
        int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}
