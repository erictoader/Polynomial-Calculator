import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;

public class Polinom {
    private List<Monom> expresie;

    public Polinom() {
        this.expresie = new LinkedList<>();
    }

    public Polinom(Polinom p){
        this.expresie = new LinkedList<>();
        for(Monom m: p.expresie){
            this.adaugaTermen(m.getGrad(),m.getCoeficient());
        }
    }

    public List<Monom> getExpresie() {
        return expresie;
    }


    public void adaugaTermen(Integer grad, Double coeficient){
        Monom newMonom = new Monom(grad, coeficient);

        for(Monom m: expresie){
            if(newMonom.getGrad().equals(m.getGrad())){
                m.setCoeficient(m.getCoeficient() + newMonom.getCoeficient());
                return;
            }
        }

        expresie.add(newMonom);
    }

    public void stergeRedundant(){
        Predicate<Monom> filter = (Monom a) -> (a.getCoeficient().equals(0.0));
        expresie.removeIf(filter);
    }

    public static Polinom parsarePolinom(String polinomCitit){
        Polinom rezultat = new Polinom();

        String polinomFormatat = polinomCitit.replaceAll("-", "+-");
        polinomFormatat = polinomFormatat.replaceAll("\\s", "");
        polinomFormatat = polinomFormatat.replaceAll("\\*", "");
        polinomFormatat = polinomFormatat.replaceAll("X","x");

        String[] monoame = polinomFormatat.split("\\+");

        for(String s: monoame){
            if(s.isEmpty()){
                continue;
            }
            String[] monomID = s.split("x\\^");

            if(monomID.length > 1){
                if(monomID[0].isEmpty()){
                    rezultat.adaugaTermen(Integer.parseInt(monomID[1]), 1.0);
                }
                else
                {
                    rezultat.adaugaTermen(Integer.parseInt(monomID[1]), Double.parseDouble(monomID[0]));
                }
                continue;
            }

            if(!s.contains("x")){
                rezultat.adaugaTermen(0, Double.parseDouble(s));
            }
            else{
                String[] string = s.split("x");

                if(string.length == 0){
                    rezultat.adaugaTermen(1,1.0);
                }
                else{
                    rezultat.adaugaTermen(1, Double.parseDouble(string[0]));
                }
            }
        }

        rezultat.stergeRedundant();
        rezultat.expresie.sort(new SortByGrad());

        return rezultat;
    }

    @Override
    public String toString(){
        String print = "";
        for(Monom m: expresie){
            print = print + m;
        }
        return print;
    }
}