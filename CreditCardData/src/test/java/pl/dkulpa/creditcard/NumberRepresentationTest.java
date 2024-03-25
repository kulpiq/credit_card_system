package pl.dkulpa.creditcard;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class NumberRepresentationTest {
    @Test
    void doubleRepresentation() {
        double a = 0.82;
        double b = 0.38;
        System.out.println("Double");
        System.out.println(b - a);
    }

    @Test
    void floatRepresentation() {
        float a = 0.826f;
        float b = 0.385f;
        System.out.println("Float");
        System.out.println(b - a);
    }
    @Test
    void bigDecimalRepresentation(){
        BigDecimal a = new BigDecimal("0.6664");
        BigDecimal b = new BigDecimal("0.123");
        System.out.println("BigDecimal");
        System.out.println(b.subtract(a));
    }

}
