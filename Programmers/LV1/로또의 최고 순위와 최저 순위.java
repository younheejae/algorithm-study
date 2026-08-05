class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = { 6, 6 };
        
        int zero = 0;  // 0의 개수
        int same = 0;  // 당첨과 겹치는 개수
        
        for(int i=0; i<6; i++) {
            if(lottos[i] == 0) zero++;
            for(int j=0; j<6; j++) {
                if(lottos[i] == win_nums[j]) same++;
            }
        }
        
        int max = same + zero;
        int min = same;
                
        for(int i=2; i<=6; i++) {
            if(max == i) answer[0] = 7-i;
            if(min == i) answer[1] = 7-i;
        }
        
        return answer;
    }
}
