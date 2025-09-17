import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        Map<String, Integer> map = new HashMap<>();
        map.put("zero", 0);
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);
        map.put("four", 4);
        map.put("five", 5);
        map.put("six", 6);
        map.put("seven", 7);
        map.put("eight", 8);
        map.put("nine", 9);
        String temp = "";
        for (int i = 0; i<s.length(); i++) {
            if (s.charAt(i) - '0' >= 0 && s.charAt(i) - '0' < 10) {
                sb.append(String.valueOf(s.charAt(i)));
                temp = "";
            } else {
                temp += String.valueOf(s.charAt(i));
                int value = map.getOrDefault(temp, 10);
                if (value >=0 && value < 10) {
                    temp = "";
                    sb.append(Integer.toString(value));
                } 
            }
        }
        answer = Integer.parseInt(sb.toString());
        return answer;
    }
}