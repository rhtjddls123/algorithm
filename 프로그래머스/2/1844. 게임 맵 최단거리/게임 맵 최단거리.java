import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int[] cur = {0,0};
        int n = maps.length;
        int m = maps[0].length;

        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        Queue<int[]> queue = new ArrayDeque<>();
        int[][] visited = new int[n][m];

        for(int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                visited[i][j] = -1;
            }
        }

        queue.offer(cur);
        visited[cur[0]][cur[1]] = 1;

        while(!queue.isEmpty()) {
            cur = queue.poll();
            int x = cur[0];
            int y = cur[1];

            for (int[] dir : dirs) {
                int dx = x + dir[0];
                int dy = y + dir[1];

                if (dx>=0 && dx<n && dy>=0 && dy<m && visited[dx][dy]==-1 && maps[dx][dy] == 1) {
                    queue.offer(new int[] {dx, dy});
                    visited[dx][dy] = visited[x][y]+1;
                }
            }
        }
        int answer = visited[n-1][m-1];
        return answer;
    }
}