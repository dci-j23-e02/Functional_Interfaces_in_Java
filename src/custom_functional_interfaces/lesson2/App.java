package custom_functional_interfaces.lesson2;

public class App {

  public static void main(String[] args) {
    Calculator addition = Double :: sum;

    double result = addition.calculate(10, -20);
    System.out.println("Result: "+result);
    System.out.println("Is the reult positive? "+addition.isResultPositive(result));
  }
}
