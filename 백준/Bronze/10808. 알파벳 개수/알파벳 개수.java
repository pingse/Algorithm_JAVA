import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        int[] arr = new int[26];
        String str = br.readLine();
        char a;

        for (int i = 0; i < str.length(); i++) {
            a = str.charAt(i);
            arr[(int) Character.valueOf(a) - Character.valueOf('a')]++;
        }
        for (int i = 0; i < arr.length; i++) {
            bw.write(arr[i] + " ");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
