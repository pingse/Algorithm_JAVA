import java.util.*;

class Solution {
    public int[] solution(int n, int m) {
        int max = Math.max(n, m);
        int min = Math.min(n, m);
        int gcd = gcd(max, min);
        int lcm = n * m / gcd;
        int[] answer = {gcd, lcm};
        return answer;
    }
    
    static int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}