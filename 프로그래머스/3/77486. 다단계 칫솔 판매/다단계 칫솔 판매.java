import java.util.*;

class Solution {
    public static class Seller {
        String name;
        int money;

        public Seller(String name, int money) {
            this.name = name;
            this.money = money;
        }

        @Override
        public String toString() {
            return "Seller{" +
                    "name='" + name + '\'' +
                    ", money=" + money +
                    '}';
        }
    }

    private Map<String, Seller> sellers = new HashMap<>();

    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount){
        init(enroll, referral);

        for (int i = 0; i < seller.length; i++) {
            String me = seller[i];
            int money = amount[i] * 100;

            while(sellers.containsKey(me)) {
                String parent = sellers.get(me).name;
                int parentMoney = calc(money);
                int myMoney = money - parentMoney;
                sellers.get(me).money += myMoney;

                me = parent;
                money = parentMoney;
                if(money == 0) break;
            }
        }

        int[] answer = new int[enroll.length];
        for (int i = 0; i < enroll.length; i++) {
            answer[i] = sellers.get(enroll[i]).money;
        }

        return answer;
    }

    public void init(String[] enroll, String[] referral) {
        for (int i = 0; i < enroll.length; i++) {
            sellers.put(enroll[i], new Seller(referral[i], 0));
        }
    }

    public int calc(int price) {
        // 10%를 계산
        return (int)(price*0.1);
    }
}