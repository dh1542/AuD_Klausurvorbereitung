package SS16;

public class A6DynamicProgramming {
    /**
     * Recursively calculates great Schroeder Numbers of n
     * @param n
     * @return
     */
    private static long a(int n){
        // base case
        if(n <= 1){
            return 1;
        }
        // recursion
        else{
            long an = a(n - 1);
            for(int i = 1; i < n; i++){
                an += a(i) * a(n - i);
            }
            return an;
        }
    }


    static long[] mem;

    /**
     * Calculates the nth Schroeder number with Dynamic Programming
     * Reference: <a href="https://oeis.org/A006318/list">List of Schroeder numbers</a>
     * @param n
     * @return
     */
    private static long aDP(int n){
        if(mem == null || mem.length < n){
            if(mem == null){
                mem = new long[n + 1];
            }
            else{
                long[] oldMem = mem;
                mem = new long[n + 1];
                for(int i = 0; i < oldMem.length; i++){
                    mem[i] = oldMem[i];
                }
            }
        }



        mem[0] = 1;

        for(int i = 1; i <= n; i++){

            long ithSchroederNumber = mem[i - 1];
            long sum = 0;
            for(int j = 1; j < i ; j++){
                sum += mem[j] * mem[i - j];
            }
            ithSchroederNumber += sum;
            mem[i] = ithSchroederNumber;
        }

        return mem[n];



    }


    public static void main(String args[]){
        long recursionSN = aDP(24);
        System.out.println(recursionSN);
    }
}
