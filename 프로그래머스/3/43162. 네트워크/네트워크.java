import java.util.*;

class Solution {
    boolean[] visited;

    public int solution(int n, int[][] computers) {
        visited = new boolean[n];
        int answer = 0;

        for (int i = 0; i < n; i++) {
            if(!visited[i]) {
                dfs(i, computers);
                answer++;
            }
        }
        return answer;
    }

    public void dfs(int i, int[][] computers) {
        visited[i] = true;
        for (int j = 0; j < computers[i].length; j++) {
            if (computers[i][j]==1 && !visited[j]) {
                dfs(j, computers);
            }
        }
    }
}