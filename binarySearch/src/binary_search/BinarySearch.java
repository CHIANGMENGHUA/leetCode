package binary_search;

public class BinarySearch {

	public static int binarySearch(int[] arr, int k) {

		int l = 0;
		int r = arr.length - 1;

		while (l <= r) {
			
			int mid = l + (r - l) / 2;
			
			if (arr[mid] == k) {
				return mid;
			}
			
			if (arr[mid] > k) {
				r = mid - 1;
			} else {
				l = mid + 1;
			}
		}
		
		return -1;
	}

	public static void main(String[] args) {
		int[] arr = { 0, 1, 3, 4, 5, 7, 8, 9, 11, 22 };
		
		System.out.println(binarySearch(arr, 3));
	}
}
