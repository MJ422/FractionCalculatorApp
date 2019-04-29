import java.util.InputMismatchException;

public class Fraction {

    private int numerator;
    private int denominator;

    public Fraction(int numer, int denom){
        /*if (denom == 0){
            throw new IllegalArgumentException("Denominator cannot be zero!");
        }*/

        this.numerator = numer;
        this.denominator = denom;

    }//end two arg constructor

    public Fraction(int numer){
        this.numerator = numer;
        this.denominator = 1;

    }//end one arg constructor

    public Fraction(){
        this.numerator = 0;
        this.denominator = 1;
    }//end zero arg constructor
    //

    public int getNumerator(){
        return this.numerator;
    }//accessor method for numerator

    public int getDenominator() {
        return this.denominator;
    }//accessor method for denominator
    //

    public String toString(){
        return this.numerator + "/" + this.denominator;
    }

    public double toDouble(){
        double result = ((double) numerator / (double) denominator);
        return result;
    }

     public Fraction add(Fraction other){
        Fraction newFrac = new Fraction((this.numerator + other.numerator),(this.denominator + other.denominator));
        newFrac.toLowestTerms();
        return newFrac;
    }

    public Fraction subtract(Fraction other){
        Fraction newFrac = new Fraction((this.numerator - other.numerator),(this.denominator - other.denominator));
        newFrac.toLowestTerms();
        return newFrac;
    }

    public Fraction multiply(Fraction other){
        Fraction newFrac = new Fraction((this.numerator * other.numerator),(this.denominator * other.denominator));
        newFrac.toLowestTerms();
        return newFrac;
    }

    public Fraction divide(Fraction other){
        Fraction newFrac = new Fraction((this.numerator * other.denominator),(this.denominator * other.numerator));
        newFrac.toLowestTerms();
        return newFrac;
    }

    public boolean equals(Object other){
        if (other instanceof Fraction){
            Fraction comparedFraction = (Fraction)other;
            comparedFraction.toLowestTerms();

            Fraction thisFraction = new Fraction(this.numerator, this.denominator);
            comparedFraction.toLowestTerms();

            if(thisFraction.numerator == comparedFraction.numerator && thisFraction.denominator == comparedFraction.denominator){
                return true;
            }
            else {
                return false;
            }
        }//end if other is a fraction object
        else{
            throw new InputMismatchException();
        }
    }

    public int gcd(int num, int den){
        while (num != 0 && den != 0){
            int remainder = num % den;
            num = den;
            den = remainder;
        }
        return num;
    }

    /* public static int gcd(int num, int den){
        if (den == 0){
            return num;
        }
        return gcd(den, num % den);

    } */


    public void toLowestTerms(){

        //apparently this doesn't work???
        //my equals method should work but this doesnt break it down to make them equal when tested

        int greatestCD = gcd(this.numerator, this.denominator);

        this.numerator /= greatestCD;
        this.denominator /= greatestCD;

        if (this.denominator < 0){
            this.numerator *= -1;
            this.denominator *= -1;
        }

    }

}//end fraction class
