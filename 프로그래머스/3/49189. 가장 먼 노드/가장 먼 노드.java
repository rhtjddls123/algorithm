import java.util.*;

class Solution {

    List<Integer>[] graph;
    int n;

    public int solution(int n, int[][] edge) {
        this.n = n;
        graph = new List[n + 1];
        for (int i = 1; i < n + 1; i++) {
            graph[i] = new ArrayList();
        }

        for (int[] eg : edge) {
            int s = eg[0];
            int e = eg[1];

            graph[s].add(e);
            graph[e].add(s);
        }
        
        return bfs();
    }

    private int bfs() {
        int[] costs = new int[n + 1];
        Deque<Integer> queue = new ArrayDeque<>();
        queue.add(1);
        while (!queue.isEmpty()) {
            Integer node = queue.poll();
            int cost = costs[node];

            for (Integer n : graph[node]) {
                if (costs[n] == 0 && n != 1) {
                    costs[n] = cost + 1;
                    queue.offer(n);
                }
            }
        }

        int max = 0;
        int result = 0;

        for (int i = 2; i < n+1; i++) {
            if (costs[i] > max) {
                max = costs[i];
                result = 1;
                continue;
            }
            
            if (costs[i] == max) {
                result += 1;
            }
        }
        
        return result;
    }
}