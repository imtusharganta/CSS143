
/**
 * This is the Produce class, which extends the GroceryItem
 */
public class Produce extends GroceryItem {
  /**
   * variable used to check if its organic or not
   */
  private boolean isOrganic;

  /**
   * This is the constructor used for the Produce constructor
   * we will use super for the name quantity and price
   * and then set this organic to the organcic
   * 
   * @param name
   * @param quantity
   * @param price
   * @param isOrganic
   */
  public Produce(String name, int quantity, double price, boolean isOrganic) {
    super(name, quantity, price);
    this.isOrganic = isOrganic;
  }

  /**
   * This is the construcor used when we are passing in the lines
   * we will split the first index with the name, second as the setQuantity
   * 2rd as the price and the last one as the boolean is
   * 
   * @param inputLine
   */
  public Produce(String inputLine) {
    String[] lines = inputLine.split(" ");
    setName(lines[1]);
    setQuantity(Integer.parseInt(lines[2]));
    setPrice(Double.parseDouble(lines[3]));
    this.isOrganic = Boolean.parseBoolean(lines[4]);
  }

  /**
   * This sets the organic
   * 
   * @param isOrganic
   */
  public void setOrganic(boolean isOrganic) {
    this.isOrganic = isOrganic;
  }

  /**
   * This returns whether its organic or not
   * 
   * @return
   */
  public boolean getOrganic() {
    return this.isOrganic;
  }

  /**
   * ToString to display organic or not.
   */
  public String toString() {
    return "Organic: " + getOrganic();
  }
}
