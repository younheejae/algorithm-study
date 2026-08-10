class Solution {
    public int[] solution(String[] wallpaper) {
                
//         // x행 y열인 격자
//         int x = wallpaper.length;
//         int y = wallpaper[0].length(); 
        
//         int[][] arr = new int[x][y];
//         for(int i=0; i<x; i++) {
//             char[] wall = wallpaper[i].toCharArray();
//             for(int j=0; j<y; j++) {
//                 if(wall[j] == '.') arr[i][j] = 0;
//                 else arr[i][j] = 1;
//             }
//         }
        
//         int lux = -1, luy = -1, rdx = -1, rdy = -1;
//         // lux를 구함. 파일이 존재하는 가장 첫번째 행을 찾음
//         for(int i=0; i<x; i++) {
//             int count = 0;
//             for(int j=0; j<y; j++) {
//                 if(arr[i][j] == 1) count++;
//             }
//             if(count > 0) {
//                 lux = i;
//                 break;
//             }
//         }
//         // luy를 구함.
//         for(int i=0; i<y; i++) {
//             int count = 0;
//             for(int j=0; j<x; j++) {
//                 if(arr[j][i] == 1) count++;
//             }
//             if(count > 0) {
//                 luy = i;
//                 break;
//             }
//         }
//         // rdx를 구함.
//         for(int i=x-1; i>=0; i--) {
//             int count = 0;
//             for(int j=0; j<y; j++) {
//                 if(arr[i][j] == 1) count++;
//             }
//             if(count > 0) {
//                 rdx = i + 1;
//                 break;
//             }
//         }
//         // rdy를 구함.
//         for(int i=y-1; i>=0; i--) {
//             int count = 0;
//             for(int j=0; j<x; j++) {
//                 if(arr[j][i] == 1) count++;
//             }
//             if(count > 0) {
//                 rdy = i + 1;
//                 break;
//             }
//         }
//         int[] answer = { lux, luy, rdx, rdy };
        
        int lux = wallpaper.length;
        int luy = wallpaper[0].length();
        int rdx = 0, rdy = 0;
        
        for(int i=0; i<wallpaper.length; i++) {
            for(int j=0; j<wallpaper[i].length(); j++) {
                if(wallpaper[i].charAt(j) == '#') {
                    lux = Math.min(lux, i);
                    luy = Math.min(luy, j);
                    rdx = Math.max(rdx, i+1);
                    rdy = Math.max(rdy, j+1);
                }
            }
        }
        
        return new int[] { lux, luy, rdx, rdy };
    }
}
