package aston.task1;

import java.util.Comparator;

public class QuickSort {

	/**
	 * Реализует алгоритм быстрой сортировки с использованием интерфейса Comparable
	 * (естественной сортировки)
	 * 
	 * @param list коллекция для сортировки
	 */
	public static <T extends Comparable<T>> void sort(ArrayListCustom<T> list) {
		if (list == null || list.isEmpty()) {
			return;
		}
		quickSort(list, 0, list.size() - 1);
	}

	/**
	 * Реализует алгоритм быстрой сортировки с использованием Comparator
	 * 
	 * @param list       коллекция для сортировки
	 * @param comparator сортировка элементов по разным особым шаблонам
	 */
	public static <T> void sort(ArrayListCustom<T> list, Comparator<? super T> comparator) {
		if (list == null || list.isEmpty()) {
			return;
		}
		quickSort(list, 0, list.size() - 1, comparator);
	}

	private static <T extends Comparable<T>> void quickSort(ArrayListCustom<T> list, int lowIndex, int highIndex) {
		if (lowIndex < highIndex) {
			int pivotIndex = partition(list, lowIndex, highIndex);
			quickSort(list, lowIndex, pivotIndex - 1);
			quickSort(list, pivotIndex + 1, highIndex);
		}
	}

	private static <T extends Comparable<T>> int partition(ArrayListCustom<T> list, int lowIndex, int highIndex) {
		T pivot = list.get(highIndex);
		int i = lowIndex - 1;
		for (int j = lowIndex; j < highIndex; j++) {
			if (list.get(j).compareTo(pivot) <= 0) {
				i++;
				swap(list, i, j);
			}
		}
		swap(list, i + 1, highIndex);
		return i + 1;
	}

	private static <T> void quickSort(ArrayListCustom<T> list, int lowIndex, int highIndex, Comparator<? super T> comparator) {
		if (lowIndex < highIndex) {
			int pivotIndex = partition(list, lowIndex, highIndex, comparator);
			quickSort(list, lowIndex, pivotIndex - 1, comparator);
			quickSort(list, pivotIndex + 1, highIndex, comparator);
		}
	}

	private static <T> int partition(ArrayListCustom<T> list, int lowIndex, int highIndex, Comparator<? super T> comparator) {
		T pivot = list.get(highIndex);
		int i = lowIndex - 1;
		for (int j = lowIndex; j < highIndex; j++) {
			if (comparator.compare(list.get(j), pivot) <= 0) {
				i++;
				swap(list, i, j);
			}
		}
		swap(list, i + 1, highIndex);
		return i + 1;
	}

	private static <T> void swap(ArrayListCustom<T> list, int i, int j) {
		T temp = list.get(i);
		list.set(i, list.get(j));
		list.set(j, temp);
	}

}