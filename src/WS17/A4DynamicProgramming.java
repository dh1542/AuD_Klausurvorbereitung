package WS17;

import java.util.Arrays;

public class A4DynamicProgramming {

    /**
     * Uses naive recursion to calculate the number of
     * ways a binary search tree with n nodes can be ordered
     * @param n
     * @return
     */
    private static long countNaive(int n){
        // base case
        if(n == 1 || n == 0){
            return 1;
        }

        long possibilities = 0;

        for(int i = 0; i < n; i++){
            possibilities += countNaive(i) * countNaive(n - 1 - i);
        }

        return possibilities;
    }


    /**
     * Uses recursion with memoization to solve
     * @param n
     * @return
     */
    private static long countDP(int n){
        long[] mem = new long[n + 1];
        Arrays.fill(mem, -1);
        mem[0] = 1;
        mem[1] = 1;
        return countDPH(mem, n);
    }

    private static long countDPH(long[] mem, int n){
        if(mem[n] != -1){
            return mem[n];
        }
        long possibilities = 0;


        for(int i = 0; i < n; i++){
            possibilities += countDPH(mem, i) * countDPH(mem, n - 1 - i);
        }
        mem[n] = possibilities;
        return possibilities;
    }

    private static long counterIter(int n){
        long[] mem = new long[n + 1];
        mem[0] = 1;
        mem[1] = 1;

        long possibilities = 0;
        for(int k = 2; k < n; k++){
            long mul1 = 0;
            for(int i = 0; i < k; i++){
                mul1 += mem[i] * mem[k - 1 - i];
            }


            possibilities += mem[k];
        }
        return possibilities;

    }

    public static void main(String args[]){
        System.out.println(countNaive(3));
        System.out.println(countDP(3));
        System.out.println(counterIter(3));
    }
}
