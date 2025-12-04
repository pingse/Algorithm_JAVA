import java.util.*;

class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int total = convert(video_len);
        int position = convert(pos);
        int start = convert(op_start);
        int end = convert(op_end);
        
        if (start <= position && position <= end) position = end;
        
        for (int i = 0; i<commands.length; i++) {
            switch(commands[i]) {
                case "next":
                    position += 10;
                    if (position > total) position = total;
                    break;
                case "prev":
                    position -= 10;
                    if (position < 0) position = 0;
                    break;
            }
            if (start <= position && position <= end) position = end;
        }
        return String.format("%02d", position/60) + ":" + String.format("%02d", position%60);
    }
    
    int convert(String str) {
        return Integer.parseInt(str.substring(0, 2)) * 60 + Integer.parseInt(str.substring(3));
    }
}