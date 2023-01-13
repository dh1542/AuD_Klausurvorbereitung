package WS18.A4Backtracking;

import java.util.LinkedList;
import java.util.List;

public class Chain {
    List<Cell> zs;
    int sum;


    boolean satisfiable(){
        int s = 0;
        boolean[] vs = new boolean[10];
        for(Cell c : zs){
            // cell value
            int value = c.v;
            if(value != 0 && vs[value]){
                return false;
            }
            vs[value] = true;
            s += value;
        }

        for(int i = 1; i < vs.length; i++){
            if(!vs[i]){
                return s < sum;
            }
        }

        return  s == sum;
    }


    boolean solve(LinkedList<Cell> cs){
        // base case: cs is empty
        if(cs.isEmpty()){

            return true;
        }

        // extract and process first cell:
        Cell z = cs.removeFirst();
        // try to assign 1 to 9 to its v and check all chains that z belongs to:

        for(z.v =  1; z.v <= 9; z.v++){


            boolean ok = true; // result of checking all its chains
            for(Chain c : z.ks){
                if(!c.satisfiable()){
                    ok = false;
                }
            }




            // if all chains are ok -> recurese on the rest of cs
            if(ok && solve(cs)){
                return true;
            }
        }
        // backtrack: reset its v and put back into cs:
        z.v = 0;
        cs.addFirst(z);

        return false;
    }



}
