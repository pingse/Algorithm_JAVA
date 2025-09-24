class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 1;
        int count = section[0];
        for (int i = 1; i<section.length; i++) {
            if(count + m - 1 < section[i]) {
                answer++;
                count = section[i];
            }
        }
        return answer;
    }
}