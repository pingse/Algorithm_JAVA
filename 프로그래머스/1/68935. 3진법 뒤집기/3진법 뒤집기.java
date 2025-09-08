import java.util.*;

class Solution {
    static Stack<Integer> stack = new Stack<>();
    public int solution(int n) {
        ternary(n);
        int answer = decimal();
        
        return answer;
    }
    
    static void ternary(int n) {
        while(true) {
            if (n / 3 == 0) {
                stack.add(n % 3);
                return;
            } else {
                stack.add(n%3);
                n /= 3;
            }
        }
    }
    
    static int decimal() {
        int size = stack.size();
        int ans = 0;
        for (int i = 0; i<size; i++) {
            int next = (int) Math.pow(3, i);
            ans += stack.pop() * next;
        }
        
        return ans;
    }
}