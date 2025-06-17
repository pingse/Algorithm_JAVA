class Solution {
    public String solution(String s) {
        String answer = "";
        int l = s.length();
        
        if (l % 2 == 0) {
            answer = String.valueOf(s.charAt(l/2-1)) + String.valueOf(s.charAt(l/2));
        } else {
            answer = String.valueOf(s.charAt(l/2));
        }
        return answer;
    }
}