import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int size = progresses.length;
        int[] times = new int[size];
        for(int i=0; i<size; i++){
            times[i] = (int)Math.ceil((double)(100-progresses[i])/speeds[i]);
        }
        
        List<Integer> submit = new ArrayList<>();
        int first = times[0];
        int cnt = 1;
        for(int i=1; i<size; i++){
            if(times[i]<=first) cnt++;
            else {
                submit.add(cnt);
                first = times[i];
                cnt=1;
            }
        }
        submit.add(cnt);
        int[] answer = new int[submit.size()];
        
        for(int i=0; i<submit.size(); i++) {
            answer[i] = submit.get(i);
        }
        
        return answer;
    }
}