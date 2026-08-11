import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        Set<String> set = new HashSet<>();
        String preS = words[0];
        set.add(preS);
        int player = 1;
        int[] answer = {0,0};
        for (int i = 1; i< words.length; i++){
            String curS = words[i];
            if(preS.charAt(preS.length()-1) != curS.charAt(0) || set.contains(curS)) {
                answer[0] = player+1;
                answer[1] = (i/n)+1;
                break;
            }
            player = (player+1) % n;
            set.add(curS);
            preS = curS;
        }

        return answer;
    }
}