import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        int temp = 0;
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (L < i + 1 && R >= i + 1) {
                temp = Math.max(temp, num);
            } else {
                if (temp <= num) {
                    temp = num;
                } else {
                    System.out.println("0");
                    return;
                }
            }
        }
        System.out.println("1");
    }
}
