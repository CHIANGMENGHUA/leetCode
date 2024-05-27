package stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class AsteroidCollision {

	public static int[] asteroidCollision(int[] asteroids) {
		
		Deque<Integer> stack = new ArrayDeque<>();

		for (int a : asteroids) {
			if (a > 0 || stack.isEmpty() || stack.peek() < 0) {
				stack.push(a);
			} else {
				while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < -a) {
					stack.pop();
				}
				if (stack.isEmpty() || stack.peek() < 0) {
					stack.push(a);
				} else if (stack.peek() == -a) {
					stack.pop();
				}
			}
		}

		int[] result = new int[stack.size()];

		for (int i = stack.size() - 1; i >= 0; i--) {
			result[i] = stack.pop();
		}

		return result;
	}

	public static void main(String[] args) {

		int[] asteroids = { 5, -6, 10, 9, -5, 7, -7 };
		
		System.out.println(Arrays.toString(asteroidCollision(asteroids)));
	}

}
