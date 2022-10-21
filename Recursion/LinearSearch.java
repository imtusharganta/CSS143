/**
 * This is the class for linearSearch
 * Tushar Ganta
 * CSS 143 Tim Carlson
 * Linear Search
 */

public class LinearSearch extends SearchAlgorithm {
  // iterative search algorithm

  /**
   * For this, we are going to reset the count before we run the method
   * we will then go through the array and if we will incremement count
   * each time, and if the word at that index equals the word we are trying to
   * find
   * we will return that index. Once we are out of the loop, if the word is not
   * found,
   * then we will throw and ItemNotFoundException
   */
  public int iterativeSearch(String[] word, String wordToFind) throws ItemNotFoundException {
    resetCount();
    for (int index = 0; index < word.length; index++) {
      incrementCount();
      if (word[index].equals(wordToFind)) {
        return index;
      }
    }
    throw new ItemNotFoundException(" WORD NOT FOUND");
  }

  /**
   * This was problematic, it caused a stack Overflow
   * we will start the index at 0 and then use recursion to get the
   * index of the word through recursion.
   * 
   * @param word
   * @param wordToFind
   */
  @Override
  public int recursiveSearch(String[] word, String wordToFind) throws ItemNotFoundException {
    resetCount();
    int index = 0;
    if (word[index].equals(wordToFind)) {
      return index;
    } else {
      return recSearch(word, wordToFind, index++);
    }
  }

  /**
   * This is the helper recursive method, essentially we will use this in the
   * method above
   * what this will do is if the index is greater than the array, then we will
   * throw an exception, else we will keep going and try to search the array and
   * the index
   * if we find it, we will return the index, else, we will increment the index
   * and run the
   * method recursively.
   * 
   * 
   * @param word,       this is the array
   * @param wordToFind, target value
   * @return
   * @throws ItemNotFoundException
   */
  private int recSearch(String[] word, String wordToFind, int index) throws ItemNotFoundException {
    if (index >= word.length) {
      throw new ItemNotFoundException(" WORD NOT FOUND");
    } else {
      incrementCount();
      if (word[index].equals(wordToFind)) {
        return index;
      } else {
        return recSearch(word, wordToFind, index++);
      }
    }
  }
}
