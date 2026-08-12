import java.util.*;

class Solution {
    static class Node {
        int x;
        int y;
        int cost;
        String dir;

        public Node(int x, int y, int cost, String dir) {
            this.x = x;
            this.y = y;
            this.cost = cost;
            this.dir = dir;
        }
    }

    static class Cost {
        int g;
        int s;

        public Cost(int g, int s) {
            this.g = g;
            this.s = s;
        }
    }

    public int solution(int[][] board) {
        int N = board.length;
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
        Node start = new Node(0, 0, 0, null);
        pq.offer(start);
        int[][] dirs = new int[][] {{0,1}, {0,-1}, {1,0}, {-1,0}};
        Cost[][] costs = new Cost[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                costs[i][j] = new Cost(Integer.MAX_VALUE,Integer.MAX_VALUE);
            }
        }
        costs[0][0].g = 0;
        costs[0][0].s = 0;

        while (!pq.isEmpty()) {
            Node q = pq.poll();
            int cost = q.cost;

            for (int[] dir : dirs) {
                int dx = q.x + dir[0];
                int dy = q.y + dir[1];

                String d;
                if (dx==q.x) {
                    d = "g";
                } else {
                    d = "s";
                }

                int nextCost = cost;
                if (q.dir != null && !q.dir.equals(d)) {
                    nextCost += 600;
                } else {
                    nextCost += 100;
                }

                if (dx<0 || dx>=N || dy<0 || dy>=N || board[dx][dy] == 1) continue;
                if ((d.equals("g")&&costs[dx][dy].g <= nextCost) || (d.equals("s")&&costs[dx][dy].s<=nextCost)) continue;

                if (d.equals("g")) costs[dx][dy].g = nextCost;
                else costs[dx][dy].s = nextCost;
                pq.offer(new Node(dx, dy, nextCost, d));
            }
        }

        return Math.min(costs[N-1][N-1].s, costs[N-1][N-1].g);
    }
}