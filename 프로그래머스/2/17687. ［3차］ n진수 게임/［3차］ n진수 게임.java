import java.util.*;

class Solution {
    public String solution(int n, int t, int m, int p) {
        String[] str = new String[m];
        Arrays.fill(str, "");
        int num = 0;
        String radixNum = Integer.toString(num, n);
        int curP = 0;
        while (true) {
            for (int i=0; i<radixNum.length(); i++) {
                str[curP%m] += Character.toString(radixNum.charAt(i));
                if (str[p-1].length()==t) {
                    return str[p-1].toUpperCase();
                }
                curP++;
            }
            radixNum = Integer.toString(++num, n);
        }
    }
}