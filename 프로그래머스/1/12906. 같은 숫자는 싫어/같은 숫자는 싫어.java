import java.util.*;

public class Solution {
    public int[] solution(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();
        
        for (int i = 0; i<arr.length; i++) {
            if (stack.isEmpty()) {
                stack.add(arr[i]);
            } else {
                if (stack.peek() != arr[i]) {
                    list.add(stack.pop());
                    stack.add(arr[i]);
                }
            }
        }
        if (!stack.isEmpty()) {
            list.add(stack.pop());
        }
        
        int[] answer = list.stream()
                .mapToInt(Integer::intValue)
                .toArray();
        return answer;
    }
}