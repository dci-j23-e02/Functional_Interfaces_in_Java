package operators.binary_operator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    ListMerger listMerger = new ListMerger();

    System.out.println("Enter the first list of integers (comma-separated):");
    List<Integer> list1 = readList(scanner);
    System.out.println("list1: "+list1);

    System.out.println("Enter the second list of integers (comma-separated):");
    List<Integer> list2 = readList(scanner);
    System.out.println("list2: "+list2);

    List<Integer> mergedList = listMerger.merge(list1, list2);

    System.out.println("Merged list:"+ mergedList);

    scanner.close();
  }

  private static List<Integer> readList(Scanner scanner) {
    String[] tokens = scanner.nextLine().split(","); // "1 , 2 , 3 , 4 " -> ["1 "," 2 "," 3 "," 4 "]
    List<Integer> list = new ArrayList<>();

    // ["1 "," 2 "," 3 "," 4 "]
    for (String token: tokens) {
      // token.trim() // "1 " -> "1"
      // token.trim() // " 2 " -> "2"
      // token.trim() // " 3 " -> "3"
      // token.trim() // " 4 " -> "4"

     try {
       list.add(Integer.parseInt( token.trim()));
     }catch (NumberFormatException e){
       System.out.println("Invalid input "+ token+" is not an integer.");
     }
    }
    return list;
  }
}
