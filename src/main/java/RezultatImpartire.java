public class RezultatImpartire {
    private Polinom polinomCat;
    private Polinom polinomRest;

    public RezultatImpartire(Polinom polinomCat, Polinom polinomRest) {
        this.polinomCat = polinomCat;
        this.polinomRest = polinomRest;
    }

    public Polinom getPolinomCat() {
        return polinomCat;
    }

    public Polinom getPolinomRest() {
        return polinomRest;
    }
}
