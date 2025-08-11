class Solution {
    public String solution(String s, int n) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i<s.length(); i++) {
            char now = s.charAt(i);
            if (now != ' ') {
                if (now >= 'a' && now <= 'z') {
                    now = (char)((now - 'a' + n) % 26 + 'a');
                } else {
                    now = (char)((now - 'A' + n) % 26 + 'A');
                }
            }
            sb.append(String.valueOf(now));
        }
        return sb.toString();
    }
}