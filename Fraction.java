package Matriks;

class Fraction {
    private int numerator;
    private int denominator;

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;

        if (denominator != 0) {
            this.denominator = denominator;
        } else {
            throw new IllegalArgumentException("Penyebut tidak boleh nol.");
        }
    }

    public static Fraction fromString(String fractionString) {
        String[] parts = fractionString.split("/");
        int numerator = Integer.parseInt(parts[0]);
        int denominator = Integer.parseInt(parts[1]);
        return new Fraction(numerator, denominator);
    }

    public Fraction add(Fraction other) {
        int commonDenominator = this.denominator * other.denominator;
        int newNumerator = this.numerator * other.denominator + other.numerator * this.denominator;
        return new Fraction(newNumerator, commonDenominator).simplify();
    }

    public Fraction subtract(Fraction other) {
        int commonDenominator = this.denominator * other.denominator;
        int newNumerator = this.numerator * other.denominator - other.numerator * this.denominator;
        return new Fraction(newNumerator, commonDenominator).simplify();
    }

    public Fraction multiply(Fraction other) {
        int newNumerator = this.numerator * other.numerator;
        int newDenominator = this.denominator * other.denominator;
        return new Fraction(newNumerator, newDenominator).simplify();
    }

    public Fraction divide(Fraction other) {
        if (other.numerator == 0) {
            throw new ArithmeticException("Tidak dapat melakukan pembagian oleh nol.");
        }
        int newNumerator = this.numerator * other.denominator;
        int newDenominator = this.denominator * other.numerator;
        return new Fraction(newNumerator, newDenominator).simplify();
    }

    private int greatestCommonDivisor(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return greatestCommonDivisor(b, a % b);
        }
    }

    private Fraction simplify() {
        int gcd = greatestCommonDivisor(this.numerator, this.denominator);
        return new Fraction(this.numerator / gcd, this.denominator / gcd);
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }
}
