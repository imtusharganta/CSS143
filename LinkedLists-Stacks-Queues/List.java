import java.util.LinkedList;

/**
 * This is the List class
 * Tushar Ganta
 * CSS 143, Tim Carlson
 * 2/25/2022
 * LinkedList, Stack, Queues
 */

public class List {

  /**
   * Main method for List
   * tests:
   * insert
   * addToEnd
   * remove
   * size
   * indexOf
   */
  public static void main(String[] args) {
    List empty = new List();
    List one = new List();
    List multiple = new List();
    List test1 = new List();
    try {
      one.insert(5, 0);
      multiple.insert(10, 0);
      multiple.insert(20, 0);
      multiple.insert(30, 0);
      test1.addToEnd('T');
      test1.addToEnd('U');
      test1.addToEnd('S');
      test1.addToEnd('H');
      test1.addToEnd('A');
      test1.addToEnd('R');
      System.out.println("Empty:" + empty);
      System.out.println("One:" + one);
      System.out.println("Multiple:" + multiple);
      System.out.println("My name is " + test1 + " and my size is " + test1.size());
      System.out.println("T index is: " + test1.indexOf('T'));
      System.out.println("U index is: " + test1.indexOf('U'));
      System.out.println("S index is: " + test1.indexOf('S'));
      System.out.println("H index is: " + test1.indexOf('H'));
      one.remove(0);
      multiple.remove(1);
      System.out.println("Expecting R, result: " + test1.remove(5));
      System.out.println("Expecting A, result: " + test1.remove(4));
      System.out.println("Expecting T, result: " + test1.remove(0));
      System.out.println("One (upon remove 1): " + one);
      System.out.println("Multiple (upon remove): " + multiple);
      System.out.println("TUSHAR (upon remove TAR): " + test1);
      System.out.println("USH's size is now: " + test1.size());
      one.insert(600, 0);
      one.insert(500, 0);
      one.insert(400, 0);
      one.insert(300, 0);
      one.insert(200, 0);
      one.insert(100, 0);
      multiple.insert(400, 2);
      System.out.println("One (on insert at 1):" + one);
      System.out.println("Multiple(on insert at 2):" + multiple);
      // test error
      empty.remove(3);
    } catch (LinkedListException e) {
      System.out.println(e.getMessage());
    }
  }

  /**
   * This is the inner node class we will have
   */
  private class Node {
    /**
     * One of our variables will be for the data, while our Node
     * is used for the next data point we will point to.
     */
    private Object data;
    private Node next;

    /**
     * sets everything to null;
     */
    private Node() {
      this.data = null;
      this.next = null;
    }

    /**
     * Constructor which will set the data of the Node, and what it will point to.
     * 
     * @param data
     * @param next
     * @throws LinkedListException
     */
    private Node(Object data, Node next) throws LinkedListException {
      this.data = data;
      this.next = next;
    }

    /**
     * Constructor which is used to just create the Node and its data
     * points to nothing yet.
     * 
     * @param data
     * @throws LinkedListException
     */
    private Node(Object data) throws LinkedListException {
      this.data = data;
      this.next = null;
    }

    /**
     * Used to set the data of a Node
     * 
     * @param data
     * @throws LinkedListException
     */
    private void setData(Object data) throws LinkedListException {
      if (data == null) {
        throw new LinkedListException("data is null");
      } else {
        this.data = data;
      }
    }
  }

  private Node head;

  /**
   * if the head does not equal anything
   * that means theres nothing at the start of the list
   * so it means its empty.
   * 
   * @return
   */
  public boolean isEmpty() {
    if (head == null) {
      return true;
    }
    return false;
  }

  /**
   * Throw exception if conditions for proper insert aren't met.
   * This is the method which will insert a node at a certain index
   * we will first check if THIS list is empty. If it is, we will insert
   * a new Node with the data and set it as the head, else if the head points
   * to nothing, then we will insert this node after head, and say head.next
   * else if the head is set and we have a valid index. We will create a temp node
   * for traversal, and we will have an index holder variable i. while i is less
   * than
   * the index, we will keep moving forward and increment i. Right before it
   * reaches the
   * index, it will leave the loop and we will create a new Node with the data we
   * want to insert
   * and this will also point to node the previous node would have pointed to.
   * then we
   * set the old nodes "next" to the node we inserted.
   * 
   * @param data  the data we will pass into the Node
   * @param index the index where we want to insert this node with the data
   * @throws LinkedListException
   */
  public void insert(Object data, int index) throws LinkedListException {
    if (data == null) {
      throw new IllegalArgumentException("No data");
    }
    if (this.isEmpty()) {
      head = new Node(data);
    } else if (head.next == null) {
      Node tempNode = head;
      head = new Node(data, head.next);
      head.next = tempNode;
    } else if (index == 0) {
      head = new Node(data, head);
    } else if (index <= this.size() && this.size() > 0) {
      Node current = head;
      int i = 1;
      while (i < index) {
        current = current.next;
        i++;
      }
      // current.next = new Node(data);
      if (i == index) {
        Node tempNode = current.next;
        // creates a Node with data and where it is pointing to next
        Node newNode = new Node(data, tempNode);
        current.next = newNode;
      }
    } else if (index < 0 || index > this.size()) {
      throw new IllegalArgumentException("Index out of Bounds");
    }
  }

  /**
   * This is the method which will remove an Object at the specified index
   * we will set our return object to null and first check through bound
   * exceptions
   * and we will set our traversal node to null. If index = 0, then we will set
   * that node
   * to our object. else we will keep checking until we get to one before the
   * index, and
   * we will leave that loop and set the newNode to Object that is stored in the
   * next node.
   * We will delete that node and return the Node which was used to store the
   * information.
   */
  public Object remove(int index) throws LinkedListException {
    Object tempObj = null;
    Node current = head;
    if (index < 0 || index >= this.size()) {
      throw new LinkedListException("Index out of bounds");
    } else {
      // if 0, then return
      if (index == 0) {
        Node temp = head;
        head = head.next;
        tempObj = temp.data;
        return tempObj;
      }
      if (index < this.size() && index > 0) {
        int i = 0;
        while (i < index - 1) {
          i++;
          current = current.next;
        }
        // get data of the next node
        tempObj = current.next.data;
        current.next = current.next.next;
        return tempObj;
      }
    }
    return tempObj;
  }

  /**
   * This method is used the get the size of the list
   * If head is null, it will return 0, otherwise, we will use a traversal node
   * to keep checking the list. Once we exit the loop, since there is an extra
   * node remaining
   * since we dont count the last node while in the loop, we increment once more
   * and return count;
   */
  public int size() {
    int count = 0;
    if (head == null) {
      return 0;
    } else {
      Node current = head;
      while (current.next != null) {
        count++;
        current = current.next;
      }
      current = current.next;
      count++;
    }
    return count;
  }

  /**
   * The To String method
   */
  public String toString() {
    String str = "[";
    Node current = head;
    while (current != null) {
      str += " " + current.data + " ";
      current = current.next;
    }
    str += "]";
    return str;
  }

  /**
   * This method is used to return the index at which something exists
   * if it does not exist, we return -1.
   */
  public int indexOf(Object target) {
    int count = 0;
    Node current = head;
    while (current != null) {
      if (current.data == target) {
        return count;
      }
      current = current.next;
      count++;
    }
    return -1;
  }

  /**
   * This method is used to add an object to the end of a list
   * we first check if its a valid object and valid index, if it is
   * then we traverse through the list, and once we reach the node where
   * current.next is null
   * we exit the loop, and we set it to the object we want to insert at the end.
   * 
   * @param obj
   * @throws LinkedListException
   */
  public void addToEnd(Object obj) throws LinkedListException {
    if (obj == null) {
      throw new LinkedListException("Null Object");
    } else if (this.size() == 0) {
      head = new Node(obj);
    } else {
      Node current = head;
      while (current.next != null) {
        current = current.next;
      }
      current.next = new Node(obj);
    }
  }

}