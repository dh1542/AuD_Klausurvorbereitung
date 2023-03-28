package SS19;

public class A2DynamicProgrmamming {
    public static void main(String[] args) {
        System.out.println(gDP(9));
    }
    private static int g(int n){
        assert n >= 1;
        if(n <= 1) {
            return 1;
        }
        else {
            return 1 + g(n - g(g(n - 1)));
        }
    }

    private static int gMem(int n){
        assert n >= 1;
        return gMH(n, new int[n + 1]);
    }

    private static int gMH(int n, int[] m){
        assert n >= 1;
        if(n <= 1){
            m[n] = 1;
            return m[n];
        }

        if(m[n] != 0){
            return m[n];
        }

        m[n] = 1 + gMH(n - gMH(gMH(n - 1, m), m), m);
        return m[n];
    }

    private static int gDP(int n){
        assert n >= 1;
        int[] m = new int[n + 1];
        m[1] = 1;

        for(int k = 2; k <= n; k++){
            m[k] = 1 + m[k - m[m[k - 1]]];
        }
        return m[n];
    }
}
