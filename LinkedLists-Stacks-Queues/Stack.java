/**
 * This is the Stack class using Linked Lists
 * Tushar Ganta
 * CSS 143 Tim Carlson
 * 2/25/22
 * LinkedLists-Stacks-Queues
 */

public class Stack extends List {

  public static void main(String[] args) {
    Stack one = new Stack();
    Stack two = new Stack();
    try {
      one.push('A');
      one.push('B');
      one.push('C');
      System.out.println("Expecting CBA, result of list is: " + one);
      one.pop();
      System.out.println("Expecting BA, result is: " + one);
      one.pop();
      System.out.println("Expecting A, result is: " + one);
      one.pop();
      System.out.println("Expecting empty stack, result is: " + one);
      System.out.println("Empty list check for one: " + one.isEmpty());
      two.push(1);
      two.push(2);
      two.push(3);
      two.push(4);
      two.push(5);
      two.push(6);
      two.push(7);
      two.push(8);
      two.push(9);
      two.push(10);
      System.out.println("numbers 10 through 1 : " + two);
      two.pop();
      two.pop();
      two.pop();
      two.pop();
      two.pop();
      two.pop();
      two.pop();
      two.pop();
      two.pop();
      two.pop();
      System.out.println("Empty list two: " + two);
      // should throw Out of Bounds error
      two.pop();
    } catch (LinkedListException e) {
      System.out.println(e.getMessage());
    }
  }

  /**
   * This is used to add the object at index 0
   * index 0 will be the top of our stack
   * if object is null we will throw an exception, else we will add it
   * 
   * @param obj
   * @throws LinkedListException
   */
  public void push(Object obj) throws LinkedListException {
    if (obj == null) {
      throw new LinkedListException("Data cannot be null");
    } else {
      super.insert(obj, 0);
    }
  }

  /**
   * This will remove the object at index 0, which is the top of our stack
   * if there is nothing, we wil throw an exception
   * 
   * @return
   * @throws LinkedListException
   */
  public Object pop() throws LinkedListException {
    return super.remove(0);
  }

}
