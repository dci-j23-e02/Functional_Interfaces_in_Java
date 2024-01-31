package operators.binary_operator;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BinaryOperator;

public class ListMerger {
// Attribute
  private BinaryOperator<List<Integer>> mergeLists; // BiFunction<T,T,T>: Type is the same for the Arguments and the return value.

  public ListMerger() {
    this.mergeLists = (list1, list2) -> {
      /**
       * list1:[1,2,3] : 3 ( 0 to 2 ) add the sum of the elements
       *
       * list2: [10,20,30, 40, 50] : 5 ( 3 - 4 )  add only from list2
       *
       * resultList: [11, 22, 33, 40, 50]
       *
       * */

      List<Integer> resultList = new ArrayList<>();
      // decide the size of the returned list
      if(list1.size() > list2.size()){
        for (int i = 0; i < list2.size(); i++) {
          int element = list1.get(i) + list2.get(i);
          resultList.add(element);
        }
        for (int i = resultList.size(); i < list1.size(); i++) {
          resultList.add(list1.get(i));
        }
      }else{
        for (int i = 0; i < list1.size(); i++) {
          int element = list1.get(i) + list2.get(i);
          resultList.add(element);
        }
        for (int i = resultList.size(); i < list2.size(); i++) {
          resultList.add(list2.get(i));
        }
      }
       return  resultList;

    };

  }

  public  List<Integer> merge(List<Integer> list1, List<Integer> list2){
    return  mergeLists.apply(list1,list2 );
  }
}
