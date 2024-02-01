package custom_functional_interfaces.lesson2;

@FunctionalInterface
public interface Calculator {

  // Abstract method : must be exactly one in a FunctionalInterface:
  double calculate(double num1, double num2);

  // don't overuse Default methods in a FunctionalInterface
  default boolean isResultPositive(double result){
    return result > 0;
  }

}
