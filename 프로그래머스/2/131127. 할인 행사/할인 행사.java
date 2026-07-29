import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int cnt = 0;
        
        for(int i=0; i<discount.length-9; i++) {
            Map<String, Integer> map = new HashMap<>();
            for(int j=0; j<want.length; j++) {
                map.put(want[j], number[j]);
            }
            
            String[] d = Arrays.copyOfRange(discount, i, i+10);
            for(String p:d) {
                if (map.containsKey(p)) map.put(p, map.get(p)-1);
            }
            
            boolean flag = true;
            for(String k:map.keySet()){
                if(map.get(k)!=0) flag=false;
            }
            if(flag) cnt++;
        }
        
        return cnt;
    }
}