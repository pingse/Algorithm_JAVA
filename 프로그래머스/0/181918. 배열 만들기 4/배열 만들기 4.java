import java.util.*;

class Solution {
    public List solution(int[] arr) {
        List<Integer> stk = new ArrayList<>();
        int i = 0;
        int last = 0;
        
        while(true) {
            if (i == arr.length) {
                break;
            }
            
            if (stk.isEmpty()) {
                stk.add(arr[i]);
                i++;
            } else {
                if (stk.get(stk.size()-1) < arr[i]) {
                    stk.add(arr[i]);
                    i++;
                } else {
                    stk.remove(stk.size()-1);
                }
            }
        }
        
        return stk;
    }
}