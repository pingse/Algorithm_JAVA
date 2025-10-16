import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        for (String s : skill_trees) {
            if (check(skill, s)) answer++;
        }
        return answer;
    }
    
    public boolean check(String skill, String cur) {
        int pv = 0;
        for (int i =0; i<skill.length(); i++) {
            int v = cur.indexOf(skill.charAt(i));
            if (v == -1) v = Integer.MAX_VALUE;
            if (v < pv) return false;
            pv = v;
        }
        return true;
    }
}