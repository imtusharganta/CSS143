/**
 * This is the class for the Stack
 */
public class Stack {
  /**
   * We create instance variables
   * one for the list that we will hold objects in
   * the other, elements, is used to count how many elements are in the list
   */
  private Object[] list;
  private int elements;

  /**
   * We start with elements at 0 and list size at 0.
   */
  public Stack() {
    list = new Object[0];
    elements = 0;
  }

  /**
   * This is when we add elements to the list
   * we want to resize it larger, then we add the element to the list
   * and increase the num of elements. We set it equal to the object
   * because when we pass it in, we are adding an object at the index number of
   * elements.
   * This adds it to the top of the list, following the (last-in) principle
   * 
   * @param obj
   */
  public void push(Object obj) {
    resizeListLarger();
    list[elements++] = obj;
  }

  /**
   * This method is used to remove an object in the list
   * If the list is not empty, we then set the temp object to the object
   * to the last elements and then we remove that element and we make
   * the list smaller, and we then return the object. This removes the first
   * element in the list at the last index
   * 
   * @return
   */
  public Object pop() {
    Object temp = null;
    if (!isEmpty()) {
      temp = list[elements - 1];
      elements--;
      resizeListSmaller();
    } else {
      System.out.println("No elements");
    }
    return temp;
  }

  /**
   * This is used to make the list larger
   * when we have the number of elements EQUAL to the length of the list.
   * This method is used to make the list larger
   * we first create a tempList(newList) to help us resize later. We then check
   * of the length of the list is equal to the number of elements. If it is
   * then we create a new List with one more than the list we have currently
   * We then copy all the elements into that tempList we created. After that
   * since our actual list for the object is empty and is an instance of the
   * class, we set its
   * size the the list thats holding the elements, and we transfer them all back.
   */

  public void resizeListLarger() {
    Object[] newList;
    if (list.length == elements) {
      newList = new Object[list.length + 1];
      for (int i = 0; i < list.length; i++) {
        newList[i] = list[i];
      }
      list = new Object[newList.length];
      for (int i = 0; i < newList.length; i++) {
        list[i] = newList[i];
      }
    }
  }

  /**
   * This is similar to the largerList method, but instead, we check if the list
   * has any extra spaces, basically if its length is longer than the number of
   * elements, it copies the elements into a Temporary List, and then shrinks the
   * array
   * then we make the original array the size of the new list and transfer
   * everything back
   * until we make it so that there are no extra spaces in the array.
   * 
   */

  public void resizeListSmaller() {
    Object[] newList;
    if (list.length > elements) {
      newList = new Object[list.length - 1];
      for (int i = 0; i < elements; i++) {
        newList[i] = list[i];
      }
      list = new Object[newList.length];
      for (int i = 0; i < elements; i++) {
        list[i] = newList[i];
      }
    }
  }

  /**
   * if there are 0 elements, then we return true,
   * else it is false;
   * 
   * @return
   */
  public boolean isEmpty() {
    if (elements != 0) {
      return false;
    }
    return true;
  }

  /**
   * this method is used to check if the object equals another object
   * we go through the number of elements in this list and we have to
   * cast the object to the type of list we have so we can compare elements
   * if the element in the object we passed AT that index equals the that object
   * then we return true;
   */
  public boolean equals(Object obj) {
    Stack listObj = (Stack) obj;
    boolean doesEqual = false;
    if (listObj.elements != elements) {
      return doesEqual;
    }
    for (int i = 0; i < elements; i++) {
      if (listObj.list[i] == list[i]) {
        doesEqual = true;
      } else {
        doesEqual = false;
      }
    }
    return doesEqual;
  }

  /**
   * the toString to return the elements in the array
   */
  public String toString() {
    String val = "";
    for (int i = 0; i < elements; i++) {
      val += list[i] + "\n";
    }
    return val;
  }
}
