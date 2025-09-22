import java.util.*;

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[arr1.length];
        for (int i = 0; i<arr1.length; i++) {
            String convert = Integer.toBinaryString(arr1[i] | arr2[i]);
            convert = String.format("%" + n + "s", convert);
            convert = convert.replace('1', '#');
            convert = convert.replace('0', ' ');
            answer[i] = convert;
        }
        return answer;
    }
}