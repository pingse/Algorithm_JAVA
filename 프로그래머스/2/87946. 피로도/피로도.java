class Solution {
    static int count = 0;
    static boolean[] visited;
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        dfs(k, 0, dungeons);
        
        return count;
    }
    
    static void dfs(int e, int c, int[][] d) {
        for (int i = 0; i<d.length; i++) {
            if (visited[i]) continue;
            if (e < d[i][0]) continue;
            
            visited[i] = true;
            dfs(e - d[i][1], c+1, d);  
            visited[i] = false;
        }
        
        if (count < c) count = c; 
    }
}