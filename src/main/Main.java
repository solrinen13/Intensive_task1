import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List <Integer> numbers = new MyArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(8);
        numbers.add(4);
      // numbers.remove(3);
      // numbers.removeAll( List.of(1, 2, 8,4));
        numbers.sort(Comparator.naturalOrder());
        System.out.println(numbers.get(0));
        System.out.println(numbers.get(1));
        System.out.println(numbers.get(2));
        System.out.println(numbers.get(3));

       //numbers.sort(5 );
//        List <String> object = new MyArrayList<>();
//        object.add("Банан");
//        object.add("Банан1");
//        object.add("Банан2");
//        object.add("Банан3");
//        object.remove("Банан");
//        System.out.println(object.get(0));
        // System.out.println(numbers.size());



        // Методы - добавить элемент, получить элемент, удалить элемент, очистить всю коллекцию, отсортировать, остальное по желанию

    }
}