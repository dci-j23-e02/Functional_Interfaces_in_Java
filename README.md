# Course: Java Functional Programming with Built-in Functional Interfaces

## Lesson 1: Introduction to Functional Interfaces

### Theory Explanation

In Java, a functional interface is an interface that contains exactly one abstract method. These interfaces are used as the basis for lambda expressions in functional programming. A lambda expression is a short block of code which takes in parameters and returns a value. Lambda expressions are similar to methods, but they do not need a name and they can be implemented right in the body of a method.

The `@FunctionalInterface` annotation is used to indicate that an interface is intended to be a functional interface. While it's not mandatory to use this annotation, it's a good practice because it allows the compiler to generate an error if the interface does not meet the criteria (exactly one abstract method).

Java 8 introduced several built-in functional interfaces in the `java.util.function` package, such as `Supplier`, `Consumer`, `Predicate`, `Function`, and their variations to support primitive types and different arities (number of arguments).

### Live Coding Example

Let's start with a simple `Function` example. We'll create a function that takes a string and returns its length.

```java
import java.util.function.Function;
import java.util.List;
import java.util.stream.Collectors;

class User {
  private String name;
  private String email;

  public User(String name, String email) {
    this.name = name;
    this.email = email;
  }

  public String getEmail() {
    return email;
  }
}

public class FunctionExample {
  public static void main(String[] args) {
    List<User> users = List.of(
        new User("Alice", "alice@example.com"),
        new User("Bob", "bob@example.com"),
        new User("Charlie", "charlie@example.com")
    );

    Function<User, String> extractEmail = User::getEmail;
    List<String> emails = users.stream()
        .map(extractEmail)
        .collect(Collectors.toList());

    System.out.println("Emails: " + emails);
  }
}
```

### Practice Exercise

Create a `Function` that converts a string into its uppercase form and then use it to convert a list of strings.

## Lesson 2: Working with Suppliers

### Theory Explanation

A `Supplier` is a functional interface that does not take any arguments but returns a value. It's often used for lazy generation of values, which means the value is created only when it's needed.

### Live Coding Example

Let's create a `Supplier` that generates a random number.

```java
import java.util.function.Supplier;
import java.util.Random;
import java.util.stream.Stream;

public class SupplierExample {
  public static void main(String[] args) {
    Supplier<Integer> diceRoller = () -> new Random().nextInt(6) + 1;

    Stream.generate(diceRoller)
        .limit(10) // Roll the dice 10 times
        .forEach(roll -> System.out.println("You rolled a: " + roll));
  }
}
```

### Practice Exercise

Create a `Supplier` that returns the current date-time. Then, use it to print the current date-time to the console.

## Lesson 3: Utilizing Consumers and BiConsumers

### Theory Explanation

A `Consumer` is a functional interface that accepts a single input argument and returns no result. It represents an operation to be performed on a single argument. A `BiConsumer` does the same but with two arguments.

### Live Coding Example

Let's create a `Consumer` that prints a message with a user's name.

```java
import java.util.function.Consumer;
import java.util.function.BiConsumer;

class Order {
  private String item;
  private double price;

  public Order(String item, double price) {
    this.item = item;
    this.price = price;
  }

  public void applyDiscount(double discount) {
    this.price -= discount;
  }

  public String getItem() {
    return item;
  }

  public double getPrice() {
    return price;
  }
}

public class ConsumerExample {
  public static void main(String[] args) {
    Consumer<Order> processOrder = order ->
        System.out.println("Order for " + order.getItem() + " processed. Total: $" + order.getPrice());

    BiConsumer<Order, Double> applyDiscount = (order, discount) -> {
      order.applyDiscount(discount);
      System.out.println("Discount applied! New price for " + order.getItem() + ": $" + order.getPrice());
    };

    Order myOrder = new Order("Java Programming Book", 29.99);
    applyDiscount.accept(myOrder, 5.00); // Apply a $5 discount
    processOrder.accept(myOrder); // Process the order
  }
}
```

### Practice Exercise

Create a `BiConsumer` that takes two integers and prints their sum. Then, use it to print the sum of two numbers.

## Lesson 4: Predicates and BiPredicates

### Theory Explanation

A `Predicate` is a functional interface that represents a boolean-valued function of one argument. It is often used for filtering or matching. A `BiPredicate` is the same but for two arguments.

### Live Coding Example

Let's create a `Predicate` that checks if a number is even.

```java
import java.util.function.Predicate;
import java.util.function.BiPredicate;
import java.util.List;
import java.util.stream.Collectors;

public class PredicateExample {
  public static void main(String[] args) {
    Predicate<Integer> isEven = n -> n % 2 == 0;
    BiPredicate<Integer, Integer> isEvenAndGreaterThan = (n, threshold) -> isEven.test(n) && n > threshold;

    List<Integer> numbers = List.of(1, 4, 8, 12, 15, 16, 20);
    List<Integer> filteredNumbers = numbers.stream()
        .filter(n -> isEvenAndGreaterThan.test(n, 10))
        .collect(Collectors.toList());

    System.out.println("Even numbers greater than 10: " + filteredNumbers);
  }
}
```

### Practice Exercise

Create a `BiPredicate` that checks if the sum of two integers is greater than 100. Then, use it to check a pair of numbers.

## Lesson 5: Operators

### Theory Explanation

Operators are special cases of functions that receive and return the same type of value. `UnaryOperator` is a single argument operator, and `BinaryOperator` is a two-argument operator.

### Live Coding Example

Let's create a `UnaryOperator` that squares an integer.

```java
import java.util.function.UnaryOperator;
import java.util.function.BinaryOperator;
import java.util.stream.Stream;

public class UnaryOperatorExample {
  public static void main(String[] args) {
    UnaryOperator<Integer> increment = n -> n + 1;
    BinaryOperator<Integer> add = Integer::sum;

    // Generate a sequence of numbers starting from 1
    Stream<Integer> numbers = Stream.iterate(1, increment).limit(10);

    // Calculate the sum of the first 10 positive integers
    int sum = numbers.reduce(0, add);
    System.out.println("Sum of the first 10 positive integers: " + sum);
  }
}
```

### Practice Exercise

Create a `BinaryOperator` that concatenates two strings and then use it to concatenate two given strings.

## Conclusion

These lessons have introduced you to the concept of functional interfaces in Java and how to use the built-in functional interfaces provided by the Java API.
By completing the practice exercises, you should now have a good understanding of how to implement and use `Supplier`, `Consumer`, `Predicate`, `Function`, and `Operator` interfaces in your Java programs. Remember to always use the `@FunctionalInterface` annotation to clearly communicate the purpose of your custom functional interfaces.