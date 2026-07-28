class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
//         int[][] map = new int[n][n];
        
//         for(int i=0; i<n; i++) {
//             int temp1 = arr1[i];
//             int temp2 = arr2[i];
            
//             for(int j=0; j<n; j++) {
//                 int num1 = temp1 % 2;  // 2로 나눈 나머지
//                 temp1 = temp1 / 2;
//                 int num2 = temp2 % 2;
//                 temp2 = temp2 /2 ;
                
//                 if(num1 == 1 || num2 == 1) {
//                     map[i][n-j-1] = 1;
//                 }
//             }
//         }
        
//         for(int i=0; i<n; i++) {
//             StringBuilder sb = new StringBuilder();
//             for(int j=0; j<n; j++) {
//                 if(map[i][j] == 1) {
//                     sb.append("#");
//                 } else {
//                     sb.append(" ");
//                 }
//             }
//             answer[i] = sb.toString();
//         }  
        
        
        for(int i=0; i<n; i++) {
            int result = arr1[i] | arr2[i];
            String temp = Integer.toBinaryString(result);
            
            temp = String.format("%" + n + "s", temp);
            
            temp = temp.replace("1", "#");
            temp = temp.replace("0", " ");
            
            answer[i] = temp;
        }
        return answer;
    }
}
