class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        // startday: 1은 월요일, 2는 화요일, 3은 수요일, 4는 목요일, 5는 금요일, 6은 토요일, 7은 일요일에 이벤트를 시작
        int n = schedules.length;  // 직원수
        for(int i=0; i<n; i++) {
            int[] timelog = timelogs[i];
            int time = schedules[i];
            
            // 목표 출근 시간
            int goal_hour = time / 100;
            int goal_min = time % 100;
            
            if(goal_min + 10 >=60) {
                goal_min = goal_min + 10 - 60;
                goal_hour += 1;
            } else {
                goal_min += 10;
            }
            
            int goal = 100 * goal_hour + goal_min;
            
            boolean isSuccess = true;
            int today = startday;
            for(int j=0; j<7; j++) {
                if(today == 6 || today == 7) { 
                    today ++;
                    if(today == 8) today = 1;
                    continue;
                }
                if(goal < timelogs[i][j]) isSuccess = false;
                
                today ++;
                if(today == 8) today = 1;
            }
            
            if(isSuccess) answer++;
        }
        return answer;
    }
}
