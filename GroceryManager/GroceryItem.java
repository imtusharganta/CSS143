import java.util.*;
import java.io.*;

/**
 * This is the class which
 */
public abstract class GroceryItem implements Comparable {
  private String name;
  private int quantity;
  private double price;

  /**
   * This is the constructor which will take in the name quantity and price f
   * Of the GroceryItem we are trying to create
   */
  public GroceryItem(String name, int quantity, double price) {
    setName(name);
    setQuantity(quantity);
    setPrice(price);
  }

  /**
   * No arg constructor for the grocery item
   */
  public GroceryItem() {
    name = null;
    quantity = 0;
    price = 0;
  }

  /**
   * sets the name of the item
   * 
   * @param name
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * returns the name of the item
   * 
   * @return this.name
   */
  public String getName() {
    return this.name;
  }

  /**
   * sets the price of the groceryItem
   * 
   * @param price
   */
  public void setPrice(double price) {
    this.price = price;
  }

  /**
   * returns the price
   * 
   * @return
   */
  public double getPrice() {
    return this.price;
  }

  /**
   * sets the quantity
   * 
   * @param quantity
   */
  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  /**
   * this returns the quantity of the Grocery Item
   * 
   * @return
   */
  public int getQuantity() {
    return this.quantity;
  }

  /**
   * To string method
   */
  public String toString() {
    String s = "";
    s = String.format("%-20d%-20d%-20d", "Name: " + this.getName(), "Quantity: " + this.getQuantity());
    return s;
  }

  /**
   * This is the compareTo method,
   * we will first check if the object we are passing in is an instance of
   * Grocery Item, if it is, we will cast it to the object
   */
  @Override
  public int compareTo(Object o) {
    if (o instanceof GroceryItem) {
      GroceryItem temp = (GroceryItem) o;
      if (temp.getName().equals(this.getName())) {
        return 0;
      } else if (temp.getName().compareTo(this.getName()) > 0) {
        return 1;
      }
    }
    return -1;
  }

}