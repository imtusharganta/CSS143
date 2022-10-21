/**
 * Tushar Ganta
 * Instructor: Tim Carlson
 * 3/5/22
 */

/**
 * This is class which will allow us to create objects that
 * representing an Account. It will extend ArrayLists
 */
public class PurchaseOrderAccount extends ArrayList implements Cloneable {
  /**
   * we will have this for the account name
   */
  private String name;

  /**
   * sets the name in the constructor for the account
   * 
   * @param name
   */
  public PurchaseOrderAccount(String name) {
    setName(name);
  }

  /**
   * setter for name;
   * 
   * @param name
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * return the name
   * 
   * @return
   */
  public String getName() {
    return this.name;
  }

  /**
   * This is going to override the append method in the arraylist
   * it will check if its an object of type order, if its not,
   */
  @Override
  public void append(Object obj) throws IllegalArgumentException {
    if (obj instanceof Order) {
      Order temp = (Order) obj;
      super.append(temp);
    } else {
      throw new IllegalArgumentException("Can't append");
    }
  }

  /**
   * inserts the object at index. first checks if it is an instance
   * if not, then we throw an exception, else we insert the obj at that index
   * 
   * @param obj
   * @param index
   * @throws IllegalArgumentException
   */
  public void insert(Order obj, int index) throws IllegalArgumentException {
    if (obj instanceof Order) {
      Order temp = (Order) obj;
      super.insert(temp, index);
    } else {
      throw new IllegalArgumentException("Can't insert");
    }
  }

  /**
   * This is the clone method for PurchaseOrderAccount
   * we will create a clone of the account
   * and we will go through the elements in the order
   * and we will remove the element at the list originally to avoid
   * any duplication, and then we will insert our object at the specified index
   * then we return the copy.
   */
  @Override
  public PurchaseOrderAccount clone() throws CloneNotSupportedException {
    PurchaseOrderAccount copy = (PurchaseOrderAccount) super.clone();
    for (int i = 0; i < size(); i++) {
      Order tempObj = (Order) get(i);
      copy.remove(i);
      copy.insert(tempObj, i);
    }
    return copy;
  }

}
