import java.util.*;
import java.io.*;

/**
 * Tushar Ganta
 * CSS 143
 * Professor Tim Carlson
 * Privacy Leaks
 */

public class Money implements Comparable, Serializable {
  private int dollars;
  private int cents;

  /**
   * This is the default Constructor in which
   * we set the dollar and cents
   */
  public Money() {
    dollars = 0;
    cents = 0;
  }

  /**
   * This constructor is used when we want to pass in dollars
   * We will check if the params that are set are valid.
   * 
   * @param dollars
   */
  public Money(int dollars) {
    this.dollars = dollars;
    cents = 0;
    checkValid();
  }

  /**
   * This constructor is used when we want to pass in dollars and cents
   * this then will check if the parameters sent in were valid.
   * 
   * @param dollars
   * @param cents
   */
  public Money(int dollars, int cents) {
    this.dollars = dollars;
    this.cents = cents;
    checkValid();
  }

  /**
   * This is the copy constructor
   * We will also check if the the parameters passed in have calid dollars and
   * cents
   * 
   * @param other
   */
  public Money(Money other) {
    if (other != null) {
      this.dollars = other.dollars;
      this.cents = other.cents;
      checkValid();
    }
  }

  /**
   * This method returns the dollars
   * 
   * @return
   */
  public int getDollars() {
    return this.dollars;
  }

  /**
   * This method returns the cents
   * 
   * @return
   */
  public int getCents() {
    return this.cents;
  }

  /**
   * This method sets the money and first checks if its valid, then it sets it.
   * 
   * @param dollars
   * @param cents
   */
  public void setMoney(int dollars, int cents) {
    checkValid();
    this.dollars = dollars;
    this.cents = cents;
  }

  /**
   * This will call the get money double, which will return
   * the total amount of money.
   * 
   * @return
   */
  public double getMoney() {
    return getMoneyDouble();
  }

  /**
   * This method is used to make the total of the money
   * with the double values. we add dollars to total money,
   * and we then cast the cents to a double and multiply it with a decimal
   * to get the double value.
   * 
   * @return
   */
  private double getMoneyDouble() {
    double totalMoney = 0;
    totalMoney += dollars;
    double newCents = (double) (cents * 1.00) / 100;
    totalMoney += newCents;
    checkValid();
    return totalMoney;
  }

  /**
   * This method is used when we want to add dollars
   * 
   * @param dollars
   */
  public void add(int dollars) {
    this.dollars += dollars;
  }

  /**
   * This method is used when we want to add dollars and cents
   * we then check if its valid.
   * 
   * @param dollars
   * @param cents
   */
  public void add(int dollars, int cents) {
    this.dollars += dollars;
    this.cents += cents;
    checkValid();
  }

  /**
   * This method is used another money object
   * we then check if its valid.
   * 
   * @param other
   */
  public void add(Money other) {
    this.dollars += other.dollars;
    this.cents += other.cents;
    checkValid();
  }

  /**
   * This method is used so we can have a valid count of money
   * if the cents are ever greater than 99, we know that is is 1 dollar
   * so we divide the number by 100 and add it to the dollars
   * while we then have the remaining cents get modded by 100.
   * we then set the cents to the modded cents.
   */
  private void checkValid() {
    if (cents > 99) {
      int newDollar = cents / 100;
      this.dollars += newDollar;
      int remainingCents = cents % 100;
      this.cents = remainingCents;
    }
  }

  /**
   * This is used to check if the two objects are even equal
   * if the variable equals the same value as the current object
   * then we return true.
   */
  public boolean equals(Object o) {
    Money temp = (Money) o;
    boolean doesEqual = false;
    if (temp.getMoney() == this.getMoney()) {
      doesEqual = true;
    } else {
      doesEqual = false;
    }
    return doesEqual;
  }

  /**
   * This is used to format the cents and the dollars
   * we will use string format so when we print the object
   * it will give us the right format when we have cents less than 10
   * or if its greater than 10.
   */
  public String toString() {
    return String.format("$%d.%02d", dollars, cents);
  }

}