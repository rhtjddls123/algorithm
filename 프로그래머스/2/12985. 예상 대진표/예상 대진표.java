class Solution {
    public int solution(int n, int a, int b){
        int A = a;
        int B = b;
        int answer = 0;
        while(true) {
            if (A==B) {
                break;
            }

            A = (int)Math.ceil((double) A/2);
            B = (int)Math.ceil((double) B/2);
            answer++;
        }
        return answer;
    }
}