/**
 * The purpose of this class is to make
 * each fraction we parse as an OBJECT
 */
public class Fraction {
  private int numerator;
  private int denominator;

  // we will automatically set these to 1, so we atleast
  // have a valid fraction
  public Fraction() {
    numerator = 1;
    denominator = 1;
  }

  /**
   * this is when we want to create a Fraction object
   * we will use this when we have to parse Strings into ints
   * in the Driver.
   * 
   * @param numerator
   * @param denominator
   */
  public Fraction(int numerator, int denominator) {
    this.numerator = numerator;
    this.denominator = denominator;
    checkValid();
    reduceFraction();
  }

  // sets numerator
  public void setNumerator(int numerator) {
    this.numerator = numerator;
  }

  // gets Numerator
  public int getNumerator() {
    return this.numerator;
  }

  // sets denominator
  public void setDenominator(int denominator) {
    this.denominator = denominator;
  }

  // gets denominator
  public int getDenominator() {
    return this.denominator;
  }

  // this will take in a fraction object
  // and check the values.
  public boolean equals(Fraction other) {
    if (this.numerator == other.numerator && this.denominator == other.denominator) {
      return true;
    }
    return false;
  }

  // if den is negative or if 0;
  public void checkValid() {
    int den = this.denominator;
    int num = this.numerator;
    if (den < 0) {
      num *= -1;
      den = Math.abs(den);
      setNumerator(num);
      setDenominator(den);
    }
  }

  // this uses the gcd function
  // and then reduces the fraction.
  public void reduceFraction() {
    if (numerator != 0 && denominator != 0) {
      int reduction = getGCD(numerator, denominator);
      numerator /= reduction;
      denominator /= reduction;
    }
  }

  /**
   * Euclidian Algorithm.
   * https://makeinjava.com/gcd-two-numbers-euclidean-algorithm-java-iterative-recursive/
   * 
   * @param num1
   * @param num2
   * @return GCD
   */
  public int getGCD(int a, int b) {
    int temp = 0;
    while (b != 0) {
      temp = b;
      b = a % b;
      a = temp;
    }
    return a;
  }

  public String toString() {
    return this.numerator + "/" + this.denominator;
  }
}