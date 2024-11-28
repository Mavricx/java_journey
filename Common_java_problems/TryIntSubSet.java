package Common_java_problems;
import java.util.*;

public class TryIntSubSet {
  public static List<Integer> li = new ArrayList<Integer>();

  public static void findSub(int arr[], int i, ArrayList<Integer> temp, ArrayList<ArrayList<Integer>> li) {
    li.add(new ArrayList<>(temp));//add newly formed temp combination into the list of array list
    for (int j = i; j < arr.length; j++) {
      temp.add(arr[j]);//add new element to the arraylist
      findSub(arr, j + 1, temp, li);//goes on and add new element until all elements are added 
      temp.remove(temp.size() - 1);//remove the last element from the arraylist to form a new unique element.
    }

  }

  public static void main(String[] args) {
    ArrayList<ArrayList<Integer>> li = new ArrayList<>();
    int arr[] = { 1, 5, 6, 7, 9 };
    findSub(arr, 0, new ArrayList<Integer>(), li);
    System.out.println(li);

  }
}
