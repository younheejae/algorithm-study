import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int len = nums.length;
        
//         ArrayList<Integer> list = new ArrayList<>();
                
//         for(int i=0; i<len; i++) {
//             if(!list.contains(nums[i])) {
//                 list.add(nums[i]);
//             }
//         }
        
//         if(list.size() < len/2) {
//             answer = list.size();
//         } else {
//             answer = len/2;
//         }
        
        Set<Integer> set = new HashSet<>();
        
        for(int i=0; i<len; i++) {
            set.add(nums[i]);
        }
        
        answer = Math.min(set.size(), len/2);
        
        return answer;
    }
}
