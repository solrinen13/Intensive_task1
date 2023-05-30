import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MyArrayListTest {


    private static List<String> list = new MyArrayList<>();
    private static List<String> list2 = new MyArrayList<>();
    @BeforeAll
    private static void initParam() {
        list.add("Apple");
        list.add("Banana");
        list.add("Orange");
        list2.add("Apple");
        list2.add("Banana");
        list2.add("Orange");
        System.out.println("Start testing");

    }

    @AfterAll
    private static void shouldDoAfterAll() {
        System.out.println("Finish testing");
    }

    @Test
    void shouldAdd() {
        System.out.println("Testing add method...");
        Assertions.assertEquals("Apple",list.get(0));
        Assertions.assertEquals("Banana",list.get(1));
        Assertions.assertEquals("Orange",list.get(2));
        System.out.print("Success!");
        System.out.println();
    }

    @Test
    void shouldGet() {
        System.out.println("Testing get method...");
        Assertions.assertEquals("Apple",list.get(0));
        Assertions.assertEquals("Banana",list.get(1));
        Assertions.assertEquals("Orange",list.get(2));
        Assertions.assertNull(list.get(3));
        System.out.print("Success!");
        System.out.println();
    }

    @Test
    void shouldRemoveByIndex() {
        System.out.println("Testing remove method...");
        list.remove(0);
        Assertions.assertEquals("Banana",list.get(0));
        Assertions.assertEquals("Orange",list.get(1));
        Assertions.assertNull(list.get(2));
        System.out.print("Success!");
        System.out.println();
    }
    @Test
    void shouldRemoveByObject() {
        System.out.println("Testing remove by object method...");
        list2.remove("Orange");
        Assertions.assertEquals("Apple",list2.get(0));
        Assertions.assertEquals("Banana",list2.get(1));
        Assertions.assertNull(list2.get(2));
        System.out.print("Success!");
        System.out.println();
    }
    @Test
    void shouldSort() {
        System.out.println("Testing sort method...");
        List<Integer> listSort = new MyArrayList<>();
        listSort.add(5);
        listSort.add(12);
        listSort.add(4);
        listSort.add(1);
        listSort.add(6);

        listSort.sort(Comparator.naturalOrder());
        Assertions.assertEquals(1,listSort.get(0));
        Assertions.assertEquals(4,listSort.get(1));
        Assertions.assertEquals(5,listSort.get(2));
        Assertions.assertEquals(6,listSort.get(3));
        Assertions.assertEquals(12,listSort.get(4));

        System.out.print("Success!");
        System.out.println();
    }
    @Test
    void shouldRemoveAll(){
        System.out.println("Testing removeAll method...");
        List<Integer> listRemove = new MyArrayList<>();
        listRemove.add(5);
        listRemove.add(12);
        listRemove.add(4);
        listRemove.add(1);
        listRemove.add(6);

        listRemove.removeAll(List.of(5,1,4,12,6));
        Assertions.assertNull(listRemove.get(0));
        Assertions.assertNull(listRemove.get(1));
        Assertions.assertNull(listRemove.get(2));
        Assertions.assertNull(listRemove.get(3));
        Assertions.assertNull(listRemove.get(4));

        System.out.print("Success!");
        System.out.println();
    }

    @Test
    void shouldQuickSort(){
        MyArrayList<Integer> listQuickSort = new MyArrayList<>();
        listQuickSort.add(5);
        listQuickSort.add(12);
        listQuickSort.add(4);
        listQuickSort.add(1);
        listQuickSort.add(6);
        listQuickSort.quickSort(Comparator.naturalOrder());
        Assertions.assertEquals(1,listQuickSort.get(0));
        Assertions.assertEquals(4,listQuickSort.get(1));
        Assertions.assertEquals(5,listQuickSort.get(2));
        Assertions.assertEquals(6,listQuickSort.get(3));
        Assertions.assertEquals(12,listQuickSort.get(4));
    }
}
