package SS15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class A4Recursion {
    static <T> List<List<T>> potenzmenge(T[] s) {
        // bestimme Potenzmenge ab Index 0
        return helfer(s, 0);
    }
    static <T> List<List<T>> helfer(T[] s, int idx) {
        // Rueckgabe pms ist Potenzmenge von s ab Index idx
        List<List<T>> pms = new ArrayList<List<T>>();


        // base case
        if(idx >= s.length){
            pms.add(new ArrayList<T>());
        }
        // aktuelles kopfelement
        else{
            T kopf = s[idx];

            // potenzmenge der restliste bestimmen
            List<List<T>> potRest = helfer(s, idx + 1);

            // Ergebnisse zusammenfuehren
            for(List<T> ohneKopf : potRest){
                List<T> mitKopf = new ArrayList<>(ohneKopf); // *noch* ohne Kopf
                mitKopf.add(kopf);
                pms.add(ohneKopf);
                pms.add(mitKopf);



            }
        }

        return pms;
    }

    public static void main(String[] args) {
        System.out.println(helfer(new String[]{"A", "u", "D"}, 0));
    }
}
