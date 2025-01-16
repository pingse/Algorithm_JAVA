import java.util.*;

class Solution {
    public List solution(String[] intStrs, int k, int s, int l) {
        List<Integer> list = new ArrayList<>();
        
        for (int i = 0; i<intStrs.length; i++) {
            if (k < Integer.parseInt(intStrs[i].substring(s, s+l))) {
                list.add(Integer.parseInt(intStrs[i].substring(s, s+l)));
            }
        }
        
        return list;
    }
}