package WS17.A6Backtracking;

public class Rohr {
    final double df;
    final Verteiler e, a;

    public Rohr(Verteiler ende, double durchfluss, Verteiler anderesEnde){
        this.e = ende;
        this.df = durchfluss;
        this.a  = anderesEnde;
        assert (df > 0 && e != null && a != null);
        ende.rohre.add(this);
    }


}
