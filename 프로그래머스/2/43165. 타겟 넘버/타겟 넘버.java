import java.util.*;

class Solution {
    static int total = 0;
    public int solution(int[] numbers, int target) {
        dfs(0, 0, numbers, target);

        return total;
    }
    
    static void dfs(int start, int num, int[] nums, int tar) {
        if (start == nums.length) {
            if (num == tar) {
                total++;
            }
            return;
        }
        
        dfs(start+1, num + nums[start], nums, tar);
        dfs(start+1, num - nums[start], nums, tar);
    }
}