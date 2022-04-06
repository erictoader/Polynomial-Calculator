public class Monom {
    private Integer grad;
    private Double coeficient;

    public Monom(Integer grad, Double coeficient) {
        this.grad = grad;
        this.coeficient = coeficient;
    }

    public Integer getGrad() {
        return grad;
    }

    public void setGrad(Integer grad) {
        this.grad = grad;
    }

    public Double getCoeficient() {
        return coeficient;
    }

    public void setCoeficient(Double coeficient) {
        this.coeficient = coeficient;
    }

    public Monom divideMonom(Monom mi){
        Monom res = new Monom((Integer)this.grad - mi.grad, (Double)this.coeficient/mi.coeficient);
        return res;
    }


    @Override
    public String toString() {
        return ((coeficient > 0?
                (coeficient == 1? (grad == 0? " + 1 " : " + ") :
                        (coeficient.intValue() == coeficient? " + " + coeficient.intValue() :
                                " + " + (double)Math.round(coeficient * 100d) / 100d)) :
                ((coeficient == -1? (grad == 0? " - 1 " : " - ") :
                        coeficient.intValue() == coeficient? " - " + (-1 * coeficient.intValue()) :
                                " - " + (-1 * (double)Math.round(coeficient * 100d) / 100d)))) +
                        (grad == 1? "x" :
                                (grad == 0? "" : "x^" + grad)));
    }

}