import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        Deque<PriceTime> deque = new ArrayDeque<>();
        for(int i=0; i<prices.length; i++){
            PriceTime pt = new PriceTime(i+1, prices[i]);
            while(!deque.isEmpty()) {
                PriceTime peek = deque.peek();
                if(peek.getPrice()<=prices[i]) break;
                PriceTime ppt = deque.pop();
                answer[ppt.getTime()-1] = i+1 - ppt.getTime();
            }
            deque.push(pt);
        }
        
        while(!deque.isEmpty()) {
            PriceTime pt = deque.pop();
            answer[pt.getTime()-1] = prices.length - pt.getTime();
        }
        
        return answer;
    }
    
    class PriceTime {
        private int time;
        private int price;
        
        public PriceTime(int time, int price) {
            this.time = time;
            this.price = price;
        }
        
        public int getTime() {
            return time;
        }
        
        public int getPrice() {
            return price;
        }
        
        @Override
        public String toString() {
            return "price: "+price+" & time: "+time;
        }
    }
}