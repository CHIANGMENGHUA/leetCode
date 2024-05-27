package array;

public class ContainerWithMostWater {

	public static int maxArea(int[] height) {

		int left = 0;
		int right = height.length - 1;
		int maxArea = 0;
		int currentArea;

		while (left < right) {
			currentArea = Math.min(height[left], height[right]) * (right - left);
			maxArea = Math.max(maxArea, currentArea);

			if (height[left] < height[right]) {
				left++;
			} else {
				right--;
			}
		}

		return maxArea;
	}

	public static void main(String[] args) {
		
		int[] height1 = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
		int[] height2 = { 1, 1 };

		System.out.println(maxArea(height1));
		System.out.println(maxArea(height2));
	}

}
