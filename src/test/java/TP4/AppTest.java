package TP4;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class AppTest {
    @Test
    void additionneDeuxValeurs() {
        Calculette calculette = new Calculette();
        calculette.empiler(1.5);
        calculette.empiler(2.5);

        calculette.addition();

        assertEquals(4.0, calculette.depiler());
    }

    @Test
    void soustraitDeuxValeursDansLeBonOrdre() {
        Calculette calculette = new Calculette();
        calculette.empiler(7.5);
        calculette.empiler(2.5);

        calculette.soustraction();

        assertEquals(5.0, calculette.depiler());
    }

    @Test
    void multiplieDeuxValeurs() {
        Calculette calculette = new Calculette();
        calculette.empiler(2.5);
        calculette.empiler(4.0);

        calculette.multiplication();

        assertEquals(10.0, calculette.depiler());
    }

    @Test
    void diviseDeuxValeursDansLeBonOrdre() {
        Calculette calculette = new Calculette();
        calculette.empiler(7.5);
        calculette.empiler(2.5);

        calculette.division();

        assertEquals(3.0, calculette.depiler());
    }

    @Test
    void calculeUneExpressionEnNotationPolonaiseInverse() {
        assertEquals(4.625, new Calculette().calculer("1.0 3 + 2 3.2 / +"));
    }

    @Test
    void refuseUneExpressionInvalide() {
        assertThrows(IllegalArgumentException.class,
                () -> new Calculette().calculer("1 2"));
    }

    @Test
    void refuseUneDivisionParZero() {
        assertThrows(ArithmeticException.class,
                () -> new Calculette().calculer("1 0 /"));
    }
}
