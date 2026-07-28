import java.util.*;

class Solution {
    public int solution(String s) {
        String[] strArr = s.split("");
        Deque<String> deque = new ArrayDeque<>();
        for(String str : strArr) {
            if(!deque.isEmpty() && str.equals(deque.peek())){
                deque.pop();
                continue;
            }
            deque.push(str);
        }
        
        return deque.size() == 0 ? 1 : 0;
    }
}