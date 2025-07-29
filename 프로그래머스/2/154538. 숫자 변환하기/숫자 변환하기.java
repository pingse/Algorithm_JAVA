import java.util.*;

class Solution {
    
    static int[] dp;
    public int solution(int x, int y, int n) {
        int answer = 0;
        
        dp = new int[y+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        if (x != y) {
            bfs(x, y, n);
            answer = dp[y] == Integer.MAX_VALUE ? -1 : dp[y];
        }
        
        return answer;
    }
    
    static void bfs(int x, int y, int n) {
        Queue<Integer> q = new LinkedList<>();
        q.add(x);
        dp[x] = 0;
        
        while(!q.isEmpty()) {
            int cur = q.poll();
            
            if (cur == y) {
                return;
            }
            
            for (int i = 0; i<3; i++) {
                int nx = cur;
                switch(i) {
                    case 0:
                        nx += n;
                        break;
                    case 1:
                        nx *= 2;
                        break;
                    case 2:
                        nx *= 3;
                        break;
                }
                if (nx > y) {
                    continue;
                }
                if (dp[nx] > dp[cur] +1) {
                    dp[nx] = dp[cur] + 1;
                    q.add(nx);
                }
                // dp[nx] = Math.min(dp[nx], dp[cur] + 1);
                // q.add(nx);
            }   
        }
    }
}