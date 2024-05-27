package array;

import java.util.Arrays;

public class MoveZeroes {

	public static int[] moveZeroes(int[] nums) {

		int p1 = 0;

		for (int p2 = 0; p2 < nums.length; p2++) {
			if (nums[p2] != 0) {
				nums[p1] = nums[p2];
				p1++;
			}
		}

		while (p1 < nums.length) {
			nums[p1] = 0;
			p1++;
		}

		return nums;
	}

	public static void main(String[] args) {

		int[] nums1 = { 0, 1, 0, 3, 12 };
		int[] nums2 = { 0 };

		System.out.println(Arrays.toString(moveZeroes(nums1)));
		System.out.println(Arrays.toString(moveZeroes(nums2)));
	}

}
