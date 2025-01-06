class Solution {
    public String solution(String my_string, String overwrite_string, int s) {
        String answer = "";
        
        StringBuilder sb = new StringBuilder();
        
        String a = my_string.substring(0, s);
        String b = my_string.substring(s+ overwrite_string.length(), my_string.length());
        sb.append(a);
        sb.append(overwrite_string);
        sb.append(b);
        answer = sb.toString();
        
        return answer;
    }
}