import java.util.*;

class Solution {
    public int solution(String s) {
        int cnt = check(s) ? 1 : 0;
        
        for(int i=1; i<s.length(); i++) {
            s = s.substring(1) + s.charAt(0);
            if(check(s)) cnt++;
        }
        return cnt;
    }
    
    private static boolean check(String s) {
        Map<String, String> map = new HashMap<>();
        map.put( ")", "(" );
        map.put( "}", "{" );
        map.put( "]", "[" );
        
        Deque<String> deque = new ArrayDeque<>();
        List<String> keys = new ArrayList<>(map.keySet());
        List<String> values = new ArrayList<>(map.values());
        
        String[] sArr = s.split("");
        for(String str : sArr) {
            if(values.contains(str)) {
                deque.push(str);
                continue;
            }
            if(deque.size()==0) return false;
            String symbol = deque.pop();
            if (symbol.equals(map.get(str))) continue;
            return false;
        }
        return deque.size()==0;
    }
}