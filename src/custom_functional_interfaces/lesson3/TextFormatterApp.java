package custom_functional_interfaces.lesson3;

public class TextFormatterApp {

  public static void main(String[] args) {
    TextFormatter toUpperCaseFormatters = String :: toUpperCase;
    TextFormatter exclamationFormatters = text -> text+" !";
    TextFormatter questionFormatters = text -> text+" ?";


    // Over inner class
    TextFormatter underscoreFormatters = new TextFormatter() {
      @Override
      public String format(String text) {
        return text+" _";
      }
    };

    TextFormatter dotFormatters = new TextFormatter() {
      @Override
      public String format(String text) {
        return text+" .";
      }
    };

    String message = "Hello World";
    System.out.println(toUpperCaseFormatters.format(message));
    System.out.println(exclamationFormatters.format(message));
    System.out.println(questionFormatters.format(message));
    System.out.println(underscoreFormatters.format(message));


  }
}
