import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Stack<Integer> stack = new Stack<>();
        stack.push(numbers[numbers.length-1]);
        answer[answer.length-1] = -1;
        
        for (int i = numbers.length-2; i>= 0; i--) {
            
            while (!stack.isEmpty() && numbers[i] >= stack.peek()) {
                stack.pop();
            }
            
            answer[i] = stack.isEmpty() ? -1 : stack.peek();
            
            stack.push(numbers[i]);
        }

        return answer;
    }
}