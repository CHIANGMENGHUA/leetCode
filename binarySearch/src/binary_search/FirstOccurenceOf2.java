package binary_search;

public class FirstOccurenceOf2 {
	
	public static int firstOccurenceOf2(int[] arr, int k) {
		
		int l = 0;
		int r = arr.length - 1;
		
		while (l < r) {
			
			int mid = l + (r - l) / 2;
			
			if (arr[mid] < k) {
				l = mid + 1;
			} else {
				r = mid;
			}
		}
		
		return l;
	}

	public static void main(String[] args) {
		int[] arr = { 0, 1, 2, 2, 2, 2, 3, 4, 5, 6 };
		
		System.out.println(firstOccurenceOf2(arr, 2));
	}

}
