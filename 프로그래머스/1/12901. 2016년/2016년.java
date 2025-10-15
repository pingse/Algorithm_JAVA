class Solution {
    public String solution(int a, int b) {
        String[] days = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
        int[] months = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30};
        int day = 0;
        for (int i = 0; i<a; i++) {
            day += months[i];
        }
        
        day += b;

        return days[(day+4) % 7];
    }
}