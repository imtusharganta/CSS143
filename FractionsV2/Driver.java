import java.util.*;
import java.io.*;

/**
 * This is the class where we will be running everything.
 */
public class Driver {

  private FractionCounter counter;
  private ObjectList list = new ObjectList();
  private Fraction fraction;

  // read in file
  public static void main(String[] args) {
    Driver driver = new Driver();
    driver.readFile();
  }

  /**
   * This is the method where everything is going to start.
   */
  public void readFile() {
    Scanner console = null;
    try {
      // We try to open the file
      console = new Scanner(new File("fractions.txt"));
    } catch (FileNotFoundException e) {
      System.out.println("File Not Found");
      System.exit(0);
    }
    // while we have the fraction
    while (console.hasNextLine()) {
      // We will initially set this to false,
      // as we have not seen the fraction yet.
      boolean doesExist = false;
      /**
       * Since the fractions are techinically in a String
       * We are going to split it
       * and the Array elements,
       * We are going to set index[0] to the numerator
       * and the index[1] to the denominator;
       */
      String frac = console.nextLine();
      String[] parts = frac.split("/");
      int n = Integer.parseInt(parts[0]);
      int d = Integer.parseInt(parts[1]);
      // We will then make this into a Fraction object so we can count it.
      fraction = new Fraction(n, d);
      if (d == 0) {
        System.out.println("Can't divide by 0, " + n + "/" + d + " is invalid");
      } else {
        // if the denominator is valid,
        // then we will traverse throught the elements in the list
        // and we will set the FractionCounter equal to the Fraction
        // at that index in the list
        for (int i = 0; i < list.getElements(); i++) {
          counter = (FractionCounter) list.get(i);
          // if we compare it and they are equal
          // then that number does exist, which will increment the FractionCounter
          if (counter.compareAndIncrement(fraction)) {
            doesExist = true;
          }
        }
        /**
         * if it doesn't exist,
         * then it will reduce the fraction to its lowest terms
         * and add this fraction to the list and start a new FractionCounter for it
         * and it will display its toString.
         */
        if (!doesExist) {
          fraction.reduceFraction();
          list.add(new FractionCounter(fraction));
        }
      }
    }
    /**
     * After going through the entire file
     * if there are 0 elements, it will print the message
     * else it will print the the list, since it has gone through
     * everything in the file.
     */
    if (list.getElements() == 0) {
      System.out.println("No fraction found");
    } else {
      System.out.println(list);
    }
  }
}