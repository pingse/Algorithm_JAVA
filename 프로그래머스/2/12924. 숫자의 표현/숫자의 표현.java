class Solution {
    public int solution(int n) {
        int answer = 0;
        int l = 0;
        int r = 1;
        if (n == 1) answer = 1;
        else {
        
        while(true) {
            int ans = 0;
            if (l >= r) {
                break;
            }
            for (int i = l; i<=r; i++) {
                ans += i;
            }
            
            if (ans == n) {
                answer++;
                r++;
            } else {
                if (ans > n) {
                    l++;
                } else if (ans < n) {
                    r++;
                }
            }
        }
        answer++;
        }
        return answer;
    }
}