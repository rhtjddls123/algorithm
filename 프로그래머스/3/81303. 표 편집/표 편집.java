import java.util.*;

class Solution {
    static class Node {
        public Integer prev;
        public int index;
        public boolean deleted = false;
        public Integer next;
        
        public Node(Integer prev, int index, Integer next) {
            this.prev = prev;
            this.index = index;
            this.next = next;
        }
        
        public String toString(){
            return "{ prev: %d, index: %d, deleted: %s, next: %d }".formatted(prev,index,deleted,next);
        }
        
        public String getSymbol(){
            return deleted?"X":"O";
        }
    }
    
    private static Node[] table;
    private static int cur;
    private static Deque<Node> stack = new ArrayDeque<>();
    
    public String solution(int n, int k, String[] cmd) {
        table = new Node[n];
        cur = k;
        
        for(int i=0; i<n; i++) {
            table[i] = new Node(i==0?null:i-1, i, i==n-1?null:i+1);
        }
        
        for(String c : cmd) {
            String[] split = c.split(" ");
            String o = split[0];
            
            if(o.equals("U") || o.equals("D")) {
                move(o, Integer.valueOf(split[1]));
            } else if(o.equals("C")) {
                remove();
            } else {
                undo();
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(Node node:table) {
            sb.append(node.getSymbol());
        }
        
        return sb.toString();
    }
    
    public void move(String dir, int c) {
        if(dir.equals("U"))
           for(int i=0; i<c; i++) {
               cur = table[table[cur].prev].index;
           }
        else if(dir.equals("D"))
           for(int i=0; i<c; i++) {
               cur = table[table[cur].next].index;
           }
    }
    
    public void remove() {
        Node removedNode = table[cur];
        removedNode.deleted = true;
        stack.push(removedNode);
        cur = removedNode.next == null ? table[removedNode.prev].index : table[removedNode.next].index;
        if(removedNode.prev != null) {
            table[removedNode.prev].next = removedNode.next;
        }
        if(removedNode.next != null) {
            table[removedNode.next].prev = removedNode.prev;
        }
        
    }
    
    public void undo() {
        Node reNode = stack.pop();
        reNode.deleted = false;
        if(reNode.prev != null)
            table[reNode.prev].next = reNode.index;
        if(reNode.next != null)
            table[reNode.next].prev = reNode.index;
    }
}