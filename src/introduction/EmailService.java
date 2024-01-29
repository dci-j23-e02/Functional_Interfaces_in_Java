package introduction;

public class EmailService {
// In a real application, we would have code here to send emails.
  // This is just a simulation

  public void sendEmail(String to, String message){
    System.out.println("Sending email to: "+ to);
    System.out.println(message);
    System.out.println("Email sent successfully!\n");
  }
}
