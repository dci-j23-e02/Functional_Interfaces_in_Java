package working_with_suplliers;

import java.util.function.Supplier;
import java.util.stream.IntStream;

public class GameService {
private  final Supplier<Integer> diceRoller;

  public GameService(Supplier<Integer> diceRoller) {
    this.diceRoller = diceRoller;
  }

  public  void battle(Player p, String monsterName){
    System.out.println(p.getName()+" encounters a "+monsterName+" !");

    // Simulate battle rounds
    IntStream.range(1,4).forEach(
        round -> {
          System.out.println("Round "+round+":");
          int playerRoll = diceRoller.get();
          int monsterRoll = diceRoller.get();

          System.out.println(p.getName()+" rolls a "+ playerRoll);
          System.out.println(monsterName+" rolls a "+ monsterRoll);

          if (playerRoll > monsterRoll){
            System.out.println(p.getName() + " strikes the "+ monsterName+ " !");
          }else if(playerRoll < monsterRoll ){
            System.out.println(monsterName + " hits "+ p.getName()+ " for "+ (monsterRoll - playerRoll) + " damage!");
            p.takeDamage(monsterRoll - playerRoll);
          }else{
            System.out.println("The battle is even, no one takes damage.");
          }

          if(!p.isAlive()){
            System.out.println(p.getName()+" has been defeated!");
            return;
          }

        }
    );

    if(p.isAlive()){
      System.out.println(p.getName() + " has defeated the "+ monsterName+"!");
      return;
    }

  }
}
