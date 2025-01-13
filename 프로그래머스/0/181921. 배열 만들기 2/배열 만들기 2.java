import java.util.*;

class Solution {
    public List solution(int l, int r) {
        List<Integer> answer = new ArrayList<>();
        
        boolean state;
        String str;
        
        for (int i = l; i<=r; i++) {
            str = Integer.toString(i);
            state = true;
            
            for (char s : str.toCharArray()) {
                if (s != '0' && s != '5') {
                    state = false;
                    break;
                }
            }
            if (state) {
                answer.add(i);
            }
        }
        if (answer.isEmpty()) {
            answer.add(-1);
        }
        return answer;
    }
}