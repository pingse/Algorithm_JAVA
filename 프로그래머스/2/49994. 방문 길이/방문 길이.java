import java.util.*;

class Solution {
    public int solution(String dirs) {
        int answer = 0;
        Set<String> set = new HashSet<>();
        int y = 0;
        int x = 0;
        for (char next : dirs.toCharArray()) {
            int ny = y;
            int nx = x;
            String c = "";
            
            switch(next) {
                case 'U':
                    c = "D";
                    ny++;
                    break;
                case 'D':
                    c = "U";
                    ny--;
                    break;
                case 'L':
                    c = "R";
                    nx--;
                    break;
                case 'R':
                    c = "L";
                    nx++;
                    break;
            }
            
            if (ny > 5 || nx < -5 || nx > 5 || ny < -5) continue;
            
            String path = String.valueOf(next) + ny + nx;
            String reverse = c + y + x;
            
            x = nx;
            y = ny;
            
            if (set.contains(path) || set.contains(reverse)) continue;
            
            set.add(path);
            set.add(reverse);
            
            answer++;
        }
        
        return answer;
    }

}