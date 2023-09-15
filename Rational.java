import java.math.BigInteger;
import java.util.Scanner;

public class Rational {
    private BigInteger numerator;
    private BigInteger denominator;

    public Rational(BigInteger numerator, BigInteger denominator) {
        BigInteger gcd = numerator.gcd(denominator); //Finds greatest common divisor
        this.numerator = numerator.divide(gcd);      //Divides numerator and denominator by GCD
        this.denominator = denominator.divide(gcd);
    }
    public Rational add(Rational other) {   //Calculate new numerator and denominator for addition
        BigInteger newNumerator = this.numerator.multiply(other.denominator)
                .add(other.numerator.multiply(this.denominator));
        BigInteger newDenominator = this.denominator.multiply(other.denominator);
        return new Rational(newNumerator, newDenominator);
    }
    public Rational subtract(Rational other) {   //Calculate new numerator and denominator for subtraction
        BigInteger newNumerator = this.numerator.multiply(other.denominator)
                .subtract(other.numerator.multiply(this.denominator));
        BigInteger newDenominator = this.denominator.multiply(other.denominator);
        return new Rational(newNumerator, newDenominator);
    }
    public Rational multiply(Rational other) {  //Calculate new numerator and denominator for multiplication
        BigInteger newNumerator = this.numerator.multiply(other.numerator);
        BigInteger newDenominator = this.denominator.multiply(other.denominator);
        return new Rational(newNumerator, newDenominator);
    }
    public Rational divide(Rational other) { //Calculate new numerator and denominator for division
        BigInteger newNumerator = this.numerator.multiply(other.denominator);
        BigInteger newDenominator = this.denominator.multiply(other.numerator);
        return new Rational(newNumerator, newDenominator);
    }
    @Override
    public String toString() { //format rational number as a string
        return numerator + "/" + denominator;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the first rational number (numerator denominator): ");
        BigInteger num1 = input.nextBigInteger();
        BigInteger den1 = input.nextBigInteger();
        Rational rational1 = new Rational(num1, den1);

        System.out.print("Enter the second rational number (numerator denominator): ");
        BigInteger num2 = input.nextBigInteger();
        BigInteger den2 = input.nextBigInteger();
        Rational rational2 = new Rational(num2, den2);

        Rational result;

        result = rational1.add(rational2); //Add
        System.out.println(rational1 + " + " + rational2 + " = " + result);

        result = rational1.subtract(rational2); //Subract
        System.out.println(rational1 + " - " + rational2 + " = " + result);

        result = rational1.multiply(rational2); //Multiply
        System.out.println(rational1 + " * " + rational2 + " = " + result);

        result = rational1.divide(rational2); //Divide
        System.out.println(rational1 + " / " + rational2 + " = " + result);

        double decimalValue = rational2.numerator.doubleValue() / rational2.denominator.doubleValue(); //find decimal of 2nd rational number
        System.out.println(rational2 + " is " + decimalValue);

        input.close();
    }
}
