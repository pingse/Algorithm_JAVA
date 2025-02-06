import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        String str = br.readLine();

        String[] arr = new String[str.length()];

        for (int i = 0; i < str.length(); i++) {
            arr[i] = str.substring(i);
        }
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            bw.write(arr[i] + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
