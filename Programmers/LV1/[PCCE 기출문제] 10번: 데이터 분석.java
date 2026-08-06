import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        // data에서 ext값이 val_ext보다 작은 데이터만 뽑음
        // sort_by를 기준으로 오름차순 정렬
        
        Map<String, Integer> map = new HashMap<>();
        map.put("code", 0);
        map.put("date", 1);
        map.put("maximum", 2);
        map.put("remain", 3);
        
        // 비교할 인덱스
        int index1 = map.get(ext);
        int index2 = map.get(sort_by);
        
        List<int[]> list = new ArrayList<>();
        
        for(int[] d: data) {
            if(d[index1] < val_ext) list.add(d);
        }
        
        // 특정 인덱스를 기준으로 오름차순 정렬
        Collections.sort(list, (a, b) -> Integer.compare(a[index2], b[index2]));
        
        int[][] answer = new int[list.size()][4];
        
        int i=0;
        for(int[] x: list) {
            answer[i] = x;
            i++;
        }
        
        return answer;
    }
}
