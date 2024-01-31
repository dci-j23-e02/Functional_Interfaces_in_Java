package operators.unary_operator;

import java.util.Scanner;

public class UnaryOperatorExample {

  public static void main(String[] args) {
    /**
     * Explanation:
     * SequenceGenerator generator = new SequenceGenerator(3);

     * int sum = generator.generateAndSum(1,5); // 35
     * System.out.println(sum);

     *
     * The sequence will start at '1'
     * the step : 3
     * generated sequence : 1,4,7,10,13,....
     * however, we're interested in the first count'5' numbers:
     *  .limit(count: 5) : [1,4,7,10,13]
     *   .reduce(0, add) :
     *   0: is the starting value
     *   add : is the operation to apply
     *   it works as follows :
     *   0 + 1 = result: 1,
     *   'result: 1' + 4 = result: 5,
     *   'result: 5' + 7 = result: 12,
     *   'result: 12' + 10 = result: 22,
     *   'result: 22' + 13 = result: 35
     *
     * */

    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter the starting number:");
    int start = scanner.nextInt();

    System.out.println("Enter the step size:");
    int stepSize = scanner.nextInt();

    System.out.println("Enter the number of elements to generate:");
    int count = scanner.nextInt();

    SequenceGenerator generator = new SequenceGenerator(stepSize);
    int sum = generator.generateAndSum(start,count);

    System.out.println("The sum of the generated sequence:" + sum);

    scanner.close();

    /**
     *
     * Enter the starting number:
     * 1
     * Enter the step size:
     * 3
     * Enter the number of elements to generate:
     * 5
     * The sum of the generated sequence:35
     * */


  }
}
