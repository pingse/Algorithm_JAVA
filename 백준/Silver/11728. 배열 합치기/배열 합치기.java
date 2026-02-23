import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int[] total = new int[a + b];
        int[] arrA = new int[a];
        int[] arrB = new int[b];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i<a; i++) {
            arrA[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i<b; i++) {
            arrB[i] = Integer.parseInt(st.nextToken());
        }
        int countA = 0;
        int countB = 0;
        for (int i = 0; i<a+b; i++) {
            if (countA < a && countB < b) {
                if (arrA[countA] > arrB[countB]) {
                    bw.write(arrB[countB++] + " ");
                } else {
                    bw.write(arrA[countA++] + " ");
                }
            } else if (countA == a) {
                bw.write(arrB[countB++] + " ");
            } else {
                bw.write(arrA[countA++] + " ");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
