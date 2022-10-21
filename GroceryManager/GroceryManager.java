import java.util.*;
import java.io.*;

/**
 * Author: Tushar Ganta
 * CSS 143
 * Instructor: Tim Carslon
 */
public class GroceryManager {
  /**
   * We will have a Hashset for the restoocking list
   * while we will keep an ArrayList of the inventory;
   */
  private ArrayList<GroceryItem> inventory = new ArrayList<GroceryItem>();
  private HashSet<String> restockingList = new HashSet<String>();;

  /**
   * When we load the inventory, we will check if the file exists,
   * if not, then we throw an exception.
   * Else, while console has input, we will have the Next thing be the
   * type of Order, and then the next line will be the order inforamtion
   * If order is type Dairy, we will add it with type Dairy to the inventory
   * and same with Produce, and Meat.
   * 
   * @param fileName
   */
  public void loadInventory(String fileName) {
    Scanner console = null;
    try {
      console = new Scanner(new FileInputStream(fileName));
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    console.nextLine();
    while (console.hasNext()) {
      String orderType = console.next();
      String order = console.nextLine();
      // Dairy item
      if (orderType.equalsIgnoreCase("Dairy")) {
        inventory.add(new Dairy(order));
      }
      // Produce item
      if (orderType.equalsIgnoreCase("Produce")) {
        inventory.add(new Produce(order));
      }
      // Meat item
      if (orderType.equalsIgnoreCase("Meat")) {
        inventory.add(new Meat(order));
      }

    }
  }

  /**
   * This is the method which is processing orders. It acts as adding something to
   * order
   * and see if it is in stock. We will first go through all the items, in the
   * order,
   * and then we will go through the inventory. If the name is the same, we will
   * then check
   * the quantity. If the quantity is less than the items in the order, we will
   * add it to the
   * restock list and set that item to 0, and then print out saying that its out
   * else. We will add it the items to the order and deduct from the inventory
   * 
   * @param order
   * @throws GroceryException
   */
  public void processOrder(GroceryOrder<GroceryItem> order) throws GroceryException {
    for (GroceryItem items : order) {
      for (GroceryItem groceryItems : inventory) {
        if (items.getName().equalsIgnoreCase(groceryItems.getName())) {
          // if its less than what we have in order
          if (groceryItems.getQuantity() < items.getQuantity()) {
            restockingList.add(items.getName());
            items.setQuantity(0);
            System.out.println("Out of " + items.getName());
          } else {
            // deducting from inventory
            int orderAmount = items.getQuantity();
            groceryItems.setQuantity(groceryItems.getQuantity() - orderAmount);
          }
        }
      }
    }
  }

  /**
   * This is for finding the item in the inverntory
   * if its not there, we return null;
   * 
   * @param name
   * @return
   */
  public GroceryItem findItemByName(String name) {
    for (GroceryItem items : inventory)
      if (items.getName().equals(name)) {
        return items;
      }
    return null;
  }

  /**
   * here, we are checking if the list is in alphabetical order
   * we will first say its true so we can run through the loop,
   * the moment we enter, we set it to false so we know its not in oder.
   * We will compare the value of the item at index i and if the one to the right
   * is not greater (will return -1 if its not) we will do bubble sort and then
   * increase
   * the index.
   * Uses bubblesort
   */
  public void sortInventoryByName() {
    boolean itemSort = true;
    GroceryItem tempItem;
    int index = 1;
    while (itemSort) {
      itemSort = false;
      for (int i = 0; i < inventory.size() - index; i++) {
        if (inventory.get(i).compareTo(inventory.get(i + 1)) < 0) {
          tempItem = inventory.get(i + 1);
          inventory.set(i + 1, inventory.get(i));
          inventory.set(i, tempItem);
          itemSort = true;
        }
      }
      index++;
    }

  }

  /**
   * This is the method which will sort the inventory by price
   * We will have go through the set, and set the temp groceryItem
   * to what we got.
   * Uses insertionsort.
   */
  public void sortInventoryByPrice() {
    GroceryItem temp;
    for (int i = 1; i < inventory.size(); i++) {
      temp = inventory.get(i);
      int x = i - 1;
      while (x >= 0 && inventory.get(x).getPrice() > temp.getPrice()) {
        inventory.set(x + 1, inventory.get(x));
        x--;
      }
      inventory.set(x + 1, temp);
    }
  }

  /**
   * this is the method which will display the restocking List
   */
  public void displayRestockingList() {
    for (String items : restockingList) {
      System.out.println(items);
    }
  }

  /**
   * This is the items being displayed in the inventory.
   */
  public void displayInventory() {
    for (GroceryItem items : inventory) {
      System.out.printf(" %-21s %-21s %-21s", "Name: " + items.getName(),
          "Quantity: " + items.getQuantity(), "Price: " + items.getPrice());
      System.out.printf("%s%n", items.toString());
    }
  }

}
