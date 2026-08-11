import java.util.*;

class Solution {
    static int[] graph;

    public int solution(int n, int[][] costs) {
        Arrays.sort(costs, (a,b)->Integer.compare(a[2], b[2]));
        graph = new int[n];
        for (int i = 0; i < n; i++) {
            graph[i] = i;
        }
        int answer = 0;

        for (int[] cost : costs) {
            if(union(cost[0], cost[1])) {
                answer += cost[2];
            }
        }

        return answer;
    }

    public static int find(int x) {
        if (graph[x] != x) {
            graph[x] = find(graph[x]);
        }

        return graph[x];
    }

    public static boolean union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX != rootY) {
            graph[rootY] = rootX;
            return true;
        }

        return false;
    }
}