import java.util.*;

class Solution {
    
    List<List<Integer>> answer = new ArrayList<>();

    public int[][] solution(int[][] nodeinfo) {
        int n = nodeinfo.length;
        answer.add(new ArrayList<>());
        answer.add(new ArrayList<>());
        int [][] info = new int[n][3];
        for(int i=0; i<n; i++) {
            int x = nodeinfo[i][0];
            int y = nodeinfo[i][1];
            int idx = i+1;
            info[i][0] = x;
            info[i][1] = y;
            info[i][2] = idx;
        }
        Arrays.sort(info, (a, b)->{
            if(b[1]==a[1]) {
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(b[1], a[1]);
        });

        Node root = new Node(null, info[0][0], info[0][2], null);

        for (int i = 1; i < n; i++) {
            int x = info[i][0];
            int y = info[i][1];
            int idx = info[i][2];

            Node cur = root;
            Node newNode = new Node(null, x, idx, null);
            while (true) {
                if (cur.value > x) {
                    // 왼쪽
                    if (cur.left == null) {
                        cur.left = newNode;
                        break;
                    }
                    cur = cur.left;
                } else {
                    // 오른쪽
                    if(cur.right == null) {
                        cur.right = newNode;
                        break;
                    }
                    cur = cur.right;
                }
            }
        }
        preorder(root);
        postorder(root);
        int[][] result = new int[2][n];

        for (int i = 0; i < n; i++) {
            result[0][i] = answer.getFirst().get(i);
        }

        for (int i = 0; i < n; i++) {
            result[1][i] = answer.get(1).get(i);
        }
        return result;
    }

    public void preorder(Node node) {
        if (node == null) return;
        answer.getFirst().add(node.idx);
        preorder(node.left);
        preorder(node.right);
    }

    public void postorder(Node node) {
        if (node == null) return;
        postorder(node.left);
        postorder(node.right);
        answer.get(1).add(node.idx);
    }

    public static class Node {
        Node left;
        int value;
        int idx;
        Node right;

        public Node(Node left, int value, int idx, Node right) {
            this.left = left;
            this.value = value;
            this.idx = idx;
            this.right = right;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "left=" + left +
                    ", value=" + value +
                    ", idx=" + idx +
                    ", right=" + right +
                    '}';
        }
    }
}