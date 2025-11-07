import java.util.*; 

class Solution {
    public int solution(String arr[]) {
        int num = arr.length / 2 + 1;
        int[][] max = new int[num][num];
        int[][] min = new int[num][num];
        
        for (int i = 0; i<num; i++) {
            max[i][i] = Integer.parseInt(arr[i*2]);
            min[i][i] = Integer.parseInt(arr[i*2]);
        }
        
        for (int i = 1; i<num; i++) {
            for (int j = 0; j<num - i; j++) {
                int next = i + j;
                max[j][next] = Integer.MIN_VALUE;
                min[j][next] = Integer.MAX_VALUE;
                
                for (int k = j; k<next; k++) {
                    String operator = arr[k * 2 + 1];
                    int lMax = max[j][k];
                    int lMin = min[j][k];
                    int rMax = max[k+1][next];
                    int rMin = min[k+1][next];
                    
                    switch(operator) {
                        case "+":
                            max[j][next] = Math.max(max[j][next], lMax + rMax);
                            min[j][next] = Math.min(min[j][next], lMin + rMin);
                            break;
                        case "-":
                            max[j][next] = Math.max(max[j][next], lMax - rMin);
                            min[j][next] = Math.min(min[j][next], lMin - rMax);
                            break;
                    }
                }
            }
        }
        return max[0][num-1];
    }
}