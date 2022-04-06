import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class OperatiiTest {

    private Polinom p1;
    private Polinom p2;

    @BeforeEach
    void setUp() {
        // p1 = 5x^3 + 3x + 2
        p1 = new Polinom();
        p1.adaugaTermen(3,5.0);
        p1.adaugaTermen(1,3.0);
        p1.adaugaTermen(0,2.0);

        // p2 = 3x^2 + 2x
        p2 = new Polinom();
        p2.adaugaTermen(2,3.0);
        p2.adaugaTermen(1,2.0);

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void adunare() {
        Polinom result = new Polinom();
        result.adaugaTermen(3,5.0);
        result.adaugaTermen(2,3.0);
        result.adaugaTermen(1,5.0);
        result.adaugaTermen(0,2.0);

        assertTrue(Operatii.adunaPolinoame(p1,p2).toString().equalsIgnoreCase(result.toString()));
    }

    @Test
    void scadere() {
        Polinom result = new Polinom();
        result.adaugaTermen(3,5.0);
        result.adaugaTermen(2,-3.0);
        result.adaugaTermen(1,1.0);
        result.adaugaTermen(0,2.0);

        assertTrue(Operatii.scadePolinoame(p1,p2).toString().equalsIgnoreCase(result.toString()));
    }

    @Test
    void inmultire() {
        Polinom result = new Polinom();
        result.adaugaTermen(5,15.0);
        result.adaugaTermen(4,10.0);
        result.adaugaTermen(3,9.0);
        result.adaugaTermen(2,12.0);
        result.adaugaTermen(1,4.0);

        assertTrue(Operatii.inmultirePolinoame(p1,p2).toString().equalsIgnoreCase(result.toString()));
    }

    @Test
    void impartire() {
        Polinom quotient = new Polinom();
        quotient.adaugaTermen(1,1.67);
        quotient.adaugaTermen(0,-1.11);

        Polinom remainder = new Polinom();
        remainder.adaugaTermen(1,5.22);
        remainder.adaugaTermen(0,2.0);

        assertTrue(Operatii.impartirePolinoame(p1,p2).getPolinomCat().toString().equalsIgnoreCase(quotient.toString()) &&
                Operatii.impartirePolinoame(p1,p2).getPolinomRest().toString().equalsIgnoreCase(remainder.toString()));
    }

    @Test
    void derivare() {
        Polinom result = new Polinom();
        result.adaugaTermen(2,15.0);
        result.adaugaTermen(0,3.0);

        assertTrue(Operatii.deriveazaPolinom(p1).toString().equalsIgnoreCase(result.toString()));
    }

    @Test
    void integrare() {
        Polinom result = new Polinom();
        result.adaugaTermen(4,1.25);
        result.adaugaTermen(2,1.5);
        result.adaugaTermen(1,2.0);

        assertTrue(Operatii.integreazaPolinom(p1).toString().equalsIgnoreCase(result.toString()));
    }
}