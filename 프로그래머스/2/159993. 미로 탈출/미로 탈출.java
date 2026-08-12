import java.util.*;

class Solution {
    
    int[][] mapArr;
    Map<String, Integer> mapping = new HashMap<>();

    public int solution(String[] maps) {
        mapping.put("X", 0);
        mapping.put("S", 1);
        mapping.put("O", 1);
        mapping.put("L", 2);
        mapping.put("E", 3);

        int n = maps.length;
        int m = maps[0].length();
        mapArr = new int[n][m];
        int[] start = new int[2];
        int[] lever = new int[2];
        int[] end = new int[2];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                String symbol = Character.toString(maps[i].charAt(j));
                if (symbol.equals("S")) {
                    start = new int[] {i, j};
                }
                if (symbol.equals("L")) {
                    lever = new int[] {i, j};
                }
                if (symbol.equals("E")) {
                    end = new int[] {i, j};
                }
                mapArr[i][j] = mapping.get(symbol);
            }
        }


        int toLever = bfs(start, lever);
        if (toLever == -1) return -1;
        int toEnd = bfs(lever, end);
        if (toEnd == -1) return -1;
        return toLever + toEnd;
    }

    public int bfs(int[] start, int[] end) {
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        int n = mapArr.length;
        int m = mapArr[0].length;
        int[][] visited = new int[n][m];

        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(start);
        visited[start[0]][start[1]] = 0;

        while (!queue.isEmpty()){
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];

            if (x==end[0] && y==end[1]) {
                return visited[x][y];
            }

            for (int[] dir : dirs) {
                int dx = x + dir[0];
                int dy = y + dir[1];

                if (dx>=0 && dx<n && dy>=0 && dy<m && visited[dx][dy]==0 && mapArr[dx][dy]!=0) {
                    visited[dx][dy] = visited[x][y]+1;
                    queue.offer(new int[] {dx, dy});
                }
            }
        }

        return -1;
    }
}