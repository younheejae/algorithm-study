class Solution {
    public String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();
        
        int leftH = 10;
        int rightH = 12;
                
        for(int i=0; i<numbers.length; i++) {
            // 왼쪽
            if(numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7) {
                sb.append('L');
                leftH = numbers[i];
            // 오른쪽
            } else if(numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9) {
                sb.append('R');
                rightH = numbers[i];
            } else {
                // 가운데라면 거리를 계산
                // 거리가 다르다면 더 짧은 거리의 손으로, 거리가 같다면 hand로
                int left_distance = dist(leftH, numbers[i]);
                int right_distance = dist(rightH, numbers[i]);
                
                if(left_distance < right_distance) {
                    sb.append('L');
                    leftH = numbers[i];
                } else if(left_distance > right_distance) {
                    sb.append('R');
                    rightH = numbers[i];
                } else {
                    if(hand.equals("left")) {
                        sb.append('L');
                        leftH = numbers[i];
                    } else {
                        sb.append('R');
                        rightH = numbers[i];
                    }
                }
            }
        }
        
        return sb.toString();
    }
    
    int dist(int from, int to) {
        if(from == 0) from = 11;
        if(to == 0) to = 11;
        
        int r1 = (from-1) / 3;
        int c1 = (from-1) % 3;
        
        int r2 = (to-1) / 3;
        int c2 = (to-1) % 3;
        
        return Math.abs(r1 - r2) + Math.abs(c1 - c2);
    }
}
