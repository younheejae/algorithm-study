import java.util.*;

class Solution {
    public int solution(int[] mats, String[][] park) {
        
        Arrays.sort(mats);
        
        for(int k=mats.length-1; k>=0; k--) {
            int size = mats[k];
            
            for(int i=0; i+size <= park.length; i++) {
                for(int j=0; j+size <= park[i].length; j++) {

                    boolean possible = true;

                    // size x size 영역을 확인
                    // 해당 영역이 모두 -1이어야 함
                    for(int x=i; x<i+size; x++) {
                        for(int y=j; y<j+size; y++) {
                            if(!park[x][y].equals("-1")) {
                                possible = false;
                                break;
                            }
                        }
                        if(!possible) break;
                    }
                    
                    if(possible) return size;
                    
                }
            }
        }   
        return -1;
    }
}
