package aston.task1;

import java.util.Arrays;

public class ArrayListCustomDemo {

	public static void main(String[] args) {
		Integer[] array = { 11, 10, 25, 5, 100 };
		ArrayListCustom<Integer> obj = new ArrayListCustom<>(array);
		System.out.println(Arrays.toString(obj.getItems()));
	    QuickSort2.sort(obj);
		System.out.println(Arrays.toString(obj.getItems()));
		obj.add(3, 1212);
		
		System.out.println(Arrays.toString(obj.getItems()));

		

	}
}