import java.util.*;

class Solution {
    int[] nodes;

    public int solution(int n, int[][] computers) {
        nodes = new int[n];

        for (int i = 0; i < n; i++) {
            nodes[i] = i;
        }

        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j=0; j < n; j++) {
                if (computers[i][j] == 1) {
                    list.add(new int[]{i, j});
                }
            }
        }

        for (int[] ints : list) {
            union(ints[0], ints[1]);
        }
        
        Set<Integer> set = new HashSet<>();
        for (int node : nodes) {
            set.add(find(node));
        }

        int answer = set.size();
        return answer;
    }

    public int find(int x) {
        if (nodes[x] != x) {
            nodes[x] = find(nodes[x]);
        }
        return nodes[x];
    }

    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if(rootX!=rootY) {
            nodes[rootY] = rootX;
        }
    }
}