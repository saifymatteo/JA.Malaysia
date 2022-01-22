// Logic for the [FractionCalculator.java]

public class Fraction {

    private int numerator;
    private int denominator;

    // Constructor
    public Fraction(int nume, int deno) {
        if (deno == 0) {
            throw new IllegalArgumentException("Denominator cannot be zero");
        } else if (deno < 0) {
            nume = -nume;
            this.numerator = nume;
            this.denominator = Math.abs(deno);
        } else {
            this.numerator = nume;
            this.denominator = deno;
        }
    }

    public Fraction(int nume) {
        this(nume, 1);
    }

    public Fraction() {
        this(0, 1);
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public String toString() {
        return numerator + "/" + denominator;
    }

    public double toDouble() {
        return numerator / denominator;
    }

    public Fraction add(Fraction other) {
        Fraction result =  new Fraction(
                (this.numerator * other.denominator) + (other.numerator * this.denominator),
                this.denominator * other.denominator
        );
        return result;
    }

    public Fraction subtract(Fraction other) {
        Fraction result = new Fraction(
                (this.numerator * other.denominator) - (other.numerator * this.denominator),
                this.denominator * other.denominator
        );
        return result;
    }

    public Fraction multiply(Fraction other) {
        Fraction result = new Fraction(
                this.numerator * other.numerator,
                this.denominator * other.denominator
        );
        return result;
    }

    public Fraction divide(Fraction other) {
        if (other.numerator == 0) {
            throw new IllegalArgumentException();
        } else {
            Fraction result = new Fraction(
                    this.numerator * other.denominator,
                    this.denominator * other.numerator
            );
            return result;
        }
    }

    public boolean equals(Object other) {
        if (other instanceof Fraction) {
            Fraction newFrac = (Fraction) other;
            Fraction result = new Fraction(this.numerator, this.denominator);
            return (result.numerator == newFrac.numerator) && (result.denominator == newFrac.denominator);
        } else {
            throw new IllegalArgumentException();
        }
    }

    public void toLowestTerms() {
        int gcd = gcd(this.numerator, this.denominator);

        numerator = numerator / gcd;
        denominator = denominator / gcd;
    }

    public int gcd(int nume, int deno) {
        while (nume != 0 && deno != 0) {
            int remainder = nume % deno;
            nume = deno;
            deno = remainder;
        }
        return nume;
    }
}
