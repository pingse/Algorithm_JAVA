class Solution {
    public int solution(String s) {
        int answer = 0;
        if (s.length() == 1) {
            answer = 1;
        } else {
            char x = s.charAt(0);
            int xc = 1;
            int yc = 0;
            
            for (int i = 1; i<s.length(); i++) {
                if (xc == 0) {
                    x = s.charAt(i);
                    xc = 1;
                    yc = 0;
                    continue;
                } else {
                    if (s.charAt(i) == x) {
                        xc++;
                    } else {
                        yc++;
                    }
                
                    if (xc == yc) {
                        answer++;
                        xc = 0;
                    }
                }
            }
            
            if (xc != yc && xc != 0) {
                answer++;
            }
        }
        
        return answer;
    }
}