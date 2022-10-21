import java.util.*;
import java.io.*;

/**
 * This is the class for the arraylist
 */
public class ArrayList {

  /**
   * We create instance variables
   * one for the list that we will hold objects in
   * the other, elements, is used to count how many elements are in the list
   */
  private Object[] list;
  private int elements;

  /**
   * Constructor for the ArrayList, Initialized to 100
   * and 0 elements
   */
  public ArrayList() {
    elements = 0;
    list = new Object[100];
  }

  /**
   * In this method, we will use it to insert an object at
   * a certain index. We will first check if the index even exists in the list.
   * if it doesn't then we will, say it is out of range.
   * else, while the number of elements equals the list length, we will increase
   * the size of the array. we then use a for loop to traverse through all the
   * elements
   * backwards UNTIL the index. Then we will shift all those elements one to the
   * right
   * and then insert the desired object and increment num of elements.
   * 
   * @param obj
   * @param index
   */
  public void insert(Object obj, int index) {
    if (index < 0 || index > elements) {
      System.out.println("Index out of range");
    } else {
      while (elements == list.length) {
        resizeListLarger();
      }
      // this is used to shift everything to the right after the index.
      for (int i = elements - 1; i >= index; i--) {
        list[i + 1] = list[i];
      }
      list[index] = obj;
      elements++;
    }
  }

  /**
   * this method is used so we can add the element at the end of the list
   * make the list larger, and increase the number of elements.
   */
  public void append(Object obj) {
    list[elements++] = obj;
    resizeListLarger();
  }

  /**
   * This is used to remove Objects at certain indexes.
   * We first check for a valid index in the list, if it isn't valid,
   * then we print an error message, else we hold the object at that index
   * and then we reduce the number of elements and resize the list to be one
   * smaller
   * we then return that object that we removed.
   * 
   * @param index
   * @return Object
   */
  public Object remove(int index) {
    Object temp = null;
    if (index < 0 || index > elements) {
      System.out.println("Index out of range");
    } else {
      temp = list[index];
      elements--;
      resizeListSmaller();
    }
    return temp;
  }

  /**
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
      // we resize the instance list here
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
      // the for loop goes until elements so that there are no extra spaces
      // we are traversing through.
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
   * This returns the elements in the array.
   * 
   * @return
   */
  public int size() {
    return elements;
  }

  /**
   * Checks if the list is empty
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
   * This is the method to get the index of an object.
   * and if the index we are at in the list equals the object
   * we return the index, else if we dont find it, return -1.
   */
  public int getIndexOf(Object obj) {
    for (int i = 0; i < elements; i++) {
      if (list[i].equals(obj)) {
        return i;
      }
    }
    return -1;
  }

  /**
   * This method is used to check if the list contains an object
   * we set a boolean value to false before because we do not know if it
   * contains or not. We traverse through the list and if at that index,
   * the object equals it, then we change the boolean to true and return.
   * 
   * @param obj
   * @return
   */
  public boolean contains(Object obj) {
    boolean doesContain = false;
    for (int i = 0; i < list.length; i++) {
      if (list[i].equals(obj)) {
        doesContain = true;
      }
    }
    return doesContain;
  }

  /**
   * this method is used to check if the object equals another object
   * we go through the number of elements in this list and we have to
   * cast the object to the type of list we have so we can compare elements
   * if the element in the object we passed AT that index equals the that object
   * then we return true;
   */
  public boolean equals(Object obj) {
    ArrayList listObj = (ArrayList) obj;
    boolean doesEqual = false;
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
   * This method is used to return the index the Object at that index
   * in the list.
   * 
   * @param index
   * @return
   */
  public Object get(int index) {
    if (index < 0 || index >= elements) {
      return ("Error");
    }
    return list[index];
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
