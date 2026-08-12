class Solution {
    public int[] solution(String[] park, String[] routes) {
        
        // 현재 로봇의 위치
        int[] position = new int[2];
        
        // 해당 명령이 공원을 벗어나거나, 장애물을 만단다면 해당 명령은 무시함
        int[][] arr = new int[park.length][park[0].length()];
        
        for(int i=0; i<park.length; i++) {
            String curr = park[i];
            
            for(int j=0; j<curr.length(); j++) {
                if(curr.charAt(j) == 'S') {
                    position[0] = i;
                    position[1] = j;
                    arr[i][j] = 0;
                } 
                else if(curr.charAt(j) == 'O') arr[i][j] = 0;
                else arr[i][j] = 1;
            }
        }
        
        for(int i=0; i<routes.length; i++) {
            String[] r = routes[i].split(" ");
            int num = Integer.parseInt(r[1]);  // 몇칸 움직일지
            int[] temp_position = { position[0], position[1] };
            
            boolean isAvailable = true;
            
            for(int j=0; j<num; j++) {
                switch(r[0]) {
                        case "E" -> temp_position[1]++;
                        case "W" -> temp_position[1]--;
                        case "S" -> temp_position[0]++;
                        case "N" -> temp_position[0]--;
                }
                
                // 공원 벗어나는지 검사
                if(temp_position[0] < 0 || temp_position[0] >= park.length ||
                  temp_position[1] < 0 || temp_position[1] >= park[0].length()) {
                    isAvailable = false;
                    break;
                }
                
                // 장애물 검사
                if(arr[temp_position[0]][temp_position[1]] == 1) {
                    isAvailable = false;
                    break;
                }
            }
            
            if(!isAvailable) continue;  // 가능하지 않다면 해당 명령은 무시한다
            
            position[0] = temp_position[0];
            position[1] = temp_position[1];
        }
        
        return position;
    }
}
