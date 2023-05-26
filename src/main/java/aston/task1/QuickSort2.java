package aston.task1;

import java.util.Comparator;

public class QuickSort2 {
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
		quicksort(list, 0, list.size() - 1);
	}

	public static <T extends Comparable<T>> void quicksort(ArrayListCustom<T> list, int lowIndex, int highIndex) {
		// Базовый случай
		if (lowIndex >= highIndex) {
			return;
		}

		// Делим данные внутри массива.
		int lowEndIndex = partition(list, lowIndex, highIndex);

		// Сортируем с использованием рекурсии
		quicksort(list, lowIndex, lowEndIndex);
		quicksort(list, lowEndIndex + 1, highIndex);
	}

	public static <T extends Comparable<T>> int partition(ArrayListCustom<T> list, int lowIndex, int highIndex) {
		// Выбираем опорным центральный элемент
		T pivot = list.get((lowIndex + (highIndex - lowIndex) / 2));

		boolean done = false;
		while (!done) {
			// Увеличиваем lowIndex пока элемент[lowIndex] < pivot
			while (list.get(lowIndex).compareTo(pivot) < 0) {
				lowIndex += 1;
			}

			// Уменьшаем highIndex пока pivot < элемент[highIndex]
			while (list.get(highIndex).compareTo(pivot) > 0) {
				highIndex -= 1;
			}

			// Если остался ноль или 1 элемент, все числа разделены

			if (lowIndex >= highIndex) {
				done = true;
			} else {
				// Меняем элемент[lowIndex] и элемент[highIndex]
				T temp = list.get(lowIndex);
				list.set(lowIndex, list.get(highIndex));
				list.set(highIndex, temp);

				// Обновляем lowIndex и highIndex
				lowIndex += 1;
				highIndex -= 1;
			}
		}

		return highIndex;
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
		quicksort(list, 0, list.size() - 1, comparator);
	}

	private static <T> void quicksort(ArrayListCustom<T> list, int lowIndex, int highIndex,
			Comparator<? super T> comparator) {
		// Базовый случай
		if (lowIndex >= highIndex) {
			return;
		}

		// Делим данные внутри массива.
		int lowEndIndex = partition(list, lowIndex, highIndex, comparator);

		// Сортируем с использованием рекурсии
		quicksort(list, lowIndex, lowEndIndex, comparator);
		quicksort(list, lowEndIndex + 1, highIndex, comparator);
	}

	private static <T> int partition(ArrayListCustom<T> list, int lowIndex, int highIndex,
			Comparator<? super T> comparator) {
		T pivot = list.get((lowIndex + (highIndex - lowIndex) / 2));

		boolean done = false;
		while (!done) {
			// Увеличиваем lowIndex пока элемент[lowIndex] < pivot
			while (comparator.compare(list.get(lowIndex), pivot) < 0) {
				lowIndex += 1;
			}

			// Уменьшаем highIndex пока pivot < элемент[highIndex]
			while (comparator.compare(list.get(highIndex), pivot) > 0) {
				highIndex -= 1;
			}

			// Если остался ноль или 1 элемент, все числа разделены

			if (lowIndex >= highIndex) {
				done = true;
			} else {
				// Меняем элемент[lowIndex] и элемент[highIndex]
				T temp = list.get(lowIndex);
				list.set(lowIndex, list.get(highIndex));
				list.set(highIndex, temp);

				// Обновляем lowIndex и highIndex
				lowIndex += 1;
				highIndex -= 1;
			}
		}

		return highIndex;
	}

}