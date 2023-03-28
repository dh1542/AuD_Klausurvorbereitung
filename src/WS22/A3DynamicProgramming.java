package WS22;

import java.util.Arrays;

public class A3DynamicProgramming {
    public static void main(String[] args) {
        System.out.println(gDP(3));
    }
    private static long a(int i){
        if(i == 1){
            return 1;
        }
        return a(i - 1) + b(i - 1);
    }
    private static long b(int i){
        if(i == 1){
            return 1;
        }
        return a(i - 1);
    }

    private static long g(int i){
        return a(i) + b(i);
    }

    private static long aMem(int i, long[] a, long[] b){
        if(i <= 1){
            return 1;
        }
        else if(a[i] != 0){
            return a[i];
        }
        else{
            a[i] = aMem(i - 1, a, b) + bMem(i - 1, a, b);
            return a[i];
        }

    }

    private static long bMem(int i, long[] a, long[] b){
        if(i <= 1){
            return 1;
        }
        else if(b[i] != 0){
            return b[i];
        }
        else{
            b[i] = aMem(i - 1, a, b);
            return b[i];
        }

    }

    private static long gMem(int i){
        long[] a = new long[i + 1];
        long[] b = new long[i + 1];
        System.out.println(Arrays.toString(a));

        return aMem(i, a, b) + bMem(i, a, b);
    }

    private static long gDP(int i){
        long[] a = new long[i + 1];
        long[] b = new long[i + 1];
        a[1] = 1;
        b[1] = 1;

        for(int gi = 2; gi <= i; gi++){
            a[gi] = a[gi - 1] + b[gi - 1];
            b[gi] = a[gi - 1];
        }

        return a[i] + b[i];
    }



}
