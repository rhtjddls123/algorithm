import java.util.Scanner;
import java.io.FileInputStream;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
        sc.nextLine();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int[] A = new int[a];

            for (int i = 0; i < a; i++) {
                A[i] = sc.nextInt();
            }

            int[] B = new int[b];

            for (int i = 0; i < b; i++) {
                B[i] = sc.nextInt();
            }

            if(A.length>B.length){
                int[] tmp = A;
                A = B;
                B = tmp;
            }

            int n = A.length;
            int maxValue = Integer.MIN_VALUE;

            for(int i=0; i<=B.length-n; i+=1){
                int tmp = 0;
                for(int j=0; j<n; j+=1){
                    tmp += A[j]*B[j+i];
                }
                if(maxValue<tmp) maxValue=tmp;
            }

            System.out.println("#"+test_case+" "+maxValue);
        }
    }
}