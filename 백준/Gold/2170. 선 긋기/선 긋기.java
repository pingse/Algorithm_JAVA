import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o2[1] - o1[1];
            } else {
                return o1[0] - o2[0];
            }
        });
        int first = arr[0][0];
        int second = arr[0][1];
        int answer = second - first;
        for(int i = 0; i < n; i++){
            if(first <= arr[i][0] && arr[i][1] <= second) {
                continue;
            } else if(arr[i][0] < second) {
                answer += arr[i][1] - second;
            } else {
                answer += arr[i][1] - arr[i][0];
            }
            first = arr[i][0];
            second = arr[i][1];
        }
        System.out.print(answer);

    }
}
