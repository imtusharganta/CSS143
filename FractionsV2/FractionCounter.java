
/**
 * this class is used to count the Fractions
 * when we create the object and how many times it appears in
 * the file.
 */
public class FractionCounter {
  // We have a Fraction Object for when we pass in the Fraction
  // and when we want count it.
  private Fraction fraction;
  private int count;

  /**
   * Constructor when counting a fraction
   * we have count at 1 because when we are on that Fraction
   * technically it has already appeared once.
   * 
   * @param theFraction
   */
  public FractionCounter(Fraction theFraction) {
    fraction = theFraction;
    count = 1;
  }

  /**
   * This method compares two fractions. This will be for when we go
   * throught the file and it will compare the fraction we are currently
   * on to the one in the file.
   * 
   * @param newFraction
   * @return
   */
  public boolean compareAndIncrement(Fraction newFraction) {
    if (fraction.equals(newFraction)) {
      count++;
      return true;
    } else {
      return false;
    }
  }

  // This is the toString we will use when Printing.
  public String toString() {
    return fraction + " has a count of " + count;
  }
}