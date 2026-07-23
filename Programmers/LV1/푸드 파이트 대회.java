import java.util.*;

class Solution {
    public String solution(int[] food) {
//         ArrayList<Integer> list = new ArrayList<>();
        
//         for(int i=1; i<food.length; i++) {
//             int a = food[i] / 2;
//             for(int k=0; k<a; k++) {
//                 list.add(i);
//             }
//         }
        
//         int len = list.size();
//         list.add(0);
        
//         for(int i=len-1; i>=0; i--) {
//             int value = list.get(i);
//             list.add(value);
//         }
        
//         StringBuilder sb = new StringBuilder();
//         for(int i=0; i<list.size(); i++) {
//             String s = list.get(i).toString();
//             sb.append(s);
//         }
        
//         return sb.toString();
        
        StringBuilder left = new StringBuilder();
        for(int i=1; i<food.length; i++) {
            for(int j=0; j < food[i] / 2; j++) {
                left.append(i);
            }
        }
        
        return left + "0" + new StringBuilder(left).reverse();
    }
}
