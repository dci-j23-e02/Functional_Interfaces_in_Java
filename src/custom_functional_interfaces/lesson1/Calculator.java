package custom_functional_interfaces.lesson1;



@FunctionalInterface
public interface Calculator<T> {
   double calculate (double num1, double num2);
}
