/**
 * This is the meat class extending a groceryItem
 */

public class Meat extends GroceryItem {
  // boolean variable to check if meat is ground or not
  private boolean isGround;

  /**
   * This is the constructor used for the Meat constructor
   * we will use super for the name quantity and price
   * and then set this isGround if the meat is ground or not
   * 
   * @param name
   * @param quantity
   * @param price
   * @param isOrganic
   */
  public Meat(String name, int quantity, double price, boolean isGround) {
    super(name, quantity, price);
    this.isGround = isGround;
  }

  /**
   * This is the construcor used when we are passing in the lines
   * we will split the first index with the name, second as the setQuantity
   * 2rd as the price and the last one as the boolean is.
   * 
   * @param inputLine
   */
  public Meat(String inputLine) {
    String[] lines = inputLine.split(" ");
    setName(lines[1]);
    setQuantity(Integer.parseInt(lines[2]));
    setPrice(Double.parseDouble(lines[3]));
    isGround = Boolean.parseBoolean(lines[4]);
  }

  /**
   * sets the meat if its ground
   * 
   * @param isGround
   */
  public void setIsGround(boolean isGround) {
    this.isGround = isGround;
  }

  /**
   * returns if meat is ground
   * 
   * @return
   */
  public boolean getIsGround() {
    return this.isGround;
  }

  /**
   * this toString will display whether meat is ground.
   */
  public String toString() {
    return "isGround: " + getIsGround();
  }
}
