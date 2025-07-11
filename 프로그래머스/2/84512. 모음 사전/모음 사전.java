import java.util.*;

class Solution {
    static int answer = 0;
    static int count = 1;
    static char[] words = {'A', 'E', 'I', 'O', 'U'};
    public int solution(String word) {
        dfs("", 0, word);
        return answer;
    }
    
    static void dfs(String str, int depth, String word) {
        if (depth >= 5) return;
        
        for (int i = 0; i<words.length && answer == 0; i++) {
            String nStr = str + String.valueOf(words[i]);
            if (word.equals(nStr)) {
                answer = count;
                break;
            }
            count++;
            dfs(nStr, depth+1, word);
        }
    }
}