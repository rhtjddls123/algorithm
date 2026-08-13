class Solution {
    int answer;

    public int solution(int k, int[][] dungeons) {
        answer = 0;
        dfs(k, new boolean[dungeons.length], dungeons, 0);
        return answer;
    }

    public void dfs(int hp, boolean[] visited, int[][] dungeons, int cnt) {
        answer = Math.max(answer, cnt);
        for (int i = 0; i < dungeons.length; i++) {
            if (visited[i]) continue;
            if (hp < dungeons[i][0]) continue;

            visited[i] = true;
            dfs(hp - dungeons[i][1], visited, dungeons, cnt + 1);
            visited[i] = false;
        }
    }
}