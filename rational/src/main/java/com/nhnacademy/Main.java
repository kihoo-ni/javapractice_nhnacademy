package com.nhnacademy;

public class Main {
    public static void main(String[] args) {
        try {
            Rational r1 = new Rational(3,4);
            Rational r2= new Rational(1,2);
            Rational r3= Rational.substract(r1, r2);
            Rational r4=Rational.add(r1, r2);
            Rational r5=Rational.divide(r1, r2);
            Rational r6=Rational.multply(r1, r2);

            System.out.println("r3: "+r3);
            System.out.println("r4: "+r4);
            System.out.println("r5: "+r5);
            System.out.println("r6: "+r6);
            
            Rational r7=r1.inverse();
            Rational r8=r1.reciprocal();
            Rational r9=r1.pow(2);
            
            System.out.println("r7: "+r7);
            System.out.println("r8: "+r8);
            System.out.println("r9: "+r9);
        } catch (ArithmeticException e) {
            System.err.println(e.getMessage());
        }

    }
}
