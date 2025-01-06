import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i<=200000; i++) {
            map.put(i, 0);
        }
        
        for (int i = 0; i<nums.length; i++) {
            if (map.get(nums[i]) == 0) {
                map.put(nums[i], 1);
                answer++;
            }
            
            if (answer == nums.length/2) {
                break;
            }
        }
        
        return answer;
    }
}