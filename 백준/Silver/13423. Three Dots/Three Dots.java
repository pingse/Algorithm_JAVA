import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for (int t = 0; t<T; t++) {
            int n = Integer.parseInt(br.readLine());

            int[] arr = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);
            long answer = 0;

            for (int i = 0; i<n; i++) {
                int left = i - 1;
                int right = i + 1;

                while(left >= 0 && right < n) {
                    int sum = arr[left] + arr[right];
                    int target = arr[i] * 2;

                    if (sum == target) {
                        int leftC = 1;
                        int rightC = 1;
                        while(left - 1 >= 0 && arr[left] == arr[left-1]) {
                            leftC--;
                            answer++;
                        }

                        while(right + 1 < n && arr[right] == arr[right+1]) {
                            rightC++;
                            answer++;
                        }
                        answer += (rightC * leftC);
                        left--;
                        right++;
                    } else if (sum < target) {
                        right++;
                    } else {
                        left--;
                    }
                }
            }
            sb.append(answer).append('\n');
        }
        System.out.println(sb.toString());
    }
}
