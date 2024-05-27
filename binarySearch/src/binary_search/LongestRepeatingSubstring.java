package binary_search;

import java.util.HashSet;
import java.util.Set;

public class LongestRepeatingSubstring {
	
	public static int longestRepeatingSubstring(String s) {
		
		int l = 0;
		int r = s.length() - 1;
		
		while (l < r) {
			
			int mid = l + (r - l + 1) / 2;
			
			if (f(s, mid)) {
				l = mid;
			} else {
				r = mid - 1;
			}
		}
		
		return l;
	}
	
	public static boolean f(String s, int length) {
		
		Set<String> seenSet = new HashSet<>();
		
		for (int i = 0; i <= s.length() - length; i++) {
			
			int j = i + length - 1;
			String sub = s.substring(i, j + 1);
			
			if(seenSet.contains(sub)) {
				return true;
			}
			
			seenSet.add(sub);
		}
		
		return false;
	}

	public static void main(String[] args) {
		System.out.println(longestRepeatingSubstring("abcdgjkhkhabcd"));
	}

}
