import java.util.*;

class Solution {
    int[] graph;
    
    public int solution(int n, int[][] costs) {
        graph = new int[n];
        
        for(int i=0; i<n; i++) {
            graph[i] = i;
        }
        
        Arrays.sort(costs, (o1, o2)->Integer.compare(o1[2], o2[2]));
        
        int answer = 0;
        for(int[] cost: costs) {
            int x = cost[0];
            int y = cost[1];
            int c = cost[2];
            
            if (union(x, y)) {
                answer += c;
            }
        }
        
        return answer;
    }
    
    private int find(int x) {
        if (graph[x] != x) {
            graph[x] = find(graph[x]);
        }
        return graph[x];
    }
    
    private boolean union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        
        if (rootX == rootY) return false;
        
        graph[rootY] = rootX;
        return true;
    }
}