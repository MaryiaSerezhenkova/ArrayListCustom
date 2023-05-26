package aston.task1;

//3.	Реализовать свой ArrayList (не потокобезопасный Методы - добавить элемент, добавить элемент по индексу,
//получить элемент, удалить элемент, очистить всю коллекцию, отсортировать, остальное по желанию
//4.	Реализовать алгоритм quicksort для реализованной вами реализации ArrayList. Ссылка на отличное описание 
//работы алгоритма. Ваш QuickSort должен принимать ArrayList любого типа и сортировать его. 
//Использовать: ○ Java generics ○ Comparable, Comparator 
//5.	Документировать код. Что, зачем и как  Все классы и интерфейсы должны быть задокументированы на уровне 
//класса (class-level javadoc) Все публичные методы ваших реализаций должны содержать javadoc  
//Документация должна быть в полном объёме и представлять исчерпывающее и интуитивно понятное руководство пользования
//вашим кодом для другого разработчика 
//6.	Все части кода должны быть покрыты Unit тестами

public class ArrayListCustom<T> {

	private T[] items;
	private int size;

	/**
	 * Создает пустую коллекцию размером 10 по умолчанию
	 */

	@SuppressWarnings("unchecked")
	public ArrayListCustom() {
		super();
		items = (T[]) new Object[10];
	}

	/**
	 * Создает коллекцию с заданным начальным размером
	 * 
	 * @param initCap размер коллекции при инициализации
	 * @throws IllegalArgumentException будет выброшено при попытке инициализировать
	 *                                  коллекцию размером меньше 1
	 */
	@SuppressWarnings("unchecked")
	public ArrayListCustom(int initCap) {
		super();
		if (initCap < 1) {
			throw new IllegalArgumentException("Размер коллекции не может быть меньше единицы");
		}
		items = (T[]) new Object[initCap];
	}

	/**
	 * Создает коллекцию из заданного массива
	 * 
	 * @param items передаваемый массив размер коллекции при инициализации будет
	 *              равен длине массива
	 */
	public ArrayListCustom(T[] items) {
		super();
		this.items = items;
		size = items.length;
	}

	private void growth() {
		@SuppressWarnings("unchecked")
		T[] temp = (T[]) new Object[2 * items.length + 1];
		System.arraycopy(items, 0, temp, 0, items.length);
		items = temp;
	}

	/**
	 * Добавление элемента в конец коллекции
	 * 
	 * @param item добавляемый в коллекцию элемент
	 */
	public void add(T item) {
		if (size >= items.length) {
			growth();
		}
		items[size++] = item;
	}

	/**
	 * Удаление элемента по заданному индексу
	 * 
	 * @param index индекс удаляемого элемента
	 * @throws IndexOutOfBoundsException, если элемента с таким index не существует.
	 */
	public void remove(int index) {
		if (index >= size || index < 0) {
			throw new IndexOutOfBoundsException("Попытка удаления пустого элемента");
		}

		if (index < size) {
			System.arraycopy(items, index + 1, items, index, size - index - 1);
		}
		items[--size] = null;
	}

	/**
	 * Установка элемента по заданному индексу
	 * 
	 * @param item  устанавливаемый элемент
	 * @param index индекс элемента который будет установлен
	 * @throws IndexOutOfBoundsException если элемента с таким index не существует.
	 */
	public void set(int index, T item) {
		if (index >= items.length || index < 0) {
			throw new IndexOutOfBoundsException(index + "Неверно задан индекс");
		}
		if (index >= size) {
			items[size++] = item;
		} else {
			items[index] = item;
		}
	}
	/**
	 * Добавление элемента по заданному индексу
	 * 
	 * @param item  устанавливаемый элемент
	 * @param index индекс элемента который будет установлен
	 * @throws IndexOutOfBoundsException если элемента с таким index не существует.
	 */

	 public void add(int index, T item) {
	        if (index < 0 || index > size) {
	            throw new IndexOutOfBoundsException(index + "Неверно задан индекс");
	        }
	        if (size == items.length) {
	            growth();
	        }
	        System.arraycopy(items, index, items, index + 1, size - index);
	        items[index] = item;
	        size++;
	    }

	/**
	 * Получение элемента по индексу
	 * 
	 * @param index индекс элемента
	 * @return возвращает элемент из ArrayList по индексу или возвращает null, если
	 *         элемента с таким index не существует.
	 */
	public T get(int index) {
		if (index >= size || index < 0) {
			System.out.println("Выход за предел массива");
			return null;
		} else {
			return items[index];
		}
	}

	/**
	 * Получение всей коллекции
	 * 
	 * @return возвращает все элементы из ArrayList
	 */
	public T[] getItems() {
		return items;
	}

	/**
	 * Получение размера всей коллекции
	 * 
	 * @return возвращает размер ArrayList
	 */
	public int size() {
		return size;
	}

	/**
	 * Проверяет, пустая ли коллекция
	 * 
	 * @return true/false
	 */
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * Удаление всех элементов из коллекции
	 */
	@SuppressWarnings("unchecked")
	public void removeAll() {
		items = (T[]) new Object[10];
		size = 0;
	}

}