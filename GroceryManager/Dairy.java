import java.util.*;
import java.io.*;

/**
 * This is the Dairy Class which extends the GroceryItem class
 */
public class Dairy extends GroceryItem {
  // we use the refrigerationTemperature for our Dairy class
  private int refrigerationTemperature;

  /**
   * THis is the constructor for the Dairy class,
   * we will use super because GroceryItem will set name quantity and price
   * we will then set the refrigerationTemperature.
   * 
   * @param name
   * @param quantity
   * @param price
   * @param refrigerationTemperature
   */
  public Dairy(String name, int quantity, double price, int refrigerationTemperature) {
    super(name, quantity, price);
    this.refrigerationTemperature = refrigerationTemperature;
  }

  /**
   * This is the constructor for when we pass in the String file
   * we will split all the strings within the indices
   * We will set the first index as the Name, the Second index
   * since its a number, we will have to parse it and then setQuantity
   * the third is the price and we have to setPrice as a double, so we parse it
   * and then we set the refrigeration temperature as the last
   * 
   * @param inputLine
   */
  public Dairy(String inputLine) {
    String[] lines = inputLine.split(" ");
    setName(lines[1]);
    setQuantity(Integer.parseInt(lines[2]));
    setPrice(Double.parseDouble(lines[3]));
    this.refrigerationTemperature = Integer.parseInt(lines[4]);
  }

  /**
   * sets the refrigerationTemperature
   * 
   * @param temp
   */
  public void setRefrigerationTemperature(int temp) {
    refrigerationTemperature = temp;
  }

  /**
   * gets the refrigerationTemperature
   * 
   * @return
   */
  public int getRefrigerationTemperature() {
    return this.refrigerationTemperature;
  }

  /**
   * To string to return the one thing thats unique to this class
   */
  public String toString() {
    return "Temperature: " + getRefrigerationTemperature();
  }
}
