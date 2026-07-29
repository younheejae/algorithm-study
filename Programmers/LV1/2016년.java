class Solution {
    public String solution(int a, int b) {
        
        int [] days = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        String[] arr = { "FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU" };
        
        // a월 b일이 주어졌을 때 1월1일 기준 얼마나 떨어져있는지 계산
        int total = 0;
        total += b - 1;

        for(int i=0; i<a - 1; i++) {
            total += days[i];
        }
        int num = total % 7; 
                
        return arr[num];
    }
}
