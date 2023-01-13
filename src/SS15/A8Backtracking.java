package SS15;

import java.util.LinkedList;

public class A8Backtracking {
    boolean[][][][][] mem;
    int[][][] denkbar = {
            { { 2, 0}, { 1, 0}, { 1, 1}, {0, 1}, {0, 2} }, // b = 0
            { {-2, 0}, {-1, 0}, {-1, -1}, {0, -1}, {0, -2} } // b = 1
    };
    LinkedList<int[]> loese(int m, int k){
        mem = new boolean[m + 1][k + 1][2][m + 1][k + 1];
        return helfer(m, k, 0, 0, 0);
    }

    LinkedList<int[]> helfer(int mL, int kL, int b, int mR, int kR){
        LinkedList<int[]> erg = new LinkedList<>();

        if(mL < 0 || kL < 0 || mR < 0 || kR < 0){
            return null;
        }

        else if(mem[mL][kL][b][mR][kR]){
            return null;
        }

        else if(mL < kL || mR < kR){
            return null;
        }

        else if(mL == 0 && kL == 0 && b == 1){
            erg.add(new int[] {mL, kL, b, mR, kR});
            return erg;
        }
        else{
            erg.add(new int[] {mL, kL, b, mR, kR});


            LinkedList<int[]> result = null;
            for(int[] fahrt : denkbar[b]){
                mem[mL][kL][b][mR][kR] = true;


                LinkedList<int[]> list = helfer(mL - fahrt[0], kL - fahrt[1], (b + 1) % 2, mR + fahrt[0], kR + fahrt[1]);
                if(list != null) {
                    erg.addAll(list);
                    return erg;
                }
                mem[mL][kL][b][mR][kR] = false;
            }




        }
        return erg;
    }
}
