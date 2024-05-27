package array;

import java.util.Arrays;

public class RemoveDuplicates {

	public static int removeDuplicates(int[] arr) {

		int i = 0;
		int j = 0;

		while (j < arr.length) {
			if (i == 0 || arr[j] != arr[i - 1]) {
				arr[i++] = arr[j++];
			} else {
				j++;
			}
		}

		return i;
	}

	public static void main(String[] args) {

		int[] ex1 = { 1, 1, 2 };
		int[] ex2 = { 1, 2, 2, 2, 3, 5, 5 };

		System.out.println(removeDuplicates(ex1));
		System.out.println(Arrays.toString(ex1));
		System.out.println(removeDuplicates(ex2));
		System.out.println(Arrays.toString(ex2));
	}

}
