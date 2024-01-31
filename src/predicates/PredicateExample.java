package predicates;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PredicateExample {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    NumberFilterService filterService = new NumberFilterService();

    List<Integer> numbers = new ArrayList<>();

    System.out.println("Enter numbers (type 'done' to finish):");
    while (scanner.hasNext()) {
      String input = scanner.next();
      if("done".equalsIgnoreCase(input)){
        break;
      }
      try {
        int number = Integer.parseInt(input);
        numbers.add(number);
      }catch (NumberFormatException e){
        System.out.println("Invalid number. Please enter a valid integer or type 'done'.");

      }
    }

    System.out.println("Enter the threshold for filtering even numbers");
    int threshold = scanner.nextInt();

    List<Integer> filteredNumbers = filterService.filterNumbers(numbers, threshold);
    System.out.println("Even numbers greater than "+threshold+": "+filteredNumbers);

    scanner.close();
  }
}
