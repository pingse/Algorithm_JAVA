import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());


        String str = Integer.toString(a*b*c);
        int[] arr = new int[10];
        int value;

        for (int i = 0; i < str.length(); i++) {
            value = Integer.parseInt(Character.toString(str.charAt(i)));
            arr[value]++;
        }

        for (int i = 0; i < 10; i++) {
            bw.write(arr[i] + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
