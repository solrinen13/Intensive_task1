
import java.util.*;


public class MyArrayList<E> implements List<E> {

    private  int arrayGrow = 16;
    private Object[] array = new Object[arrayGrow];
    private int size = 0;


    public MyArrayList() {
    }

    public MyArrayList(List<E> asList) {
    }

    /**
     *Adds the specified element to the end of this list.
     * Lists that support this operation may impose restrictions on what elements can be added to the list.
     * You must specify which objects or data types should be included in the list.
     * Initially, the size of the list is 16, when filled, it increases by another 16.
     * @param e element whose presence in this collection is to be ensured
     * @return will return true if the value was added successfully
     */
    @Override
    public boolean add(E e) {

        if(size == array.length){
             grow(array.length + 1);
        }
        array[size++] = e;
        Object added = array[size];
        return added != null;
    }

    /**
     * Finds an element from an array by index
     * @param index index of the element to return
     * @return the value you are looking for
     */
    @Override
    public E get(int index) {
        return (E) array[index];
    }

    /**
     *Removes, by index, the specified array element, if present.
     * Copies the remaining values into a new array, decreasing the length by one and preserving the order
     * @param index the index of the element to be removed
     * @return removed value from array
     */
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

    /**
     *Removes the first occurrence of the specified element from this list, starting at the end if present.
     * If this list does not contain an element, it remains unchanged. Removes the element with the highest index i like this.
     * Copies the remaining values into a new array, decreasing the length by one and preserving the order
     * @param o element to be removed from this list, if present
     * @return true if this list contains the specified element
     */
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
     *Performs a sort using the supplied comparator.
     * Overwrites array values with sorted ones.
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

    /**
     * Removes all values in the list and reduces the length of the array by the number of removals.
     * @param c collection containing elements to be removed from this list
     * @return will return true if the count of the number of values removed is equal to or greater than the length of the list.
     */
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

    /**
     * Performs a quick sort using the supplied comparator.
     * Overwrites array values with sorted ones.
     * @param c the {@code Comparator} used to compare list elements
     */
    public void quickSort(Comparator<E> c) {
        E[] tempoArr = (E[]) Arrays.copyOf(array,size);
        array = quickSort(tempoArr,c);
    }
    private E[] quickSort(E[] e, Comparator<E> c ){

        if ( e.length == 0){
            return null;
        }
        if(e.length == 1){
            return e;
        }

        int low = 0;
        int high = e.length - 1;
        int middle = low + (high - low) / 2;
        E opora = e[middle];
        int i = low, j = high;
        while (i <= j) {
            while (c.compare(e[i], opora) <= 0 ) {
                i++;
            }
            while (c.compare(e[j], opora) >= 0) {
                j--;
            }
            if (i <= j) {
                E temp = e[i];
                e[i] = e[j];
                e[j] = temp;
                i++;
                j--;
            }
        }
        E[] left = (E[]) new Object[]{};
        E[] right = (E[]) new Object[]{};
        if (low < j) {
            left = quickSort(Arrays.copyOfRange (e, low, j),c);
        }
        if (high > i) {
            right = quickSort(Arrays.copyOfRange (e, i, high),c);
        }
        E[] result = (E[]) new Object[left.length + right.length + 1];
        System.arraycopy(left, 0, result,0 , left.length);
        result[left.length] = opora;
        System.arraycopy(right,0, result,left.length + 1,right.length);
        return result;
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
