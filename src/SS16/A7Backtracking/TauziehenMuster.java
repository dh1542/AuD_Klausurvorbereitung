package SS16.A7Backtracking;

import java.util.List;
import java.util.*;
public class TauziehenMuster {





        private static List<Long> a, b, y, z;

        private static long abDiff, yzDiff;

        public static List<List<Long>> tauziehen(List<Long> in) {
            a = new LinkedList<>(in); // erste Arbeitsliste (Kopie von in)
            b = new LinkedList<>(); // zweite Arbeitsliste (anfangs leer)
            y = null; // erste Ergebnisliste
            z = null; // zweite Ergebnisliste
            abDiff = 0; // Differenz der Summe der Werte in a bzw. b
            yzDiff = 0; // Differenz der Summe der Werte in y bzw. z
            for (Long v : a) {
                abDiff += v;
            }
            helfer(0);
            System.out.println("abDiff= " +abDiff + "  |  yzDiff= " +yzDiff);
            return Arrays.asList(y, z);
        }
        private static void helfer(int p) { // p durchlaeuft alle Positionen in a
            // Basisfall a und b (fast) gleich gross erreicht?
            if (Math.abs(a.size() - b.size()) <= 1) {
                if (y == null && z == null // erste Loesung benoetigt
                        // oder bessere Loesung gefunden
                        || (Math.abs(abDiff) < Math.abs(yzDiff))) {
                    // merke beste bisher gefundene Loesung:
                    y = new LinkedList<>(a); System.out.println(y.toString() +" : Sum="+getSum(y));
                    z = new LinkedList<>(b);System.out.println(z.toString()+" : Sum="+getSum(z));
                    System.out.println("abDiff= " +abDiff + "  |  yzDiff= " +yzDiff);System.out.println() ;
                    yzDiff = abDiff;
                }
            } else if (p < a.size()) { // kein Abbruch
                // Rekursion 1: p-ter Wert bleibt in a:
                helfer(p + 1);
                // Rekursion 2: p-ten Wert von a nach b verschieben:
                abDiff-=2*(a.get(p));
                b.add(a.remove(p));
                helfer(p);
                // Backtracking zur 2. Rekursion:
                abDiff+=2*b.get(b.size()- 1);
                a.add(p, b.remove(b.size() - 1));
            }
        }
        private static String getSum(List<Long> y2) {
            int res=0;
            for(Long e:y2)
                res +=e;
            return res+"";
        }

    public static void main(String[] args) {
        List<Long> in =new LinkedList<Long>(Arrays.asList(23L, 45L, -34L, 12L, 0L, 98L, -99L, 4L, 189L, -1L, 4L));
        List<Long> y = new LinkedList<Long>(Arrays.asList(45L, -34L, 12L, 98L, -1L));
        List<Long> z = new LinkedList<Long>(Arrays.asList(23L, 0L, -99L, 4L, 189L, 4L));

        System.out.println(tauziehen(in).toString());
    }
    }

