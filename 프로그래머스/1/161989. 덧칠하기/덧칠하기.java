class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        int count = section.length;
        int now = 0;
        for (int i = 1; i<=n; i++) {
            if (now == count) {
                break;
            }
            if (i == section[now]) {
                answer++;
                for (int j = 0; j<m; j++) {
                    if (i+j == section[now]) {
                        now++;
                        
                    }
                    if (now == count) {
                        break;
                    }
                }
                i+=m-1;
            }
        }
        return answer;
    }
}