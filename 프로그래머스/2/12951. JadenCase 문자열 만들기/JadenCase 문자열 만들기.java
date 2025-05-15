import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        String[] words = s.split("");
        
        for (int i = 0; i<words.length; i++) {
            if (i == 0) {
                answer += words[i].toUpperCase();
            } else {
                if (words[i-1].equals(" ")) {
                    answer += words[i].toUpperCase();
                } else {
                    answer += words[i].toLowerCase();
                }
            }
        }
        return answer;
    }
}