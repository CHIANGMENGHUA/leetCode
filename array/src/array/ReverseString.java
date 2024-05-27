package array;

import java.util.Arrays;

public class ReverseString {
	
	public static String[] reverseString(String[] arr) {
		
		int i = 0;
		int j = arr.length - 1;

		while (i < j) {
			String temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;

			i++;
			j--;
		}
		
		return arr;
	}

	public static void main(String[] args) {
		
		String[] ex1 = { "h", "e", "l", "l", "o" };
		String[] ex2 = { "H", "a", "n", "n", "a", "h" };

		System.out.println(Arrays.toString(reverseString(ex1)));
		System.out.println(Arrays.toString(reverseString(ex2)));
	}

}
