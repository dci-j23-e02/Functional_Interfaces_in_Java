package introduction;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FunctionExmple {

  public static void main(String[] args) {

    List<User> users = List.of(
      new User("Alice", "alice@example.com"),
      new User("Bob", "bob@example.com"),
      new User("Charlie", "charlie@example.com")
    );


    // A function to extract emails

    // Function<User,String> extractEmail = User :: getEmail;
    Function<User,String> extractEmail = user -> user.getEmail();


    // Example of using Function in Java:
    Map<String, Integer> nameMap = new HashMap<>();

          // In the below line the Function is used :
          // Integer value = nameMap.computeIfAbsent("Safwan", s -> s.length());
          Integer value = nameMap.computeIfAbsent("Safwan", String :: length);

          // System.out.println(value);
    // Function to create invitation message
    Function<User, String> createInvitation = user -> {
      String userName = user.getName();
      String message = "Dear "+userName+",\n You atre invited to our conference.";
      return message;
    };

    // Instance of EmailService
    EmailService es = new EmailService();

    // Combine the functions to send out invitations
    users.stream()
        .map(
            user -> {
              String email  = extractEmail.apply(user);
              String invitation = createInvitation.apply(user);
              es.sendEmail(email, invitation); // Use Email Service to send the email
              return  email;
            }
        )
        .collect(Collectors.toList());

    System.out.println("Invitations sent to all users.");
  }
}
