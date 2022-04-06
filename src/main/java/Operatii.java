
public class Operatii {

    static public Polinom adunaPolinoame(Polinom p1, Polinom p2){
        Polinom rezultat = new Polinom();

        for(Monom m1 : p1.getExpresie()){
            boolean found = false;
            for(Monom m2 : p2.getExpresie()){
                if(m1.getGrad().equals(m2.getGrad())){
                    rezultat.adaugaTermen(m1.getGrad(),m1.getCoeficient() + m2.getCoeficient());
                    found = true;
                    break;
                }
            }
            if(!found){
                rezultat.adaugaTermen(m1.getGrad(), m1.getCoeficient());
            }
        }

        for(Monom m1 : p2.getExpresie()){
            boolean found = false;
            for(Monom m2 : rezultat.getExpresie()){
                if(m1.getGrad().equals(m2.getGrad())){
                    found = true;
                    break;
                }
            }
            if(!found){
                rezultat.adaugaTermen(m1.getGrad(), m1.getCoeficient());
            }
        }

        rezultat.stergeRedundant();
        rezultat.getExpresie().sort(new SortByGrad());

        return rezultat;
    }

    static public Polinom scadePolinoame(Polinom p1, Polinom p2){
        Polinom rezultat = new Polinom();

        for(Monom m1 : p1.getExpresie()){
            boolean found = false;
            for(Monom m2 : p2.getExpresie()){
                if(m1.getGrad().equals(m2.getGrad())){
                    rezultat.adaugaTermen(m1.getGrad(),m1.getCoeficient() - m2.getCoeficient());
                    found = true;
                    break;
                }
            }
            if(!found){
                rezultat.adaugaTermen(m1.getGrad(), m1.getCoeficient());
            }
        }

        for(Monom m1 : p2.getExpresie()){
            boolean found = false;
            for(Monom m2 : rezultat.getExpresie()){
                if(m1.getGrad().equals(m2.getGrad())){
                    found = true;
                    break;
                }
            }
            if(!found){
                rezultat.adaugaTermen(m1.getGrad(), 0 - m1.getCoeficient());
            }
        }

        rezultat.stergeRedundant();
        rezultat.getExpresie().sort(new SortByGrad());

        return rezultat;
    }

    static public Polinom deriveazaPolinom(Polinom p){
        Polinom rezultat = new Polinom();

        for(Monom m: p.getExpresie()){
            if(!m.getGrad().equals(0)) {
                rezultat.adaugaTermen(m.getGrad() - 1, m.getCoeficient() * m.getGrad());
            }
        }

        return rezultat;
    }

    static public Polinom integreazaPolinom(Polinom p){
        Polinom rezultat = new Polinom();

        for(Monom m: p.getExpresie()){
            rezultat.adaugaTermen(m.getGrad() +1, m.getCoeficient() / (m.getGrad() + 1));
        }

        return rezultat;
    }

    public static Polinom inmultirePolinoame(Polinom p1, Polinom p2){
        Polinom rezultat = new Polinom();

        for(Monom m1: p1.getExpresie()){
            for(Monom m2: p2.getExpresie()){
                rezultat.adaugaTermen(m1.getGrad() + m2.getGrad(), m1.getCoeficient() * m2.getCoeficient());
            }
        }

        rezultat.stergeRedundant();
        rezultat.getExpresie().sort(new SortByGrad());

        return rezultat;
    }

    public static RezultatImpartire impartirePolinoame(Polinom p1, Polinom p2){
        Polinom quotient = new Polinom();

        if(p1.getExpresie().size() == 1 && p2.getExpresie().size() == 1){
            Monom res = p1.getExpresie().get(0).divideMonom(p2.getExpresie().get(0));
            quotient.adaugaTermen(res.getGrad(), res.getCoeficient());
            RezultatImpartire rezultat = new RezultatImpartire(quotient, null);
            return rezultat;
        }

        Polinom d = new Polinom(p1);
        Polinom i = new Polinom(p2);

        while(d.getExpresie().get(0).getGrad() >= i.getExpresie().get(0).getGrad()){
            Monom md = d.getExpresie().get(0);
            Monom mi = i.getExpresie().get(0);
            Monom mc = md.divideMonom(mi);

            quotient.adaugaTermen(mc.getGrad(),mc.getCoeficient());

            Polinom mcPolinom = new Polinom();
            mcPolinom.adaugaTermen(mc.getGrad(), mc.getCoeficient());
            Polinom aux = Operatii.inmultirePolinoame(i, mcPolinom);
            d = Operatii.scadePolinoame(d, aux);
        }

        quotient.stergeRedundant();
        quotient.getExpresie().sort(new SortByGrad());

        RezultatImpartire rezultat = new RezultatImpartire(quotient, d);
        return rezultat;
    }

}
