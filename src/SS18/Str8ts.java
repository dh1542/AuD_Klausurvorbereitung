package SS18;

import java.util.ArrayList;
import java.util.HashSet;

public class Str8ts {

    private boolean[][] blk;
    private int[][] num;

    private ArrayList<HashSet<Integer>> vert, horz;


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
                // TODO: A1
            }
        }

        // Find solution if possible
        // solve(0, 0);


    }
}
