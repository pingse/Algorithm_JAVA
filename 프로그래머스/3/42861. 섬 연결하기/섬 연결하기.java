import java.util.*;

class Solution {
    static int[] parent;
    
    static int find(int n) {
        if (parent[n] == n) return n;
        else return parent[n] = find(parent[n]);
    }
    
    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        
        if (a != b) {
            parent[b] = a;
        }
    }
    
    public int solution(int n, int[][] costs) {
        int answer = 0;
        parent = new int[n];
        
        for (int i = 0; i<n; i++) {
            parent[i] = i;
        }
        
        Arrays.sort(costs, (o1, o2) -> o1[2] - o2[2]);
        
        for (int i = 0; i<costs.length; i++) {
            if (find(costs[i][0]) != find(costs[i][1])) {
                union(costs[i][0], costs[i][1]);
                answer += costs[i][2];
            }
        }
        return answer;
    }
}