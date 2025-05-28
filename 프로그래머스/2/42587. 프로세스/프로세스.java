import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        
        for (int i = 0; i<priorities.length; i++) {
            queue.add(i);
        }
        
        while(!queue.isEmpty()) {
            int cur = queue.poll();
            boolean state = true;
            
            if (queue.isEmpty()) {
                list.add(cur);
                break;
            }
            
            for (int i = 0; i<priorities.length; i++) {
                if (i != cur) {
                    if(priorities[i] > priorities[cur]) {
                        if (queue.contains(i)) {
                            state = false;
                        }
                    }
                }
            }
            
            if (state) {
                list.add(cur);
                if (cur == location) {
                    break;
                }
            } else {
                queue.add(cur);
            }
        }
        answer = list.indexOf(location)+1;
        
        return answer;
    }
}