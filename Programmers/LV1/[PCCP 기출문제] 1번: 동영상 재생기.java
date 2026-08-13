class Solution {
    public String solution(String video_len, String pos, 
                           String op_start, String op_end, String[] commands) {
        
        int video = StringToIntTime(video_len);
        int curr = StringToIntTime(pos);
        int start = StringToIntTime(op_start);
        int end = StringToIntTime(op_end);
        
        if(curr >= start && curr <= end) curr = end;
        
        for(int i=0; i<commands.length; i++) {
            if(commands[i].equals("next")) {
                curr += 10;
                if(curr > video) curr = video;
            } else if(commands[i].equals("prev")) {
                curr -= 10;
                if(curr < 0) curr = 0;
            }
            
            if(curr >= start && curr <= end) curr = end;
        }
        
        int a = curr / 60;
        int b = curr % 60;
    
        String answer = String.format("%02d:%02d", a, b);       
        
        return answer;
    }
    
    int StringToIntTime(String stime) {
        String[] arr = stime.split(":");
        int time = Integer.parseInt(arr[0]) * 60 + Integer.parseInt(arr[1]);
        
        return time;
    }
}
