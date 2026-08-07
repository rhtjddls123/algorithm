import java.util.*;

class Solution {
    public String[] solution(String[] orders, int[] course) {
        List<String> list = new ArrayList<>();
        for (int i : course) {
            Map<String, Integer> map = new HashMap<>();
            for (String order : orders) {
                char[] charArray = order.toCharArray();
                Arrays.sort(charArray);
                combi(charArray, new boolean[order.length()], 0, i, map);
            }

            Collection<Integer> values = map.values();
            int max = 0;
            for (Integer value : values) {
                max = Math.max(max, value);
            }

            Set<Map.Entry<String, Integer>> entries = map.entrySet();
            for (Map.Entry<String, Integer> entry : entries) {
                if(entry.getValue()>=2 && entry.getValue()==max) {
                    list.add(entry.getKey());
                }
            }
        }
        String[] answer = list.toArray(new String[0]);
        Arrays.sort(answer);
        return answer;
    }
    
    public static void combi(char[] chars, boolean[] visited, int start, int n, Map<String, Integer> map) {
        if (n==0) {
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< visited.length; i++) {
                if (visited[i]) sb.append(chars[i]);
            }
            map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + 1);
            return;
        }

        if (chars.length - start < n) return;

        for(int i=start; i<chars.length; i++) {
            visited[i] = true;
            combi(chars, visited, i+1, n-1, map);
            visited[i] = false;
        }
    }
}