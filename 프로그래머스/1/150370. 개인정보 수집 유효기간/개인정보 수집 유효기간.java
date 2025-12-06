import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> list = new ArrayList<>();
        Map<String, Integer> term = new HashMap<>();
        int Y = Integer.parseInt(today.substring(0, 4));
        int M = Integer.parseInt(today.substring(5, 7));
        int D = Integer.parseInt(today.substring(8));
        int todayYMD = Y * 10000 + M * 100 + D;
        
        
        for (String t : terms) {
            term.put(String.valueOf(t.charAt(0)), Integer.parseInt(t.substring(2)));
        }
        for (int i = 0; i<privacies.length; i++) {
            int[] privacy = convertYMD(privacies[i]);
            char type = privacies[i].charAt(11);
            
            privacy[1] += term.get(String.valueOf(type));
            
            
            int ymd = calcExpirationDate(privacy);
            
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
    
    int[] convertYMD(String privacy) {
        return new int[]{Integer.parseInt(privacy.substring(0, 4)), Integer.parseInt(privacy.substring(5, 7)), Integer.parseInt(privacy.substring(8, 10))};
    }
    
    int calcExpirationDate(int[] ymd) {
        ymd[0] += (ymd[1] / 12);
        
        ymd[1] %= 12;
        
        if (ymd[1] == 0) {
            ymd[0]--;
            ymd[1] = 12;
        }
        
        
        if (ymd[2] == 1) {
            ymd[2] = 28;
            
            if (ymd[1] == 1) {
                ymd[1] = 12;
                ymd[0]--;
            } else {
                ymd[1]--;
            }
        } else {
            ymd[2]--;
        }
        
        return ymd[0] * 10000 + ymd[1] * 100 + ymd[2];
    }
}