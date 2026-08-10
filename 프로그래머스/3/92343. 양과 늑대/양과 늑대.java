import java.util.*;

class Solution {
    int answer = 0;
    int[] info;

    List<List<Integer>> graph = new ArrayList<>();

    public int solution(int[] info, int[][] edges){
        this.info = info;
        int n = info.length;
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];

            graph.get(from).add(to);
        }

        dfs(1, 0, graph.getFirst());

        return answer;
    }

    void dfs(int sheep, int wolf, List<Integer> candidates) {
        answer = Math.max(answer, sheep);
        for (int i = 0; i < candidates.size(); i++) {
            int node = candidates.get(i);

            int nextSheep = sheep;
            int nextWolf = wolf;

            if(info[node]==1) {
                nextWolf++;
            } else {
                nextSheep++;
            }

            if (nextSheep<=nextWolf) {
                continue;
            }

            List<Integer> nextCandidates = new ArrayList<>(candidates);
            nextCandidates.remove(i);
            nextCandidates.addAll(graph.get(node));

            dfs(nextSheep, nextWolf, nextCandidates);
        }
    }
}