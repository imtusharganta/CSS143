/**
 * This is the Queue class using Linked Lists
 * Tushar Ganta
 * CSS 143 Tim Carlson
 * 2/25/22
 * LinkedLists-Stacks-Queues
 */
public class Queue extends List {

  public static void main(String[] args) {
    Queue one = new Queue();
    Queue two = new Queue();
    try {
      one.enqueue(1);
      one.enqueue(2);
      one.enqueue(3);
      one.enqueue(4);
      one.enqueue(5);
      System.out.println("List of numbers 1 through 5: " + one);
      one.dequeue();
      System.out.println("List of numbers 2 through 5: " + one);
      one.dequeue();
      System.out.println("List of numbers 3 through 5: " + one);
      one.dequeue();
      System.out.println("List of numbers 4 through 5: " + one);
      one.dequeue();
      System.out.println("Prints 5: " + one);
      one.dequeue();
      System.out.println("List one is empty: " + one.isEmpty());
      System.out.println("List two is empty: " + two.isEmpty());
      two.enqueue('T');
      two.enqueue('U');
      two.enqueue('S');
      two.enqueue('H');
      two.enqueue('A');
      two.enqueue('R');
      System.out.println("My name is : " + two);
      two.dequeue();
      two.dequeue();
      two.enqueue('T');
      System.out.println("Jokes: " + two);
      System.out.println("Two is empty is false: " + two.isEmpty());
      two.dequeue();
      two.dequeue();
      two.dequeue();
      two.dequeue();
      two.dequeue();
      // should throw out of bounds;
      two.dequeue();

    } catch (LinkedListException e) {
      System.out.println(e.getMessage());
    }
  }

  /**
   * This is the enqueue class;
   * we will add an object and if its null, we throw an error, else we add it to
   * the end of the list.
   * 
   * @param obj
   * @throws LinkedListException
   */
  public void enqueue(Object obj) throws LinkedListException {
    if (obj == null) {
      throw new LinkedListException("Object cannot be null");
    } else {
      super.addToEnd(obj);
    }
  }

  /**
   * This is the dequeue. We will remove the object at Index 0 because that is the
   * FIRST one in.
   * 
   * @return
   * @throws LinkedListException
   */
  public Object dequeue() throws LinkedListException {
    return super.remove(0);
  }
}