import java.util.*;

/**
 * The purpose of this class is to basically store
 * the fractions in a list, and then we will use this list
 * to check how many times it appears using the FractionCounter object.
 */
public class ObjectList {
  /**
   * we set the number of elms to 0
   * because nothing is in the list yet
   */
  private int numElements = 0;
  private Object[] myShapes;

  /**
   * we just set the starting array size to 100
   * just to give it some breathing room.
   */
  public ObjectList() {
    myShapes = new Object[100];
  }

  /**
   * This method is adds objects to the array
   * we also use the numElements to indicate the elements
   * in the array.
   * If there are ever more elements that need parsing
   * we use Arrays.copyOf to make the same array bigger.
   * We copy the initial array data, then add it to the new one.
   * 
   * @param nx
   */
  public void add(Object nx) {
    if (myShapes.length == numElements) {
      myShapes = Arrays.copyOf(myShapes, numElements + 1);
    }
    myShapes[numElements++] = nx;
  }

  /**
   * This method is used to return the Object
   * at an index, which is techincially the fraction being counted.
   * 
   * @param index
   * @return
   */
  public Object get(int index) {
    return (FractionCounter) myShapes[index];
  }

  // returns elements
  public int getElements() {
    return numElements;
  }

  /**
   * This toString adds the elements and their counts
   * from the fractionCounter object. When we call toString
   * it will return everything in the list.
   */
  public String toString() {
    String retVal = "";
    for (int i = 0; i < numElements; i++) {
      retVal += myShapes[i] + "\n";
    }
    return retVal;
  }
}
