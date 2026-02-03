import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int k = 0;
    static int n = 0;
    static int answer = 0;
    static int[] nums;
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        nums = new int[k];

        for (int i = 0; i<k; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums);

        dfs(0);

        System.out.println(answer);
    }

    static void dfs(int num) {
        if (num > n) return;

        if (num > answer) answer = num;

        for (int i = k-1; i>=0; i--) {
            dfs(num*10 + nums[i]);
        }
    }
}
