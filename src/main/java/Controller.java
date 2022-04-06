import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {

    private final View v;

    public Controller(View v){
        this.v = v;

        v.addPolinomField1(new PolinomFieldListener1());
        v.addPolinomField2(new PolinomFieldListener2());
        v.addAdditionListener(new AdditionListener());
        v.addSubtractionListener(new SubtractionListener());
        v.addMultiplicationListener(new MultiplicationListener());
        v.addDivisionListener(new DivisionListener());
        v.addDifferentiateListener(new DifferentiateListener());
        v.addIntegrateListener(new IntegrateListener());
        v.addClearListener(new ClearListener());

    }


    class PolinomFieldListener1 implements ActionListener{

        public void actionPerformed(ActionEvent e) {
            try{
                Polinom.parsarePolinom(v.getPolinom1());
                v.getPolinomField1().setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED,
                        new Color(25,196,52), new Color(20,20,20)));
            }
            catch (Exception ex){
                v.getPolinomField1().setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED,
                        new Color(103,20,19), new Color(20,20,20)));
            }
        }
    }

    class PolinomFieldListener2 implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            try{
                Polinom.parsarePolinom(v.getPolinom2());
                v.getPolinomField2().setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED,
                        new Color(25,196,52), new Color(20,20,20)));
            }
            catch (Exception ex){

                v.getPolinomField2().setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED,
                        new Color(103,20,19), new Color(20,20,20)));
            }
        }
    }

    class AdditionListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            try{
                v.setRezultat((Operatii.adunaPolinoame(Polinom.parsarePolinom(v.getPolinom1()),
                        Polinom.parsarePolinom(v.getPolinom2())).toString()));
                v.stylize();
            }
            catch (Exception ex){
                displayCorectness();
                v.showError("Invalid");
            }
        }
    }

    class SubtractionListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            try{
                v.setRezultat((Operatii.scadePolinoame(Polinom.parsarePolinom(v.getPolinom1()),
                        Polinom.parsarePolinom(v.getPolinom2())).toString()));
                v.stylize();
            }
            catch (Exception ex){
                displayCorectness();
                v.showError("Invalid");
            }
        }
    }

    class MultiplicationListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            try{
                v.setRezultat((Operatii.inmultirePolinoame(Polinom.parsarePolinom(v.getPolinom1()),
                        Polinom.parsarePolinom(v.getPolinom2())).toString()));
                v.stylize();
            }
            catch (Exception ex){
                displayCorectness();
                v.showError("Invalid");
            }
        }
    }

    class DivisionListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            try{
                Polinom p = new Polinom();
                p.adaugaTermen(0,0.0);

                if(v.getPolinom2().equalsIgnoreCase("0")){
                    v.showError("Division by 0 is not allowed");
                    throw new Exception();
                }

                if(v.getPolinom1().equalsIgnoreCase("0")){
                    RezultatImpartire res = new RezultatImpartire(p,p);

                    v.setRezultat("Quotient: " +
                            (res.getPolinomCat() == null? 0 : res.getPolinomCat().toString()) + "  |  " +
                            "Remainder: " +
                            (res.getPolinomRest() == null? 0 : res.getPolinomRest().toString()));
                    return;
                }

                RezultatImpartire res = (Operatii.impartirePolinoame(Polinom.parsarePolinom(v.getPolinom1()),
                        Polinom.parsarePolinom(v.getPolinom2())));

                v.setRezultat("Quotient: " +
                        (res.getPolinomCat() == null? 0 : res.getPolinomCat().toString()) + "  |  " +
                        "Remainder: " +
                        (res.getPolinomRest() == null? 0 : res.getPolinomRest().toString()));

                v.stylize();
            }
            catch (Exception ex){
                displayCorectness();
                v.showError("Invalid");
            }
        }
    }

    class DifferentiateListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            try{
                if(v.getModeCBoxValue().equalsIgnoreCase("First")){
                    v.setRezultat((Operatii.deriveazaPolinom(Polinom.parsarePolinom(v.getPolinom1()))).toString());
                }
                else{
                    v.setRezultat((Operatii.deriveazaPolinom(Polinom.parsarePolinom(v.getPolinom2()))).toString());
                }
                v.stylize();
            }
            catch (Exception ex){
                displayCorectness();
                v.showError("Invalid");
            }
        }
    }

    class IntegrateListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            try{
                if(v.getModeCBoxValue().equalsIgnoreCase("First")){
                    v.setRezultat((Operatii.integreazaPolinom(Polinom.parsarePolinom(v.getPolinom1()))) + " + C");
                }
                else
                {
                    v.setRezultat((Operatii.integreazaPolinom(Polinom.parsarePolinom(v.getPolinom2()))) + " + C");
                }
                v.stylize();
            }
            catch (Exception ex){
                displayCorectness();
                v.showError("Invalid");
            }
        }
    }

    class ClearListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            v.reset();
        }
    }

    public void displayCorectness(){
        try{
            Polinom.parsarePolinom(v.getPolinom1());
            v.getPolinomField1().setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED,
                    new Color(25,196,52), new Color(20,20,20)));
        }
        catch (Exception ex){
            v.getPolinomField1().setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED,
                    new Color(103,20,19), new Color(20,20,20)));
        }

        try{
            Polinom.parsarePolinom(v.getPolinom2());
            v.getPolinomField2().setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED,
                    new Color(25,196,52), new Color(20,20,20)));
        }
        catch (Exception ex){

            v.getPolinomField2().setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED,
                    new Color(103,20,19), new Color(20,20,20)));
        }
    }
}
