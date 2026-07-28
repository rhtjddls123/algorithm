import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer= 0;
        Deque<Integer> deque = new ArrayDeque<>();
        int h = board[0].length;
        
        for(int move : moves) {
            for(int i=0; i<h; i++) {
                if(board[i][move-1] == 0) continue;
                
                int d = board[i][move-1];
                board[i][move-1] = 0;
                if(!deque.isEmpty() && deque.peek() == d){
                    deque.pop();
                    answer += 2;
                    break;
                }
                deque.push(d);
                break;
            }
        }
        
        return answer;
    }
}