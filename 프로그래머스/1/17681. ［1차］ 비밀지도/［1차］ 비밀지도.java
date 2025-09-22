import java.util.*;

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[arr1.length];
        int max = 0;
        String b = " ";
        for (int i = 0; i<arr1.length; i++) {
            String convert = Integer.toBinaryString(arr1[i] | arr2[i]);
            convert = convert.replace('1', '#');
            convert = convert.replace('0', ' ');
            if (convert.length() < n) {
                convert = b.repeat(n - convert.length()) + convert;
            }
            answer[i] = convert;
        }
        return answer;
    }
}