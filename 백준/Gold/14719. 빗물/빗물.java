import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        int[] height = new int[W];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < W; i++) {
            height[i] = Integer.parseInt(st.nextToken());
        }

        int[] leftMax = new int[W];
        int[] rightMax = new int[W];
        leftMax[0] = height[0];
        rightMax[W-1] = height[W-1];

        for(int i = 1; i<W; i++) {
            leftMax[i] = Math.max(leftMax[i-1], height[i]);
        }
        for (int i = W-2; i>=0; i--) {
            rightMax[i] = Math.max(rightMax[i+1], height[i]);
        }

        int answer = 0;

        for (int i = 0; i<W; i++) {
            answer += (Math.min(leftMax[i], rightMax[i]) - height[i]);
        }
        System.out.println(answer);
    }
}
