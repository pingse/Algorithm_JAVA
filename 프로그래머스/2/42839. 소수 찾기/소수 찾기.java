import java.util.*;

class Solution {
    static Set<Integer> set;
    static boolean[] visited;
    static String totalString;
    
    public int solution(String numbers) {
        int answer = 0;
        totalString = numbers;
        visited = new boolean[numbers.length()];
        set = new HashSet<>();
        dfs("", 0);
        for (Integer num : set) {
            if (isPrime(num)) {
                answer++;
            }
        }
        
        return answer;
    }
    static void dfs(String s, int depth) {
        if (depth>totalString.length()) {
            return;
        }
        for (int i = 0; i<totalString.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                set.add(Integer.parseInt(s+totalString.charAt(i)));
                dfs(s+totalString.charAt(i), depth+1);
                visited[i] = false;
            }
        }
    }
    static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        for (int i = 2; i<=(int)Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}