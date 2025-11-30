class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = health;
        int chainCount = 0;
        int count = 0;
        for (int t = 1; t<=attacks[attacks.length-1][0]; t++) {
            if (t == attacks[count][0]) {
                answer -= attacks[count][1];
                count++;
                chainCount = 0;
                if (answer <= 0) {
                    answer = -1;
                    break;
                }
            } else {
                answer += bandage[1];
                chainCount++;
                if (chainCount == bandage[0]) {
                    chainCount = 0;
                    answer += bandage[2];
                }
                if (answer > health) answer = health;
            }
        }
       
        return answer;
    }
}