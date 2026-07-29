import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        Map<String, String> user = new HashMap<>();
        for(String r : record) {
            String[] split = r.split(" ");
            String oper = split[0];
            if(oper.equals("Leave")) continue;
            
            String id = split[1];
            String name = split[2];
            
            user.put(id, name);
        }
        
        List<String> list = new ArrayList<>();
        
        for(String r : record) {
            String[] split = r.split(" ");
            String oper = split[0];
            String id = split[1];
            
            if(oper.equals("Enter")) {
                list.add(user.get(id)+"님이 들어왔습니다.");
            } else if(oper.equals("Leave")) {
                list.add(user.get(id)+"님이 나갔습니다.");
            }
        }
        String[] answer = new String[list.size()];
        for(int i=0; i<list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}