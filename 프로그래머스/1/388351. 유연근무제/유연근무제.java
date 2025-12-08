class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = schedules.length;
        for (int i = 0; i<schedules.length; i++) {
            int max = (schedules[i] + 10) % 100 > 59 ? schedules[i] + 110 - 60 : schedules[i] + 10 ;

            for (int j = 0; j<timelogs[i].length; j++) {
                if ((startday + j) % 7 == 0 || (startday + j) % 7 == 6) continue;
                
                if (timelogs[i][j] > max) {
                    answer--;
                    break;
                }
            }
        }
        return answer;
    }
}