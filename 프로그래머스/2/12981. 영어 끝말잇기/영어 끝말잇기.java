import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {};
        Set<String> set = new HashSet<>();
        set.add(words[0]);
        boolean isTrue = true;
        int count = 1;
        int turn = 2;
        char cur = words[0].charAt(words[0].length()-1);
        for (int i = 1; i<words.length; i++) {
            if (turn > n) {
                turn = 1;
                count++;
            }
            char first = words[i].charAt(0);
            char last = words[i].charAt(words[i].length()-1);
            
            System.out.println(cur+ " " + first + " " + last);
            
            if (cur != first || set.contains(words[i])) {
                answer = new int[]{turn, count};
                isTrue = false;
                break;
            } else {
                turn++;
                cur = last;
            }
            set.add(words[i]);
        }
        
        if (isTrue) {
            answer = new int[]{0, 0};
        }

        return answer;
    }
}