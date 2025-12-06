import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> list = new ArrayList<>();
        Map<String, Integer> term = new HashMap<>();
        String[] YMD = today.split("\\.");
        int todayYMD = Integer.parseInt(YMD[0]) * 12 * 28 + Integer.parseInt(YMD[1]) * 28 + Integer.parseInt(YMD[2]);
        
        for (String t : terms) {
            String[] str = t.split(" ");
            term.put(str[0], Integer.parseInt(str[1]));
        }
        for (int i = 0; i<privacies.length; i++) {
            String[] privacy = privacies[i].split(" ");

            int[] date = convertYMD(privacy[0]);
            int ymd = calcExpirationDate(date, term.get(privacy[1]));
            
            if (todayYMD > ymd) {
                list.add(i+1);
            }
        }
        
        int[] answer = new int[list.size()];
        
        for (int i = 0; i<answer.length; i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
    
    int[] convertYMD(String date) {
        String[] ymd = date.split("\\.");
        
        return new int[]{Integer.parseInt(ymd[0]), Integer.parseInt(ymd[1]), Integer.parseInt(ymd[2])};
    }
    
    int calcExpirationDate(int[] ymd, int month) {
        return ymd[0] * 12 * 28 + (ymd[1] + month) * 28 + ymd[2] - 1;
    }
}