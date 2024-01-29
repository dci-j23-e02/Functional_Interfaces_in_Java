package introduction;

import java.util.List;
import java.util.function.Function;

public class FunctionExmple {

  public static void main(String[] args) {

    List<User> users = List.of(
      new User("Alice", "alice@example.com"),
      new User("Bob", "bob@example.com"),
      new User("Charlie", "charlie@example.com")
    );

    Function<String,String> printNames ;
  }
}
