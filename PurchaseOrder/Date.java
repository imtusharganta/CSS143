import java.io.*;
import java.util.*;

/**
 * Tushar Ganta
 * Date.java
 * 2/1/2021
 * Tim Carlson CSS 143
 */

public class Date implements Comparable, Serializable {
  /**
   * variables for day month and year.
   */
  private int day;
  private int month;
  private int year;

  /**
   * This constructor sets the month day and year
   * we then pass in the date month and year into a method
   * which checks if the params are valid, if they are
   * then we set the day month and year to the parameters.
   * 
   * @param month
   * @param day
   * @param year
   */
  public Date(int month, int day, int year) {
    if (validDateCheck(day)) {
      this.day = day;
    }
    if (validMonthCheck(month)) {
      this.month = month;
    }
    if (validYearCheck(year)) {
      this.year = year;
    }
  }

  /**
   * This consturctor is used for when we want to set one date
   * to another. If it is not null, it will check if it is valid
   * if it is, then it will set the date month and year to the date we passed in.
   * 
   * @param other
   */
  public Date(Date other) {
    if (other != null) {
      if (validDateCheck(other.day)) {
        this.day = other.day;
      }
      if (validMonthCheck(other.month)) {
        this.month = other.month;
      }
      if (validYearCheck(other.year)) {
        this.year = other.year;
      }
    }
  }

  /**
   * This returns the year
   * 
   * @return
   */
  public int getYear() {
    return this.year;
  }

  /**
   * This returns the month
   * 
   * @return
   */
  public int getMonth() {
    return this.month;
  }

  /**
   * This returns the day
   * 
   * @return
   */
  public int getDay() {
    return this.day;
  }

  /**
   * This sets the year if it is valid
   * 
   * @param year
   */
  public void setYear(int year) {
    if (validYearCheck(year)) {
      this.year = year;
    }
  }

  /**
   * This sets the month if its valid
   * 
   * @param month
   */
  public void setMonth(int month) {
    if (validMonthCheck(month)) {
      this.month = month;
    }
  }

  /**
   * This sets the day if its valid
   * 
   * @param day
   */
  public void setDay(int day) {
    if (validDateCheck(day)) {
      this.day = day;
    }
  }

  /**
   * This sets the month day year, and it first checks if theyre all valid,
   * if its not, then it wont set the Date to those.
   * 
   * @param month
   * @param day
   * @param year
   */
  public void setAll(int month, int day, int year) {
    if (validMonthCheck(month)) {
      this.month = month;
    }
    if (validDateCheck(day)) {
      this.day = day;
    }
    if (validYearCheck(year)) {
      this.year = year;
    }

  }

  /**
   * This checks if the date we are passing in is after than
   * the one we are passing in.
   * We first check if the year is greater, if it is, then we automatically
   * return true, if the year is the same, we then check if the month is greater,
   * if it is, return true. If the month and year are the same, we check to see if
   * if the day is greater. If it is, then we return true;
   * 
   * @param compareTo
   * @return boolean
   */
  public boolean isAfter(Date compareTo) {
    if (compareTo.year > this.year) {
      return true;
    } else if (compareTo.year == this.year) {
      if (compareTo.month > this.month) {
        return true;
      } else if (compareTo.month == this.month) {
        if (compareTo.day > this.day) {
          return true;
        }
      }
    }
    return false;
  }

  /**
   * This is the method to check if one date is equal to Another
   * we first downcast the object to Date so we can compare it
   * if the year, month, and day are the exact same, we set the boolean value
   * to true, else we set the boolean variable to false.
   */
  public boolean equals(Object date) {
    Date temp = (Date) date;
    boolean doesEqual = false;
    if (temp.getYear() == this.getYear()) {
      if (temp.getMonth() == this.getMonth()) {
        if (temp.getDay() == this.getDay()) {
          doesEqual = true;
        }
      }
    } else {
      doesEqual = false;
    }
    return doesEqual;
  }

  /**
   * This is used to check if the day is valid
   * if it isnt' we print out Invalid day and it sets to 0.
   * 
   * @param day
   * @return boolean
   */
  private boolean validDateCheck(int day) {
    if (day > 31 || day < 0) {
      System.out.println("Invalid Day");
      System.exit(0);
    }
    return (day < 32 && day > 0);
  }

  /**
   * This is used to check if the month is valid,
   * if it isn't we print out Invalid month and set it to 0.
   * 
   * @param month
   * @return boolean
   */
  private boolean validMonthCheck(int month) {
    if (month > 12 || month < 1) {
      System.out.println("Invalid Month");
      System.exit(0);
    }
    return (month > 0 && month < 13);
  }

  /**
   * This is to check if the year we set is valid,
   * if it isn't then it will print 0 at the year, depending on the digits.
   * 
   * @param year
   * @return boolean
   */
  private boolean validYearCheck(int year) {
    if (year > 2026 || year < 2016) {
      System.out.println("Invalid Year");
      System.exit(0);
    }
    return (year > 2015 && year < 2027);
  }

  /**
   * This is the toString. If any of the params are invalid,
   * there will be a 00 for month or day (if one or both are invalid)
   * and 0000 for year.
   */
  public String toString() {
    return String.format("%02d/%02d/%04d", month, day, year);
  }

}
