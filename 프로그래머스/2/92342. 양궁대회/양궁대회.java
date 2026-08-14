class Solution {
    int[] info;
    int s;
    int[] answer = {-1};

    public int[] solution(int n, int[] info) {
        this.info = info;
        s = 0;
        boolean[] visited = new boolean[11];
        int[] lion = new int[11];
        dfs(n, 0, lion, visited);
        return answer;
    }

    public void dfs(int n, int score, int[] lion, boolean[] visited) {
        for (int i = 0; i < 11; i++) {
            if (visited[i]) continue;
            if (n<=info[i]) continue;
            if (n==0) break;

            visited[i] = true;
            lion[i] = info[i]+1;
            dfs(n - (info[i]+1), score + 10 - i, lion, visited);
            visited[i] = false;
            lion[i] = 0;
        }

        if (n!=0) lion[10] += n;
        calc(info, lion);
        if (n!=0) lion[10] -= n;
    }

    public void calc(int[] info, int[] lion) {
        int a = 0;
        int l = 0;
        for (int i = 0; i < 11; i++) {
            if ((info[i]>0 || lion[i]>0) && info[i]<lion[i]) l += 10-i;
            else if (info[i]>0 && info[i]>=lion[i]) a += 10-i;
        }

        if(l>a && l-a>s) {
            s = l-a;
            answer = new int[11];
            for (int i = 0; i < 11; i++) {
                answer[i] = lion[i];
            }
        } else if(l>a && l-a == s) {
            for (int i = 10; i >=0 ; i--) {
                if (lion[i]>0 && lion[i] > answer[i]) {
                    for (int j=0; j<11; j++) {
                        answer[j] = lion[j];
                    }
                    break;
                }
            }
        }
    }
}