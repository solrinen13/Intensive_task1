
import java.util.*;


public class MyArrayList<E> implements List<E> {

    private  int arrayGrow = 16;
    private Object[] array = new Object[arrayGrow];
    private int size = 0;


    public MyArrayList() {
    }

    public MyArrayList(List<E> asList) {
    }

    @Override
    public boolean add(E e) {
        if(size == array.length){
             grow(array.length + 1);
        }
        array[size++] = e;
        return true;
    }

    @Override
    public E get(int index) {
        return (E) array[index];
    }
    @Override
    public E remove(int index) {
        Object deleted = array[index];
        for (int i = 0; i < array.length; i++) {

            if (i != index ) {
                int newIndex = i < index ? i : i - 1;
                array[newIndex] = array[i];
            }
        }
        array = Arrays.copyOf(array, array.length-1);
        size--;
        return (E) deleted;
    }

    @Override
    public boolean remove(Object o) {
        boolean deleted = false;
        for(int i = size-1; i >= 0; i--){
            if(array[i].equals(o)){
                remove(i);
                deleted = true;
                break;
            }
        }
        return deleted;

    }

    /**
     *
     * @param c the {@code Comparator} used to compare list elements.
     *          A {@code null} value indicates that the elements'
     *          {@linkplain Comparable natural ordering} should be used
     */
    @Override
    public void sort(Comparator c) {
        Object[] tempoArr = Arrays.copyOf(array,size);
        Arrays.sort(tempoArr,c);
        array = tempoArr;
    }
    @Override
    public boolean removeAll(Collection c) {
        int deleted = 0;
        for(int i = size-1; i >= 0; i--){
            if(c.contains(array[i])){
                remove(i);
                deleted++;

            }
        }

        return deleted >= c.size();
    }

    /////////////////////////////////////////////
    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }





    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection c) {
        return false;
    }

    @Override
    public void clear() {

    }



    @Override
    public Object set(int index, Object element) {
        return null;
    }

    @Override
    public void add(int index, Object element) {

    }



    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator listIterator() {
        return null;
    }

    @Override
    public ListIterator listIterator(int index) {
        return null;
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }

    private Object[] grow(int minCapacity) {
        int oldCapacity = array.length;
        if(oldCapacity >= minCapacity){
            return array;
        }else{
            int newCapacity = oldCapacity + arrayGrow;
            array = Arrays.copyOf(array, newCapacity);
            return grow(minCapacity);
        }
    }

}
