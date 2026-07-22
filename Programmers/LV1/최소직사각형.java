class Solution {
    public int solution(int[][] sizes) {
        
        // 큰 애들 중 가장 큰 값
        // 작은 애들 중 가장 큰 값
        int maxWidth = 0;
        int maxHeight = 0;
        
        for(int i=0; i<sizes.length; i++) {
            int width = Math.max(sizes[i][0], sizes[i][1]);
            int height = Math.min(sizes[i][0], sizes[i][1]);
            
            if(width > maxWidth) maxWidth = width;
            if(height > maxHeight) maxHeight = height;
        }
        
        return maxWidth * maxHeight;
    }
}
