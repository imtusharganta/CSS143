/**
 * This is the class for the Binary Search
 * Tushar Ganta
 * CSS 143 Tim Carslon
 * BinarySearch
 */

public class BinarySearch extends SearchAlgorithm {

  /**
   * This method searches through the array without the use of recursion
   * We will always reset count at the beginning
   * and we will start the left index at index 0 while the right index to the last
   * one
   * and the middle to the middle of both. If the target is in the middle, then we
   * return that index
   * if it is lower than the the middle, we will go up one index on the left,
   * if it is higher then, we will go subtract from the right index by 1.
   */
  @Override
  public int iterativeSearch(String[] words, String wordToFind) throws ItemNotFoundException {
    resetCount();
    int leftIndex = 0;
    int rightIndex = words.length - 1;
    int middle = words.length / 2;

    // while we are still in the bounds
    while (rightIndex >= leftIndex) {
      incrementCount();
      middle = (rightIndex + leftIndex) / 2;
      if (words[middle].equals(wordToFind)) {
        return middle;
      } else if (words[middle].compareTo(wordToFind) < 0) {
        leftIndex = middle + 1;
      } else {
        // basically refers as if (words[middle].compareTo(wordToFind) > 0)
        rightIndex = middle - 1;
      }
    }
    throw new ItemNotFoundException(" WORD NOT FOUND");
  }

  /**
   * helper recursive method which will call the recursion
   */
  @Override
  public int recursiveSearch(String[] words, String wordToFind) throws ItemNotFoundException {
    resetCount();
    int leftIndex = 0;
    int rightIndex = words.length - 1;
    return recSearch(words, wordToFind, leftIndex, rightIndex);
  }

  /**
   * In this method, we will increment the count each time we go through the
   * recursion
   * if the word in the middle of the two indexes at the beginning is equal to the
   * word
   * we return it, else if the word we get from the middle is alphabetically less,
   * we
   * will recurse through and add to the left index so we can find it, else if it
   * is greater
   * than the middle value, then we will subtract one from the right Index and we
   * will continue the search
   * if the word is not found, we will throw an ItemNotFoundException
   * 
   * @param words
   * @param wordToFind
   * @param leftIndex
   * @param rightIndex
   * @return
   * @throws ItemNotFoundException
   */
  private int recSearch(String[] words, String wordToFind, int leftIndex, int rightIndex) throws ItemNotFoundException {
    if (leftIndex <= rightIndex) {
      incrementCount();
      int middle = (rightIndex + leftIndex) / 2;
      if (words[middle].equals(wordToFind)) {
        return middle;
      } else if (words[middle].compareTo(wordToFind) < 0) {
        return recSearch(words, wordToFind, middle + 1, rightIndex);
      } else {
        // basically refers as if (words[middle].compareTo(wordToFind) > 0)
        return recSearch(words, wordToFind, leftIndex, middle - 1);
      }
    } else {
      throw new ItemNotFoundException(" WORD NOT FOUND");
    }
  }
}
