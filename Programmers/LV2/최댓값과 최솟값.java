import java.util.*;

class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        
        String[] arr = s.split(" ");
        int [] nums = new int[arr.length];
        
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i=0; i<arr.length; i++) {
            int n = Integer.parseInt(arr[i]);
            
            if(n > max) max = n;
            if(n < min) min = n;
        }
        
        sb.append(min);
        sb.append(" ");
        sb.append(max);
        
        return sb.toString();
    }
}
