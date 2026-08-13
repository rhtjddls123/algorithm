class Solution {
    int[] arr;
    int answer;

    public int solution(int n) {
        arr = new int[n];
        answer = 0;

        dfs(0, new boolean[n]);

        return answer;
    }

    public void dfs(int k, boolean[] visited) {
        for (int i = 0; i < visited.length; i++) {
            if (visited[i]) continue;
            if (!check(k, i)) continue;

            visited[i] = true;
            arr[k] = i;
            dfs(k+1, visited);
            arr[k] = 0;
            visited[i] = false;
        }

        boolean success = true;
        for (boolean v : visited) {
            if (!v) success = false;
        }

        if(success) answer++;
    }

    public boolean check(int idx, int n) {
        for (int i = 1; i <= idx; i++) {
            if (n == arr[idx-i]) return false;
            if (n-i == arr[idx-i] || n+i == arr[idx-i]) return false;
        }

        return true;
    }
}