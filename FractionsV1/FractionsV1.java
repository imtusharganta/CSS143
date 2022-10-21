import java.util.*;
import java.io.*;

/**
 * This program takes in a text file
 * which contains fractions as a String
 * and checks how many times the fraction appears
 * in the file.
 */
public class FractionsV1 {
  // created an instance variable for the array
  // created one for an index as well to access the index of the array.
  private int[] fracArray;
  private int index;

  /**
   * Main method is used to create the object
   * and we then perform the functions needed.
   * 
   * @param args
   */
  public static void main(String[] args) {
    FractionsV1 obj = new FractionsV1();
    obj.readFile();
  }

  /**
   * This constructor is created since we want to create
   * an array which split the numerator and denominator from the files
   * so what it does is it goes through the entire file first and multiplies
   * the count by 2, since numerator takes up one index,
   * and the denominator takes up the next.
   */
  public FractionsV1() {
    index = 0;
    fracArray = new int[checkLines()];
  }

  /**
   * This is the method which read the file
   * It then splits the fraction
   * and then checks if there are repetitions of a fraction
   */
  public void readFile() {
    try {
      Scanner console = new Scanner(new File("fractions.txt"));
      while (console.hasNextLine()) {
        String fraction = console.nextLine();
        splitFraction(fraction);
      }
      checkReps();
    } catch (FileNotFoundException e) {
      System.out.print("File not Found");
      System.exit(0);
    }
  }

  /**
   * this method splits the fraction
   * it takes in the Fraction from the file, and splits it at the "/"
   * it then puts it into an array, where the first index is the numerator
   * and then second is the denominator.
   * increments the array by 2 so values dont overlap
   * 
   * @param str
   */
  public void splitFraction(String str) {
    try {
      String[] parts = str.split("/");
      for (int i = 0; i < parts.length; i++) {
        // gets numerical value from string array
        fracArray[index] = Integer.parseInt(parts[i]);
        fracArray[index + 1] = Integer.parseInt(parts[i + 1]);
        index += 2;
      }
    } catch (Exception e) {
    }
  }

  /**
   * this method is used to check the count of the fraction we
   * are currenlty on. The first loop is used to check each fraction
   * individually. It then loops again to check EVERY other fraction in the final
   * uses multiplication method to count how many times.
   */
  public void checkReps() {
    for (int i = 0; i < fracArray.length; i += 2) {
      int count = 0;
      int num1 = fracArray[i];
      int den1 = fracArray[i + 1];
      for (int j = 0; j < fracArray.length; j += 2) {
        int num2 = fracArray[j];
        int den2 = fracArray[j + 1];
        // adds the amount of times number repeats
        if (crossMultiplyEquals(num1, den1, num2, den2))
          count++;
      }
      // checks of denominator is not equal to 0, then performs function
      // else it says cant divide by 0 on the line the invalid fraction is at.
      if (den1 != 0) {
        if (isUnique(num1, den1, i))
          System.out.println(num1 + "/" + den1 + " has a count of " + count);
      } else {
        System.out.println("Cant divide by 0, " + num1 + "/" + den1 + " is invalid");
      }
    }
  }

  /**
   * this method checks if the number is unique.
   * it takes in the numerator and denominator and checks
   * if it is unique at the index which will be checked in the other methods.
   * if the crossMultiplyEquals is true, then the number is not unique,
   * which returns false overall
   * 
   * @param num1
   * @param den1
   * @param index
   * @return boolean
   */
  public boolean isUnique(int num1, int den1, int index) {
    for (int j = 0; j < index; j += 2) {
      int num2 = fracArray[j];
      int den2 = fracArray[j + 1];
      if (crossMultiplyEquals(num1, den1, num2, den2))
        return false;
    }
    return true;
  }

  /**
   * this method is used to cross multiply the numbers which we are trying to see
   * how many times it repeats. This method only serves to just multiply numbers.
   * 
   * @param n1
   * @param d1
   * @param n2
   * @param d2
   * @return
   */
  public boolean crossMultiplyEquals(int n1, int d1, int n2, int d2) {
    if (n1 * d2 == n2 * d1) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * this method is used to get the number of lines in the array,
   * which is then used to get the size of the total array because since we are
   * splitting
   * the fractions, it is going to split 1 fraction into two numbers,
   * so we return the size of the array times 2.
   * 
   * @return
   */
  public int checkLines() {
    int count = 0;
    try {
      Scanner console = new Scanner(new File("fractions.txt"));
      while (console.hasNextLine()) {
        count++;
        console.nextLine();
      }
    } catch (FileNotFoundException e) {
      System.out.print("File not Found");
      System.exit(0);
    }
    // to get enough space for both numerator and denominator.
    return count;
  }

}
