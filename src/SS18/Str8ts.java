package SS18;

import java.util.*;

public class Str8ts {

    private boolean[][] blk;
    private int[][] num;

    private static ArrayList<HashSet<Integer>> vert;
    private ArrayList<HashSet<Integer>> horz;


    public Str8ts(boolean[][] blk, int[][] num) {
        this.blk = blk;
        this.num = num;

        vert = new ArrayList<>();
        horz = new ArrayList<>();

        for (int i = 0; i < 9; i++) {
            vert.add(new HashSet<Integer>());
            horz.add(new HashSet<Integer>());
        }

        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if(num[row][col] != 0){
                    horz.get(row).add(num[row][col]);
                    vert.get(col).add(num[row][col]);
                }
            }
        }

        //

        // Find solution if possible
        solve(0, 0);




    }

    boolean isStr8tOrUnfinished(List<Integer> s){
        Collections.sort(s);

        if(!s.contains(0)){
            for(Integer i : s){
                if(!s.contains(i + 1) && !i.equals(s.get(s.size() - 1))){
                    return false;
                }
            }
        }
        return true;
    }

    boolean checkStr8t(int row, int col){
        List<Integer> sh = new ArrayList<>(), sv = new ArrayList<>();
        int c = col, r = row;

        // Search start of horizontal straight
        while(c >= 0 && !blk[row][c]){
            c--;
        }
        // collect values opf current horizontal straight in sh
        while(++c < 9 && !blk[row][c]){
            sh.add(num[row][c]);
        }

        // search start of vertical straight
        while(r >= 0 && !blk[r][col]){
            r--;
        }

        while(++r < 9 && !blk[r][col] ){
            sv.add(num[r][col]);
        }


        // check that both sh and sv straits or unfinished
        return isStr8tOrUnfinished(sv) && isStr8tOrUnfinished(sh);
    }

    boolean solve (int row, int col) {
        if(row >= 9) {
            return true; // solution found
        }
        else if(col >= 9){
            return solve(row + 1, 0);
        }
        else if(blk[row][col] || num[row][col] > 0){
            return solve(row, col + 1); // skip field
        }

        for(int v = 1; v <= 9; v++){
            if(!vert.get(col).contains(v) && !horz.get(row).contains(v)){
                // ... process current field
                num[row][col] = v;
                vert.get(col).add(v);
                horz.get(row).add(v);

                // check current straight and recur next field
                if(checkStr8t(row, col)){
                     if(solve(row, col + 1)){
                         return true;
                     }
                }

                // backtrack current field
                num[row][col] = 0;
                vert.get(col).remove(v);
                horz.get(row).remove(v);

            }

        }
        // no solution
        return false;
    }

    public static void main(String[] args) {
        int num[][] = {
                {0, 0, 0, 0, 5, 0, 0, 0, 0},
                {0, 6, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 8, 0, 0, 0, 0},
                {9, 0, 0, 4, 0, 0, 0, 0, 5},
                {0, 0, 0, 0, 0, 3, 0, 0, 0},
                {0, 0, 0, 0, 0, 9, 0, 4, 0},
                {4, 0, 3, 0, 0, 0, 0, 6, 0},
                {0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 8, 0, 0, 0, 0, 0, 2}

        };

        boolean blk[][] = {
                {true,true, false, false, false, false, false, true, true},
                {false, false, false, false, true, true, false, false, false},
                {false, false, false, true, true, false, false, false, false},
                {false, false, false, true, false, false, false, true, true},
                {true, false, false, false, false, false, false, false, true},
                {true, true, false, false, false, true, false, false, false},
                {false, false, false, false, true, true, false, false, false},
                {false, false, false, true, true, false, false, false, false},
                {true, true, false, false, false, false, false, true, true}
        };



        Str8ts straight = new Str8ts(blk, num);
        System.out.println(Arrays.deepToString(num));
    }


}
