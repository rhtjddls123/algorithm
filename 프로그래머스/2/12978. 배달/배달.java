import java.util.*;

class Solution {
    public int solution(int N, int[][] road, int K) {
        Map<Integer, List<int[]>> map = new HashMap<>();
        for (int[] r : road) {
            if (!map.containsKey(r[0])) {
                map.put(r[0], new ArrayList<>());
            }
            map.get(r[0]).add(new int[] {r[1], r[2]});

            if (!map.containsKey(r[1])) {
                map.put(r[1], new ArrayList<>());
            }
            map.get(r[1]).add(new int[] {r[0], r[2]});
        }

        int[] costs = new int[N];
        Arrays.fill(costs, Integer.MAX_VALUE);
        costs[0] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[1], o2[1]));
        pq.offer(new int[] {1,0});
        boolean[] visited = new boolean[N];

        while (!pq.isEmpty()) {
            int[] q = pq.poll();
            int n = q[0];
            int cost = q[1];
            visited[n-1] = true;

            for (int[] ints : map.get(n)) {
                int nextN = ints[0];
                int nextCost = ints[1];

                if (!visited[nextN-1] && (cost + nextCost) < costs[nextN-1]) {
                    costs[nextN-1] = cost + nextCost;
                    pq.offer(new int[] {nextN, cost+nextCost});
                }
            }
        }
        int answer = 0;
        for (int cost : costs) {
            if (cost<=K) answer++;
        }
        return answer;
    }
}