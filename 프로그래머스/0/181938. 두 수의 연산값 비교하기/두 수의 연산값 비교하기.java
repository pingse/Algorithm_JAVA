class Solution {
    public int solution(int a, int b) {
        int answer = 0;
        String arr = Integer.toString(a) + Integer.toString(b);
        answer = Integer.parseInt(arr) >= 2*a*b ? Integer.parseInt(arr) : 2*a*b;
        return answer;
    }
}