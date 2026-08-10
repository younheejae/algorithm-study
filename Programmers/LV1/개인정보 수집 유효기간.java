import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        
        Map <String, Integer> map = new HashMap<>();
        for(int i=0; i<terms.length; i++) {
            String[] term = terms[i].split(" ");
            map.put(term[0], Integer.parseInt(term[1]));
        }
        
        int todayDate = toDays(today);
        
        List<Integer> list = new ArrayList<>();
        
        for(int i=0; i<privacies.length; i++) {
            String[] arr = privacies[i].split(" ");
            
            int available_m = map.get(arr[1]);
            int privacyDate = toDays(arr[0]);
            
            if(todayDate >= available_m * 28 + privacyDate) {
                list.add(i+1);
            }
        }
        
        int [] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
        
        
        // 오늘
//         String[] todays = today.split("\\.");
//         int today_y = Integer.parseInt(todays[0]);
//         int today_m = Integer.parseInt(todays[1]);
//         int today_d = Integer.parseInt(todays[2]);
        
//         List<Integer> list = new ArrayList<>();
        
//         for(int i=0; i<privacies.length; i++) {
//             String[] arr_privacy = privacies[i].split(" ");
//             String[] day_privacy = arr_privacy[0].split("\\.");
            
//             // 해당 약관의 유효기간을 구함
//             String term = arr_privacy[1];
//             int available_m = map.get(term);
            
//             // 개인정보 수집 일자
//             int privacy_y = Integer.parseInt(day_privacy[0]);
//             int privacy_m = Integer.parseInt(day_privacy[1]);
//             int privacy_d = Integer.parseInt(day_privacy[2]);
            
//             // 파기되는 날짜
//             int expire_d = 0;
//             if(privacy_d == 1) expire_d = 28;
//             else expire_d = privacy_d - 1;
             
//             int a = (privacy_m + available_m) / 12;
//             int b = (privacy_m + available_m) % 12;
//             if(privacy_m + available_m == 12) {
//                 a = 0; b = 12;
//             }
            
//             int expire_m = b;
//             if(privacy_d == 1) {
//                 expire_m -= 1;
//                 if(expire_m == 0) expire_m = 12;
//             }
            
//             int expire_y = privacy_y + a;
            
//             System.out.printf("%d.%d.%d", expire_y, expire_m, expire_d);
//             System.out.println(" ");
            
//             // 오늘과 비교
//             if(today_y > expire_y) {
//                 list.add(i+1);
//                 continue;
//             } else if(today_y < expire_y) {
//                 continue;
//             } 
            
//             if(today_m > expire_m) {
//                 list.add(i+1);
//                 continue;
//             } else if(today_m < expire_m) {
//                 continue;
//             }
            
//             if(today_d > expire_d) {
//                 list.add(i+1);
//                 continue;
//             } else {
//                 continue;
//             }
//         }
        
        
//         int [] answer = new int[list.size()];
//         for(int i=0; i<list.size(); i++) {
//             answer[i] = list.get(i);
//         }
//         return answer;
    }
    
    int toDays(String date) {
        String[] arr = date.split("\\.");
        
        int year = Integer.parseInt(arr[0]);
        int month = Integer.parseInt(arr[1]);
        int day = Integer.parseInt(arr[2]);
        
        return year*12*28 + month*28 + day;
    }
}
