package binary_search;

public class ClosestTo2 {

	public static int closestTo2(int[] arr, int k) {

		int l = 0;
		int r = arr.length - 1;

		while (l < r - 1) {

			int mid = l + (r - l) / 2;

			if (arr[mid] < k) {
				l = mid;
			} else {
				r = mid;
			}
		}

		if (arr[r] < k) {
			return r;
		} else if (arr[l] > k) {
			return l;
		} else {
			return k - arr[l] < arr[r] - k ? l : r;
		}

	}

	public static void main(String[] args) {
		int[] arr = { 0, 3, 6, 9, 12, 15 };

		System.out.println(closestTo2(arr, 8));
	}

}
