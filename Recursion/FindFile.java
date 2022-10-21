import java.util.*;
import java.io.*;

/**
 * Tushar Ganta
 * CSS 143
 * Tim Carlson
 * Recursion
 * This is the class which is used to find the file
 */
public class FindFile {

  /**
   * we will use a counter for the files
   * and we wull use an ArrayList to keep track of the files
   */
  private int fileCount;
  private ArrayList<String> files;

  /**
   * For the constructor, we set it equal to 0 for fileCount
   * and the files will be initialized to a new ArrayList
   */
  public FindFile() {
    fileCount = 0;
    files = new ArrayList<String>();
  }

  /**
   * This method is used to search the directory we are in
   * It will take in the target and the name of the directory
   * we are searching. We will first create a new File which will
   * take in the directory Name, so it converts the Directory to a file
   * it will then check if the file is a directory, if it isn't
   * then it will throw an Exception, else we will create an Array
   * to store all of the files in this directory. We will then go through the
   * files, and if the file name at that index equals the target
   * we will add it to the arrayList and increment filecount.
   * we increment because that keeps track of how many times it
   * has been found, else we will recurse through it.
   * 
   * @param target
   * @param dirName
   */
  public void directorySearch(String target, String dirName) {
    try {
      File f = new File(dirName);
      if (!(f.isDirectory())) {
        throw new IllegalArgumentException();
      } else {
        File[] listOfFiles = f.listFiles();
        for (int i = 0; i < listOfFiles.length; i++) {
          if (listOfFiles[i].getName().equals(target)) {
            files.add(listOfFiles[i].getName());
            fileCount++;
          } else {
            directorySearch(target, listOfFiles[i].getPath());
          }
        }
      }
    } catch (Exception e) {
    }
  }

  /**
   * return the count of the file
   * 
   * @return
   */
  public int getCount() {
    return fileCount;
  }

  /**
   * returns files.
   * 
   * @return
   */
  public ArrayList<String> getFiles() {
    return files;
  }
}
