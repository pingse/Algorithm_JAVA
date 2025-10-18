import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        String[] answer = new String[files.length];
        
        File[] list = new File[files.length];
        for (int i = 0; i<files.length; i++) {
            String[] temp = new String[2];
            int start = 0;
            int end;
            for (int j = 0; j<2; j++) {
                end = split(start, files[i]);
                temp[j] = files[i].substring(start, end);
                start = end;
            }
            list[i] = new File(i, temp[0].toUpperCase(), Integer.parseInt(temp[1]), files[i]);
        }
        
        Arrays.sort(list, (o1, o2) -> {
            if (!o1.head.equals(o2.head)) {
                return o1.head.compareTo(o2.head);
            } else if(o1.number != o2.number) {
                return o1.number - o2.number;
            } else {
                return o1.idx - o2.idx;
            }
        });
        int n = 0;
        for(File f : list) {
            answer[n++] = f.fullName;
        }
        
        
        return answer;
    }
    
    static int split(int i, String file) {
        boolean state = (file.charAt(i)-'0' >= 0 && file.charAt(i) - '0' <= 9);
        for(; i<file.length(); i++) {
            if (state != (file.charAt(i)-'0' >= 0 && file.charAt(i) - '0' <= 9)) {
                break;
            }
        }
        return i;
    }
    
    class File {
        int idx;
        String head;
        int number;
        String fullName;
        
        File(int idx, String head, int number, String fullName) {
            this.idx = idx;
            this.head = head;
            this.number = number;
            this.fullName = fullName;
        }
    }
}