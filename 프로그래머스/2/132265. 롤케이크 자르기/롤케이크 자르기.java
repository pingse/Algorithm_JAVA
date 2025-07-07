class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        
        int[] right = new int[10001];
        int[] left = new int[10001];
        int r = 0;
        int l = 0;
        
        for (int x : topping) {
            if (right[x] == 0) {
                r++;
            }
            right[x]++;
        }
        
        for (int x : topping) {
            if (right[x] == 1) {
                r--;
            }
            
            if (left[x] == 0) {
                l++;
            }
            right[x]--;
            left[x]++;
            
            if (r == l) {
                answer++;
            }
        }
        return answer;
    }
}