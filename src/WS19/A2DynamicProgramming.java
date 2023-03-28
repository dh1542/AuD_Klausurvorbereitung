package WS19;

public class A2DynamicProgramming {
    public static void main(String[] args) {
        int[][] a = {{1, 3, 1, 5}, {2, 2, 4, 1}, {5, 0, 2, 3}, {0, 6, 1, 2}};
        System.out.println(maxPathR(a));
    }


    private static int maxPathR(int[][] a){
        int best = 0;
        for(int row = 0; row < a.length; row++){
            best = Math.max(best, recurse(a, row, 0));
        }
        return best;
    }

    private static int recurse(int[][] a, int row, int col){
        int n = a.length;
        int best = 0;
        assert row >= 0 && row < n && col >= 0 && col < n;


        recurse(a, row + 1, col + 1);


        return best;
    }
}
