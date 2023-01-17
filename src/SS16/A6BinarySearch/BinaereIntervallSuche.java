package SS16.A6BinarySearch;

public class BinaereIntervallSuche {
    Intervall sucheIntervall(Intervall[] is, int v) {
        int a = 0, m, e = is.length - 1; // Anfang, Mitte, Ende

        m = (a + e) / 2;
        while(e >= a){

            // found
            if(is[m].max >= v && is[m].min >= v){
                return is[m];
            }
            else if(is[m].max < v){
                a = m;
                m = (a + e) / 2;
            }

            // less
            else if(is[m].min > v){
                e = m;
                m = (a + e) / 2;
            }



        }
        return null;
    }
}
