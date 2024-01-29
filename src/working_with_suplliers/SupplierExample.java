package working_with_suplliers;

import java.util.Random;
import java.util.function.Supplier;

public class SupplierExample {

  public static void main(String[] args) {

    Supplier<Integer> diceRoller = ()-> new Random().nextInt(6) +1;
    GameService game1 = new GameService(diceRoller);

    Player myPlayer = new Player("Harris", 4);
    game1.battle(myPlayer, "Zombie");
  }
}
