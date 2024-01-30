package consumers;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class CheckoutService {
  private Consumer<Order> processOrder;
  private BiConsumer<Order,Double> applyDiscount;

  public CheckoutService(Consumer<Order> processOrder,
      BiConsumer<Order, Double> applyDiscount) {
    this.processOrder = processOrder;
    this.applyDiscount = applyDiscount;
  }


  public void checkout(Order o, double discount){
    if(discount > 0){
      applyDiscount.accept(o, discount);
    }

    processOrder.accept(o);
  }
}
