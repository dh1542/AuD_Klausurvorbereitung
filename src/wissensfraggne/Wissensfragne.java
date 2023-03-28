package wissensfraggne;

public class Wissensfragne {
    public static void main(String[] args) {
        sterneSehen(10, 5);
    }

    static void sterneSehen(int x, int y){
        int sterne = 0;
        for(int a = 0; a < x; a++){
            for(int b = 0; b <= y; b++){
                sterne++;
            }
        }
        System.out.println(sterne);
    }
}



