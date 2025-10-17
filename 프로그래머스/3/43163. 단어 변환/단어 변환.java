import java.util.*;

class Solution {
    static boolean[] visited;
    static String[] w;
    static int ans = Integer.MAX_VALUE;
    public int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];
        w = Arrays.copyOf(words, words.length);
        
        if(!Arrays.asList(words).contains(target)) {
            return 0;
        }
        
        dfs(begin, target, 0);
        
        return ans;
    }
    
    public void dfs(String begin, String target, int count) {
        if (begin.equals(target)) {
            ans = Math.min(ans, count);
            return;
        }
        
        for (int i = 0; i<w.length; i++) {
            if (visited[i]) continue;
            
            boolean isValid = true;
            int c = 0;
            for (int j = 0; j<begin.length(); j++) {
                if(begin.charAt(j) != w[i].charAt(j)) {
                    c++;
                }
                if (c > 1) {
                    isValid = false;
                }
            }
            
            if (!isValid) continue;
            
            visited[i] = true;
            dfs(w[i], target, count+1);
            visited[i] = false;
        }
    }
}