class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        for (int i = 0; i<schedules.length; i++) {
            int schedule = schedules[i];
            int max = schedule +10;
            if (max % 100 > 59) {
                max = ((max / 100) + 1) * 100 + (max % 100) % 60;
            }
            int start = startday;
            boolean check = true;
            for (int j = 0; j<timelogs[i].length; j++) {
                if (start == 8) start = 1;
                
                if (start < 6 && timelogs[i][j] > max) {
                    check = false;
                    break;
                }
                
                start++;
            }
            if (check) answer++;
        }
        return answer;
    }
}