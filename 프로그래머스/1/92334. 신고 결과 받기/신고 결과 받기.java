import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        
        Map<String, Integer> idIdx = new HashMap<>();
        for(int i=0; i<id_list.length; i++) {
            idIdx.put(id_list[i], i);
        }
        
        Map<String,Report> reportInfo = new HashMap<>();
        for(String r: report) {
            String[] split = r.split(" ");
            String from = split[0];
            String target = split[1];
            
            if(reportInfo.containsKey(target) && 
              !reportInfo.get(target).users.contains(from)
              ) {
                reportInfo.get(target).users.add(from);
                reportInfo.get(target).k++;
            } else if(reportInfo.containsKey(target) &&
                     reportInfo.get(target).users.contains(from)) {
                continue;
            } else {
                reportInfo.put(target, new Report(from));
            }
        }
        
        int[] answer = new int[id_list.length];
        for(int i=0; i<id_list.length; i++) {
            Report re = reportInfo.get(id_list[i]);
            if(re==null || re.k < k) continue;
            
            for(String user:re.users) {
                answer[idIdx.get(user)]++;
            }
        }
        
        
        return answer;
    }
    
    public static class Report {
        public List<String> users = new ArrayList<>();
        public int k = 0;
        
        public Report(String user) {
            users.add(user);
            k++;
        }
        
        public String toString() {
            return "users: "+users.toString()+", k: "+k;
        }
    }
}