package array;

import java.util.Arrays;

public class RemoveDuplicatesFromSortedArrayII {

	public static int removeDuplicates(int[] nums) {

		int i = 1;
		int counter = 0;

		for (int j = 1; j < nums.length; j++) {

			if (nums[j] == nums[j - 1]) {
				counter++;
			} else {
				counter = 0;
			}

			if (counter <= 1) {
				nums[i] = nums[j];
				i++;
			}
		}

		return i;
	}

	public static void main(String[] args) {
		int[] nums1 = { 1, 1, 1, 2, 2, 3 };
		int[] nums2 = { 0, 0, 1, 1, 1, 1, 2, 3, 3 };
		
		System.out.println(removeDuplicates(nums1));
		System.out.println(Arrays.toString(nums1));
		System.out.println(removeDuplicates(nums2));
		System.out.println(Arrays.toString(nums2));
	}

}
