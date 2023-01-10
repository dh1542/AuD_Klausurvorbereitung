package WS21;

import java.util.Arrays;

public class A2DynamicProgrammingMemoization {
    public static void main(String[] args) {
        System.out.println(dp(7, 7));
    }
    // entringer number
    static long naive(int n, int k){
        if(n == 0 && k == 0){
            return 1;
        }
        else if(n > 0 && k == 0){
            return 0;
        }
        else{
            return naive(n, k - 1) + naive(n - 1, n - k);
        }
    }


    // MEMOIZATION
    static long mem(int n, int k){
        long[][] mem = new long[n + 2][k + 2];

        return mH(mem, n, k);
    }

    static long mH(long[][] mem, int n, int k){
        if(n == 0 && k == 0){
            mem[n][k] = 1;
        }
        else if(n > 0 && k == 0){
            mem[n][k] = 0;
        }
        else{
            mem[n][k] = mH(mem, n, k - 1) + mH(mem, n - 1, n - k);
        }
        return mem[n][k];
    }


    // DYNAMIC PROGRAMMING
    static long dp(int n, int k){
        long[][] dp = new long[n + 1][n + 1];


        // initial values

        for(int i = 0; i < k; i++){
            dp[0][k] = 1;
        }
        System.out.println(Arrays.deepToString(dp));

        for(int i = 1; i < n; i++){
            dp[i][0] = 0;
        }



        for(int i = n; i > 1; i--){
            for(int j = 1; j < k; j++){
                dp[i][j] = dp[i][j - 1] + dp[i - 1][i - j];
                System.out.println(Arrays.deepToString(dp));
            }
        }

        return dp[n][k];


    }

}
