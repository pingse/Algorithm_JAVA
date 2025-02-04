import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main (String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        
        for (int i = 1; i<=n; i++) {
            bw.write(Integer.toString(i)+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}