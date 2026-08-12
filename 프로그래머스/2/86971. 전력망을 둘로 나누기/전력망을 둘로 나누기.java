import java.util.*;

class Solution {
    Map<Integer, List<Integer>> map;

    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;

        for (int i = 0; i < wires.length; i++) {
            map = new HashMap<>();
            for (int k=0; k<n; k++) {
                map.put(k+1, new ArrayList<>());
            }

            int node = 0;

            for (int j=0; j<wires.length; j++) {
                if (i==j) node = i+1;
                if (i!=j) {
                    int[] wire = wires[j];
                    map.get(wire[0]).add(wire[1]);
                    map.get(wire[1]).add(wire[0]);
                }
            }

            answer = Math.min(answer, Math.abs(n - 2 * dfs(node)));
        }

        return answer;
    }

    public int dfs(int node) {
        Deque<Integer> stack = new ArrayDeque<>();
        boolean[] visited = new boolean[map.size()+1];
        stack.push(node);
        int cnt = 0;
        while(!stack.isEmpty()) {
            int n = stack.pop();
            cnt++;
            visited[n] = true;
            List<Integer> list = map.get(n);
            for (Integer i : list) {
                if (!visited[i]) stack.push(i);
            }
        }

        return cnt;
    }
}