class Solution {
    public String solution(String code) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        boolean mode = false;
        
        for (int i = 0; i<code.length(); i++) {
            if (code.charAt(i) == '1') {
                mode = !mode;
            } else {
                if ((!mode && i%2 == 0) || i == 0) {
                    sb.append(code.charAt(i));
                } else if (mode && i%2 == 1) {
                    sb.append(code.charAt(i));
                }
            }
        }
        answer = sb.toString();
        if (answer.equals("")) {
            return "EMPTY";
        }
        return answer;
    }
}