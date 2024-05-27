package binary_search;

public class LastOccurenceOf2 {
	
	public static int lastOccurenceOf2(int[] arr, int k) {
		
		int l = 0;
		int r = arr.length - 1;
		
		while (l < r) {
			
			int mid = l + (r - l + 1) / 2;
			
			if (arr[mid] > k) {
				r = mid - 1;
			} else {
				l = mid;
			}
		}
		
		return l;
	}

	public static void main(String[] args) {
		int[] arr = { 0, 1, 2, 2, 2, 2, 3, 4, 5, 6 };
		
		System.out.println(lastOccurenceOf2(arr, 2));
	}

}
