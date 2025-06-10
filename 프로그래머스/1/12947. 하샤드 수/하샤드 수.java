class Solution {
    public boolean solution(int x) {
        boolean answer = false;
        String s = Integer.toString(x);
        int total = 0;
        
        for (int i = 0; i<s.length(); i++) {
            total += s.charAt(i) - '0';
        }
        
        if (x % total == 0) {
            answer = true;
        }
        return answer;
    }
}