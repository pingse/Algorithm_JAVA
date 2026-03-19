import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        StringTokenizer st= new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        Map<Integer, Integer> map = new HashMap<>();
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;

        for (int i = 0; i<X; i++) {
            sum += arr[i];
        }

        int max = sum;

        map.put(sum, map.getOrDefault(sum, 0) + 1);

        for (int i = X; i<N; i++) {
            sum -= arr[i-X];
            sum += arr[i];
            max = Math.max(max, sum);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        if (max == 0) {
            System.out.println("SAD");
            return;
        }

        System.out.println(max);
        System.out.println(map.get(max));
    }
}
