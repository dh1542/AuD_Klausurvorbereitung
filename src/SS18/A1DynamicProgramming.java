package SS18;

import java.util.Arrays;

public class A1DynamicProgramming {

    /**
     * Recursion with Memoization
     * @param n
     * @return
     */
    public static long aDP(int n){
        long[] a = new long[n + 1];
        long[] b = new long[n + 1];
        Arrays.fill(a, - 1);
        Arrays.fill(b, -1 );

        return aDP(n, a, b);
    }

    public static long aDP(int n, long[] a, long[] b){
        if(n == 0){
            return 1;
        }
        if(n == 1){
            return 0;
        }

        if(a[n] == -1){
            a[n] = aDP(n - 2, a, b) + 2 * bDP(n - 1, a, b);
        }
        return a[n];
    }

    public static long bDP(int n, long[] a, long[] b){
        if(n ==0) return 0;
        if(n ==1) return 1;
        if(b[n] == -1){
            b[n] = bDP(n - 2, a, b) + aDP(n - 1, a, b);
        }

        return b[n];
    }

    public static void main(String args[]){
        System.out.println(aDP(54));
    }

}


