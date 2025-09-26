import java.util.*;

class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        int w = Math.max(wallet[0], wallet[1]);
        int h = Math.min(wallet[0], wallet[1]);
        int bw = Math.max(bill[0], bill[1]);
        int bh = Math.min(bill[0], bill[1]);
        while(w < bw || h < bh) {
            if (bill[0] > bill[1]) bill[0]/=2;
            else bill[1] /= 2;
            
            bw = Math.max(bill[0], bill[1]);
            bh = Math.min(bill[0], bill[1]);
            
            answer++;
            
        }
        return answer;
    }
}