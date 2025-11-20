import java.util.*;

class Solution {
    public int solution(String[] spell, String[] dic) {
        int answer = 2;
        String check = "";
        for (int i = 0; i<spell.length; i++) {
            check += String.valueOf(i);
            for (int j = 0; j<dic.length; j++) {
                String temp = dic[j];
                dic[j] = dic[j].replace(spell[i], "");
                if (!temp.equals(dic[j])) {
                    dic[j] += String.valueOf(i);
                }
            }
        }
        for (String word : dic) {
            if (word.equals(check)) answer = 1;
        }
        return answer;
    }
}