package aston.task1;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class ArrayListCustomTest {

	Integer[] array = { 11, 10, 25, 5, 100};
	String[] array2 = {"cat", "bear", "mouse"};
	StringComparator comparator = new StringComparator();
	
	private final ArrayListCustom<String> listOfStrings = new ArrayListCustom<String>(array2);
	private final ArrayListCustom<Integer> listOfInt = new ArrayListCustom<Integer>(array);
	
	
    /**
     * Проверяем, что метод get возвращает ожидаемое значение
     */
    @Test
    public void methodGetReturnedRightValue(){
        assertEquals("bear", listOfStrings.get(1));
    }
    /**
     * Проверяем, что метод get после добавления возвращает ожидаемое значение
     */
    @Test
    public void methodGetAfterAdd(){
    	listOfStrings.set(2, "dog");
        assertEquals("dog", listOfStrings.get(2));
        assertEquals(3, listOfStrings.size());
    }
    /**
     * Проверяем, что метод get после удаления возвращает ожидаемое значение
     */
    @Test
    public void methodGetAfterRemove(){
    	listOfStrings.remove(0);
        assertEquals("mouse", listOfStrings.get(1));
        assertEquals(2, listOfStrings.size());
    }
    /**
     * Проверяем, что после очистки коллекции ее размер
     * становится равным 0
     */
    @Test
    public void methodGetAfterRemoveAll(){
       listOfInt.removeAll();
       assertEquals(0, listOfInt.size());
    }
    /**
     * Проверяем сортировку коллекции
     */
    @Test
    public void sort() {
    	QuickSort.sort(listOfStrings);
    	assertEquals("[bear, cat, mouse]", Arrays.toString(listOfStrings.getItems()));
    	
    }
    @Test
    public void sort2() {
    	
    	QuickSort.sort(listOfStrings, comparator);
    	assertEquals("[cat, bear, mouse]", Arrays.toString(listOfStrings.getItems()));
    	
    }
    @Test
    public void sort3() {
    	QuickSort2.sort(listOfStrings);
    	assertEquals("[bear, cat, mouse]", Arrays.toString(listOfStrings.getItems()));
    	
    }
    @Test
    public void sort4() {
    	
    	QuickSort2.sort(listOfStrings, comparator);
    	assertEquals("[cat, bear, mouse]", Arrays.toString(listOfStrings.getItems()));
    	
    }
   
}
