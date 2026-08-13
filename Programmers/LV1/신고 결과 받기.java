import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        
        Map<String, Integer> ids = new HashMap<>();
        for(int i=0; i<id_list.length; i++) {
            ids.put(id_list[i], 0);
        }
        
        Map <String, Set<String>> map = new HashMap<>();
        
        // 각 유저별로 본인을 신고한 유저 이름을 리스트로 담음
        for(int i=0; i<report.length; i++) {
            String[] arr = report[i].split(" ");
            String reportered = arr[1];  // 신고당한 사람
            String reporter = arr[0];    // 신고한 사람
                
            map.putIfAbsent(reportered, new HashSet<>());
            map.get(reportered).add(reporter);  // set에 신고자 이름을 넣음
        }
        
        // k번 이상 신고당한 사람에 대해 해당 유저를 신고한 사람들을 꺼내 값을 증가해줌
        for(Map.Entry<String, Set<String>> entry: map.entrySet()) {
            if(entry.getValue().size() >= k) {
                for(String reporter: entry.getValue()) {
                    ids.put(reporter, ids.get(reporter) + 1);
                }
            }
        }
        
        for(int i=0; i<id_list.length; i++) {
            String user = id_list[i];
            answer[i] = ids.get(user);       
        }
        
        return answer;
    }
}
