package stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class DailyTemperatures {

    public static int[] dailyTemperatures(int[] temperatures) {
    	
        int[] answer = new int[temperatures.length];
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int prevIndex = stack.pop();
                answer[prevIndex] = i - prevIndex;
            }
            stack.push(i);
        }

        return answer;
    }

	public static void main(String[] args) {
		
		int[] temperatures = { 55, 38, 53, 81, 61, 93, 97, 32, 43, 78 };
		int[] result = dailyTemperatures(temperatures);
		
		System.out.println(Arrays.toString(result));
	}

}
