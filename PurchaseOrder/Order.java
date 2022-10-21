import java.io.*;
import java.util.*;

/**
 * Tushar Ganta
 * CSS 143 Tim Carlson
 * This is the order class
 */

public class Order implements Comparable, Serializable {

  /**
   * these are the variables we will use
   * for the different types of objects that
   * will be used in the order class.
   */
  private Money amount;
  private Date orderDate;
  private Date sentDate;
  private String customer;
  private String item;

  /**
   * This constructor will take in the Amount of money, the order date
   * the customer, and the item they bought.
   * 
   * @param amount
   * @param orderDate
   * @param customer
   * @param item
   */
  public Order(Money amount, Date orderDate, String customer, String item) {
    this.amount = amount;
    this.orderDate = orderDate;
    this.customer = customer;
    this.item = item;
  }

  /**
   * This constructor is used to copy an existing order
   * if the order is not null, then it will copy everything.
   * 
   * @param toCopy
   */
  public Order(Order toCopy) {
    if (toCopy != null) {
      this.amount = toCopy.amount;
      this.orderDate = toCopy.orderDate;
      this.customer = toCopy.customer;
      this.item = toCopy.item;
    } else {
      System.out.println("No item to copy");
    }
  }

  /**
   * we will return the amount of the order
   * but we will create a newed money object and return that.
   * 
   * @return
   */
  public Money getAmount() {
    return new Money(amount);
  }

  /**
   * This returns the date we ordered the item
   * we then return a newed Date object of the date
   * we ordered.
   * 
   * @return
   */
  public Date getOrderDate() {
    return new Date(orderDate);
  }

  /**
   * This getter returns the customer.
   * 
   * @return
   */
  public String getCustomer() {
    return customer;
  }

  /**
   * This method returns the item we had.
   * 
   * @return
   */
  public String getItem() {
    return item;
  }

  /**
   * This method checks if the order has been fulfilled.
   * we check the sentDate because we don't set it in the constructor
   * after or if we ever set it. if its NOT null, then the order is considered
   * fulfilled, which returns true, else it returns false.
   * 
   * @return
   */
  public boolean isFulfilled() {
    return (sentDate != null);
  }

  /**
   * This method is used to set the date the order will be fulfilled
   * if the the date we pass in is after the date that is calling the method
   * then its a valid date for after, and returns true;
   * 
   * @param sentDate
   * @return
   */
  public boolean setFulfilled(Date sentDate) {
    if (orderDate.isAfter(sentDate)) {
      this.sentDate = sentDate;
      return true;
    }
    return false;
  }

  /**
   * this method is to check to set a another order date
   * if the order has been fulfilled then we don't set the date
   * else we set a new order date by passing in the nextDate object
   * and set the month day and year, and return true.
   * 
   * @param nextDate
   * @return
   */
  public boolean setOrderDate(Date nextDate) {
    if (isFulfilled()) {
      return false;
    } else {
      orderDate.setAll(nextDate.getMonth(), nextDate.getDay(), nextDate.getYear());
      return true;
    }
  }

  /**
   * This method is used to set the Amount to the this object by passing in
   * the other amount. If the order is fulfilled we return false, else, we set
   * the this object to the other amount for dollars.
   * 
   * @param amount
   * @return
   */
  public boolean setAmount(Money amount) {
    if (isFulfilled()) {
      return false;
    } else {
      this.amount.setMoney(amount.getDollars(), amount.getCents());
      return true;
    }
  }

  /**
   * This method sets the customer.
   * 
   * @param customer
   */
  public void setCustomer(String customer) {
    this.customer = customer;
  }

  /**
   * This is the toString method. We have A string value
   * which we then concatenate the Customer, the Item, the
   * Order amount, the Order date, and the OrderFulfilled.
   * we then return the String with all the information.
   */
  public String toString() {
    String string = "";
    string += "Customer: " + getCustomer() + "\n";
    string += "Item: " + getItem() + "\n";
    string += "Order Amount: " + amount + "\n";
    string += "Order Date: " + orderDate.toString() + " \n";
    string += "Order Fulfilled: " + sentDate + "\n";
    return string;
  }

  /**
   * This method is used to check if two orders are the same
   * we check if the names and the items are the exact same
   * if they are, then we return true, else we return false.
   * 
   * @param toCompare
   * @return
   */
  public boolean equals(Object toCompare) {
    Order temp = (Order) toCompare;
    boolean doesEqual = false;
    if (this.customer.equalsIgnoreCase(temp.customer) && this.item.equalsIgnoreCase(temp.item)) {
      doesEqual = true;
    } else {
      doesEqual = false;
    }
    return doesEqual;
  }

}
