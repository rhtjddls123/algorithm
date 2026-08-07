class Solution {
    
    private static int[] answer = new int[2];
    
    public int[] solution(int[][] arr) {
        calc(arr);
        return answer;
    }
    
    public static void calc(int[][] arr) {
        int symbol = arr[0][0];
        boolean isSame = true;
        for(int i=0; i<arr.length; i++) {
            for(int j=0; j<arr.length; j++) {
                if(arr[i][j] != symbol) {
                    isSame = false;
                    break;
                }
            }
        }

        if (isSame) {
            answer[symbol]++;
            return;
        }

        separate(arr);
    }

    public static void separate(int[][] arr) {
        int l = arr.length;
        int sIdx = l/2;
        int[][] newArr = new int[sIdx][sIdx];
        int x = 0;
        int y = 0;
        for(int i=0; i<sIdx; i++) {
            for(int j=0; j<sIdx; j++) {
                newArr[x][y++] = arr[i][j];
            }
            x++;
            y=0;
        }
        calc(newArr);

        x=0;
        y=0;
        for(int i=0; i<sIdx; i++) {
            for(int j=sIdx; j<l; j++) {
                newArr[x][y++] = arr[i][j];
            }
            x++;
            y=0;
        }
        calc(newArr);

        x=0;
        y=0;
        for(int i=sIdx; i<l; i++) {
            for(int j=0; j<sIdx; j++) {
                newArr[x][y++] = arr[i][j];
            }
            x++;
            y=0;
        }
        calc(newArr);

        x=0;
        y=0;
        for(int i=sIdx; i<l; i++) {
            for(int j=sIdx; j<l; j++) {
                newArr[x][y++] = arr[i][j];
            }
            x++;
            y=0;
        }
        calc(newArr);
    }
}