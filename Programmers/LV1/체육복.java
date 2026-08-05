import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        
        int[] students = new int[n + 1];
        Arrays.fill(students, 1);  // 1번부터 n번 학생까지 모두 한개씩 가지고있음.
        students[0] = 0;
        
        for(int i=0; i<lost.length; i++) {
            int s = lost[i];
            students[s] -= 1;
        }
        for(int i=0; i<reserve.length; i++) {
            int s = reserve[i];
            students[s] += 1;
        }
        
        for(int i=1; i<=n; i++) {
            if(students[i] == 0) {
                if(students[i-1] == 2) {
                    students[i] += 1;
                    students[i-1] -= 1;
                    continue;
                } else if(i+1 <=n && students[i+1] == 2) {
                    students[i] += 1;
                    students[i+1] -= 1;
                    continue;
                }
            }
        }
        
        for(int i=1; i<=n; i++) {
            if(students[i] > 0) answer++;
        }
        
        return answer;
    }
}
