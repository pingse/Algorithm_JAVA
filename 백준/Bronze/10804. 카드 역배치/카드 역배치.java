import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        StringTokenizer st;
        int[] arr = new int[21];
        int start;
        int end;
        int temp;

        for (int i = 1; i < 21; i++) {
            arr[i] = i;
        }

        for (int i = 0; i < 10; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());

            for (int j = 0; j < (end-start + 1)/2; j++) {
                temp = arr[start + j];
                arr[start+j] = arr[end - j];
                arr[end-j] = temp;
            }
        }
        for (int i = 1; i < 21; i++) {
            bw.write(Integer.toString(arr[i]) + " ");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
