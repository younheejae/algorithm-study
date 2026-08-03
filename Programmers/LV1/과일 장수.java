import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        
        Integer[] arr = new Integer[score.length];
        for(int i=0; i<arr.length; i++) {
            arr[i] = score[i];
        }
        
        Arrays.sort(arr, (i, j) -> j-i);  // 내림차순 정렬
        
        int idx = 0;
        while(idx + m <= score.length) {
            int lower = arr[idx + m - 1];
            answer += lower * m;
            idx = idx + m;
        }
        
        return answer;
    }
}
