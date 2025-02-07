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
            Arrays.sort(arr1);
            for (int j = 0; j < arr2.length; j++) {
                arr2[j] = Integer.parseInt(st.nextToken());
                for (int k = arr1.length - 1; k >= 0; k--) {
                    if (arr2[j] >= arr1[k]) {
                        break;
                    }
                    count++;
                }
            }
            bw.write(Integer.toString(count) + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
