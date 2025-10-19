import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> bridge = new LinkedList<>();
        
        int sum = 0;
        int time = 0;
        
        for (int truck : truck_weights) {
            while(true) {
                if (bridge.isEmpty()) {
                    bridge.add(truck);
                    sum+=truck;
                    time++;
                    break;
                } else if (bridge.size() == bridge_length) {
                    sum -= bridge.poll();
                } else {
                    if (sum + truck <= weight) {
                        bridge.add(truck);
                        sum+=truck;
                        time++;
                        break;
                    } else {
                        bridge.add(0);
                        time++;
                    }
                }
            }
        }
        return time + bridge_length;
    }
}