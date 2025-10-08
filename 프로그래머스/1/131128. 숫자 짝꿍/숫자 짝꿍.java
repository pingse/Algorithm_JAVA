import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        StringBuilder sb = new StringBuilder();
        int[] numbersX = new int[10];
        int[] numbersY = new int[10];
        for (char c : X.toCharArray()) {
            numbersX[c - '0']++;
        }
        for (char c : Y.toCharArray()) {
            numbersY[c - '0']++;
        }
        
        for (int i = 9; i>=0; i--) {
            int n = Math.min(numbersX[i], numbersY[i]);
            if (i == 0 && n > 0 && sb.length() == 0) {
                sb.append(i);
            } else {
                sb.append(Integer.toString(i).repeat(n));
            }
        }
        
        if (sb.length() == 0) {
            sb.append("-1");
        }
        
        return sb.toString();
    }
}