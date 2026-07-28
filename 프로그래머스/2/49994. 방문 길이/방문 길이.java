import java.util.*;

class Solution {
    public int solution(String dirs) {
        Set<String> s = new HashSet<>();
        Map<String, int[]> dir = new HashMap<>();
        dir.put("U", new int[] {-1,0});
        dir.put("D", new int[] {1,0});
        dir.put("L", new int[] {0,-1});
        dir.put("R", new int[] {0,1});
        int[] cur = {0,0};
        String[] directions = dirs.split("");
        
        for(String d : directions) {
            int x = cur[0];
            int y = cur[1];
            int dx = x + dir.get(d)[0];
            int dy = y + dir.get(d)[1];
            if(dx<-5 || dx>5 || dy<-5 || dy>5) continue;
            
            s.add(format(x,y,dx,dy));
            s.add(format(dx,dy,x,y));
            cur[0] = dx;
            cur[1] = dy;
        }
        
        return s.size()/2;
    }
    
    private static String format(int x, int y, int dx, int dy) {
        return "%d,%d - %d,%d".formatted(x,y,dx,dy);
    }
}