class Solution {
    public String solution(String myString, String pat) {
        String answer = "";
        for (int i = myString.length() - pat.length(); i>=0; i--) {
            String sub = myString.substring(i, i+pat.length());
            if (sub.equals(pat)) { 
                answer = myString.substring(0, i+pat.length());
                break;
            }
        }
        return answer;
    }
}