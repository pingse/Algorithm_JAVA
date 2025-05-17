class Solution {
    public int solution(int n) {
        int answer = 0;
        int count = Integer.bitCount(n);
        while(true) {
            if (Integer.bitCount(++n) == count) {
                answer = n;
                break;
            }
        }
        return answer;
    }
}