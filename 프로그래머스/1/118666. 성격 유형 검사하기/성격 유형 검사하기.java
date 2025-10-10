import java.util.*;

class Solution {
    static int[] score = {0, 3, 2, 1, 0, 1, 2, 3};
    public String solution(String[] survey, int[] choices) {
        StringBuilder sb = new StringBuilder();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i<survey.length; i++) {
            char left = survey[i].charAt(0);
            char right = survey[i].charAt(1);
            
            if (choices[i] > 4) {
                map.put(right, map.getOrDefault(right, 0)+score[choices[i]]);
            } else if (choices[i] < 4) {
                map.put(left, map.getOrDefault(left, 0)+score[choices[i]]);
            }
        }
        
        if (map.getOrDefault('R', 0) >= map.getOrDefault('T', 0)) {
            sb.append('R');
        } else {
            sb.append('T');
        }
        
        if (map.getOrDefault('C', 0) >= map.getOrDefault('F', 0)) {
            sb.append('C');
        } else {
            sb.append('F');
        }
        
        if (map.getOrDefault('J', 0) >= map.getOrDefault('M', 0)) {
            sb.append('J');
        } else {
            sb.append('M');
        }
        
        if (map.getOrDefault('A', 0) >= map.getOrDefault('N', 0)) {
            sb.append('A');
        } else {
            sb.append('N');
        }
        return sb.toString();
    }
}