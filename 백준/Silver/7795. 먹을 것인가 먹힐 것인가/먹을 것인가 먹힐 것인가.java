import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[] arr1;
        int[] arr2;
        int count;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            arr1 = new int[Integer.parseInt(st.nextToken())];
            arr2 = new int[Integer.parseInt(st.nextToken())];
            count = 0;

            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < arr1.length; j++) {
                arr1[j] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < arr2.length; j++) {
                arr2[j] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr2);

            for (int j = 0; j < arr1.length; j++) {
                int start = 0;
                int end = arr2.length - 1;
                int c = 0;
                while (start <= end) {
                    int mid = (start + end) / 2;
                    if (arr2[mid] < arr1[j]) {
                        start = mid + 1;
                        c = mid + 1;
                    } else {
                        end = mid - 1;
                    }
                }
                count += c;
            }
            bw.write(Integer.toString(count) + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
