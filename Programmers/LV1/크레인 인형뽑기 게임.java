import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        // [1,5,3,5,1,2,1,4]
        // [[0,0,0,0,0],[0,0,1,0,3],[0,2,5,0,1],[4,2,4,4,2],[3,5,1,3,1]]	
        
        Stack<Integer> stack = new Stack<>();
        
        for(int i=0; i<moves.length; i++) {
            int idx = moves[i] - 1;
            for(int j=0; j < board.length; j++) {
                if(board[j][idx] != 0) {
                    stack.push(board[j][idx]);
                    board[j][idx] = 0;
                    
                    if(stack.size() > 1) {
                        if(stack.get(stack.size() - 1) == stack.get(stack.size() - 2)) {
                            answer += 2;
                            stack.pop();
                            stack.pop();
                        }
                    }
                    break;
                }
            }
        }        
        
        return answer;
    }
}
