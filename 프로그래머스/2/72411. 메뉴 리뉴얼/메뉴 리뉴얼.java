import java.util.*;

public class Solution {

    public String[] solution(String[] orders, int[] course) {
        List<String> list = new ArrayList<>();
        for (int i : course) {
            Map<String, Integer> map = new HashMap<>();
            for (String order : orders) {
                String[] split = order.split("");
                Arrays.sort(split);

                combi(map, split, new boolean[split.length], 0, split.length, i);
            }

            Collection<Integer> values = map.values();
            int max = 0;
            for (Integer value : values) {
                max = max < value ? value : max;
            }

            if(max >= 2) {
                for (Map.Entry<String, Integer> entry : map.entrySet()) {
                    if(entry.getValue() == max) {
                        list.add(entry.getKey());
                    }
                }
            }
        }
        
        String[] answer = new String[list.size()];
        int idx = 0;
        for (String s : list) {
            answer[idx++] = s;
        }
        Arrays.sort(answer);
        return answer;
    }

    public static void combi(Map<String, Integer> map, String[] order, boolean[] visited, int start, int n, int r) {
        if (r == 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                if (visited[i]) sb.append(order[i]);
            }
            String s = sb.toString();
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        for (int i = start; i < n; i++) {
            visited[i] = true;
            combi(map, order, visited, i + 1, n, r - 1);
            visited[i] = false;
        }
    }
}
