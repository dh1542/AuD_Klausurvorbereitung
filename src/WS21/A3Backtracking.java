package WS21;

public class A3Backtracking {
    private static boolean checkCol(char[][] in, int col){
        int os = 0, xs = 0, b = 0;

        for(int i = 0; i < in.length; i++){
            if(in[i][col] == 'o'){
                os++;
                xs = 0;
                b++;
            }
            if(in[i][col] == 'x'){
                xs++;
                os = 0;
                b--;
            }
            if(os > 2 || xs > 2){
                return false;
            }
        }
        if(b != 0){
            return false;
        }
        return true;
    }

    boolean solve(char[][] in) {
        return helper(in, 0, 0);
    }

    private static boolean helper(char[][] in, int r, int c){
        if(in[r][c] != ' '){
            boolean isSolved = true;
            for(int i = 0; i < in[r].length; i++){
                isSolved = checkCol(in, i);
                if(!isSolved) return false;
            }
            return true;
        }
       return false;
    }

}
