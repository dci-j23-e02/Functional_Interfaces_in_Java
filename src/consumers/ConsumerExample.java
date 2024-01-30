package consumers;

import java.util.Scanner;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class ConsumerExample {

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    Order order = new Order();

    Consumer<Order> processOrder = o -> System.out.println(
        "Order processed. Total: $" +
        String.format(
            "%.2f", o.getTotalPrice()
        )
    );

    BiConsumer<Order,Double> applyDiscount = (o,d) -> {
      o.applyDiscount(d);
      System.out.println("Discount of $" + d + " applied. New total: $" + String.format( "%.2f", o.getTotalPrice()));
    };

  }
}
