class Solution {
    public String solution(String s) {
        String answer = "";
        String[] strs = s.split(" ");
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        
        for (int i = 0; i<strs.length; i++) {
            if (max < Integer.parseInt(strs[i])) max = Integer.parseInt(strs[i]);
            if (min > Integer.parseInt(strs[i])) min = Integer.parseInt(strs[i]);
        }
        answer = Integer.toString(min) + " " + Integer.toString(max);
        return answer;
    }
}