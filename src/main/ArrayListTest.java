import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArrayListTest {

    public static void main(String[] args) {
        testAdd();
        testGet();
        testRemove();
        testSort();
    }

    private static void testAdd() {
        List<String> list = new MyArrayList<>();

        // Test adding elements
        list.add("Apple");
        list.add("Banana");
        list.add("Orange");

        // Verify the elements were added correctly
        System.out.println("Testing add method:");
        System.out.println("Expected: [Apple, Banana, Orange]");
        System.out.println("Actual: " + list);
        System.out.println("Result: " + (list.equals(Arrays.asList("Apple", "Banana", "Orange")) ? "Success" : "Failure"));
        System.out.println();
    }

    private static void testGet() {
        List<Integer> list = new MyArrayList<>(Arrays.asList(1, 2, 3, 4, 5));

        // Test getting elements
        int element1 = list.get(2);
        int element2 = list.get(4);

        // Verify the elements were retrieved correctly
        System.out.println("Testing get method:");
        System.out.println("Expected element at index 2: 3");
        System.out.println("Actual: " + element1);
        System.out.println("Result: " + (element1 == 3 ? "Success" : "Failure"));
        System.out.println();

        System.out.println("Expected element at index 4: 5");
        System.out.println("Actual: " + element2);
        System.out.println("Result: " + (element2 == 5 ? "Success" : "Failure"));
        System.out.println("////////////////////////////");
    }

    private static void testRemove() {
        List<String> list = new MyArrayList<>(Arrays.asList("Apple", "Banana", "Orange"));

        // Test removing elements
        boolean removed1 = list.remove("Banana");
        boolean removed2 = list.remove("Grape");

        // Verify the elements were removed correctly
        System.out.println("Testing remove method:");
        System.out.println("Expected: [Apple, Orange]");
        System.out.println("Actual: " + list);
        System.out.println("Result: " + (list.equals(Arrays.asList("Apple", "Orange")) ? "Success" : "Failure"));
        System.out.println();

        System.out.println("Expected result for removing 'Banana': true");
        System.out.println("Actual: " + removed1);
        System.out.println("Result: " + (removed1 ? "Success" : "Failure"));
        System.out.println();

        System.out.println("Expected result for removing 'Grape': false");
        System.out.println("Actual: " + removed2);
        System.out.println("Result: " + (!removed2 ? "Success" : "Failure"));
        System.out.println("////////////////////////////");
    }

    private static void testSort() {
        List<Integer> list = new MyArrayList<>(Arrays.asList(5, 2, 4, 1, 3));

        // Test sorting elements
        Collections.sort(list);

        // Verify the elements were sorted correctly
        System.out.println("Testing sort method:");
        System.out.println("Expected: [1, 2, 3, 4, 5]");
        System.out.println("Actual: " + list);
        System.out.println("Result: " + (list.equals(Arrays.asList(1, 2, 3, 4, 5)) ? "Success" : "Failure"));
        System.out.println("////////////////////////////");
    }
}
