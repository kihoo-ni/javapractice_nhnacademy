package com.nhnacademy;

public class Rational {
    // 분자
    int numerator;

    // 분모
    int denominator;

    public Rational(int n) {
        numerator = n;
        denominator = 1;
    }

    public Rational(int numerator, int denominator) {
        if (denominator == 0) {
            throw new ArithmeticException();
        }

        if (denominator < 0) {
            numerator *= -1;
            denominator *= -1;

        }

        int g = gcd(Math.abs(numerator), Math.abs(denominator));

        this.numerator = numerator / g;
        this.denominator = denominator / g;
    }

    public Rational(Rational other) {
        this.numerator = other.getNumerator();
        this.denominator = other.getNumerator();
    }

    int getNumerator() {
        return numerator;
    }

    int getDenominator() {
        return denominator;
    }

    @Override
    public String toString() {
        if (getDenominator() == 1) {
            return "[" + getNumerator() + "]";
        } else {
            return "[" + getNumerator() + "/" + getDenominator() + "]";
        }
    }

    @Override
    public boolean equals(Object other) {
        return (other instanceof Rational)
                && (hashCode() == other.hashCode())
                && (getNumerator() == ((Rational) other).getNumerator())
                && (getDenominator() == ((Rational) other).getDenominator());
    }

    public static Rational add(Rational x, Rational y) {
        return new Rational(
                x.getNumerator() * y.getDenominator() + x.getDenominator() * y.getNumerator(),
                x.getDenominator() * y.getDenominator());

    }

    public static Rational substract(Rational x, Rational y) {
        return new Rational(
                x.getNumerator() * y.getDenominator() - x.getDenominator() * y.getNumerator(),
                x.getDenominator() * y.getDenominator());
    }

    public static Rational multply(Rational x, Rational y) {
        return new Rational(
                x.getNumerator() * y.getNumerator(),
                x.getDenominator() * y.getDenominator());
    }

    public static Rational divide(Rational x, Rational y) {
        // return new Rational(
        //         x.getNumerator() * y.getDenominator(),
        //         x.getDenominator() * y.getNumerator());

         return Rational.multply(x, y.reciprocal());
    }

    public Rational inverse() {
        return new Rational(-getNumerator(), getDenominator());
    }

    public Rational reciprocal() {
        return new Rational(getDenominator(), getNumerator());
    }

    public Rational pow(int n) {
        return new Rational((int)Math.pow(getNumerator(), n), (int) Math.pow(getDenominator(), n));
    }

    int gcd(int x, int y) {
        if ((x < 0) || (y < 0)) {
            throw new ArithmeticException();
        }

        if (y == 0) {
            return x;
        }

        return gcd(y, x % y);
    }
}
