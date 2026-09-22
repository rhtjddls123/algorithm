import java.util.*;

class Solution {

    int n, s, a, b;
    Map<Integer, List<int[]>> graph;

    public int solution(int n, int s, int a, int b, int[][] fares) {
        this.n = n;
        this.s = s;
        this.a = a;
        this.b = b;
        graph = new HashMap<>();

        for (int[] fare : fares) {
            int start = fare[0];
            int end = fare[1];
            int cost = fare[2];

            if (!graph.containsKey(start)) graph.put(start, new ArrayList<>());
            if (!graph.containsKey(end)) graph.put(end, new ArrayList<>());
            graph.get(start).add(new int[] {end, cost});
            graph.get(end).add(new int[] {start, cost});
        }

        int[] sCosts = dijkstra(s);
        int[] aCosts = dijkstra(a);
        int[] bCosts = dijkstra(b);

        int answer = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            answer = Math.min(answer, sCosts[i]+aCosts[i]+bCosts[i]);
        }

        return answer;
    }

    private int[] dijkstra(int start) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[1], o2[1]));
        int[] costs = new int[n];
        for (int i = 0; i < n; i++) {
            costs[i] = Integer.MAX_VALUE;
        }
        costs[start-1] = 0;
        pq.offer(new int[] {start, 0});

        while(!pq.isEmpty()) {
            int[] poll = pq.poll();
            int cur = poll[0];
            int cost = poll[1];

            for (int[] ints : graph.get(cur)) {
                int nxt = ints[0];
                int nxtCost = ints[1];
                int calCost = nxtCost + cost;

                if (costs[nxt-1] > calCost) {
                    costs[nxt-1] = calCost;
                    pq.offer(new int[] {nxt, calCost});
                }
            }
        }

        return costs;
    }
}