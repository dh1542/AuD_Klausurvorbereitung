package SS16.A7Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Tauziehen {
    private static List<Long> a, b, y, z;
    private static long abDiff, yzDiff;

    public static List<List<Long>> tauziehen(List<Long> in){
        a = new LinkedList<>(in);
        b = new LinkedList<>();
        y = null;
        z = null;

        abDiff = 0;
        yzDiff = 0;

        for(Long v : a){
                abDiff += v;
        }

        helfer(0);

        return Arrays.asList(y, z);
    }

    private static void helfer(int p){
        if(Math.abs(a.size() - b.size()) <= 1){
            if(y == null && z == null || Math.abs(abDiff) < Math.abs(yzDiff)){
                y = new LinkedList<>(a);
                z = new LinkedList<>(b);
                yzDiff = abDiff;
            }
        }
        else if(p < a.size()){
            // p-ter Wert bleibt in
            helfer(p + 1);

            // p-ter Wert von a nach b:

            abDiff -= 2 *  a.get(p);


            b.add(a.remove(p));

            helfer(p);

            // backtracking
            abDiff += 2 * b.get(b.size() - 1);


            a.add(p, b.remove(b.size() - 1));


        }

    }

    public static void main(String[] args) {
        long[] inArray = {23, 45, -34, 12, 0, 98, -99, 4, 189, -1, 4};
        List<Long> in = Arrays.stream(inArray).boxed().toList();

        System.out.println(tauziehen(in));

    }
}
