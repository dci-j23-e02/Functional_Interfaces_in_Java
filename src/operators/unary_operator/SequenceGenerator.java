package operators.unary_operator;

import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

public class SequenceGenerator {
private UnaryOperator<Integer> incrementByStep; // Function<T,T> : 'T' is always the same
private BinaryOperator<Integer> add; // BiFunction<T,T,T> : 'T' is always the same

  public SequenceGenerator(int step) {
    this.incrementByStep = n -> n + step;
    this.add = Integer :: sum;
    //  this.add =  (x, y) -> Integer.sum(x,y);

  }

  public int generateAndSum(int start, int count){
    return Stream.iterate(start, incrementByStep)
        .limit(count)
        .reduce(0, add);
  }
}
