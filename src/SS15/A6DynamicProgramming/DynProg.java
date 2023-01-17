package SS15.A6DynamicProgramming;

import java.util.Arrays;

public class DynProg {
    // a: verschachtelte Rekursion
    int [] mem;
    public DynProg(int max){
        mem = new int[max + 1];
        Arrays.fill(mem, -1);
        mem[1] = 1;
        mem[2] = 1;
    }

    // c:
    int fDP(int n) {
        int fn = 1; // Basisfall n < 3 trivial

        // fn schonmal berechnet
        if(mem[n] != -1){
            return mem[n];
        }
        else if(n >= 3){

                for(int i = 3; i < mem.length; i++){
                    mem[i] = (mem[i - 2 * mem[i - mem[i - 1]]]) + 1;
                }




            fn = mem[n];
        }

        return fn;


    }

    public static void main(String[] args) {
        DynProg n = new DynProg(1233234412);
        System.out.println(n.fDP(243324344));
    }


}
