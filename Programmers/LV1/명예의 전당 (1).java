import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
    
//         for(int i=0; i<score.length; i++) {
//             // k일차 까지만 자른다.
//             int [] temp = new int [i+1];
//             for(int j=0; j<temp.length; j++) {
//                 temp[j] = score[j];
//             }
            
//             // 정렬
//             Arrays.sort(temp);
            
//             // k일까지는 최하위 점수를 출력한다.
//             if(i+1 <= k) {
//                 answer[i] = temp[0];
//             }
//             else {
//                 answer[i] = temp[temp.length-k];
//             }
//         }
        
        // PriorityQueue는 항상 가장 작은 값이 peek()와 poll()로 나오도록 유지된다.
        // 전체 오름차순 정렬 아님.
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<score.length; i++) {
            pq.add(score[i]);
            
            if(pq.size()>k) {
                pq.poll();
            }
            
            answer[i] = pq.peek();
        }

        return answer;
    }
}
