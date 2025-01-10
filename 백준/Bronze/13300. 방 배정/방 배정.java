import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        int[][]grade = new int[7][2];
        int total = 0;

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int s;
        int g;
        int female;
        int male;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            s = Integer.parseInt(st.nextToken());
            g = Integer.parseInt(st.nextToken());

            grade[g][s]++;
        }

        for (int i = 1; i < 7; i++) {
            female = grade[i][0]%k == 0 ? grade[i][0]/k : grade[i][0]/k+1;
            male = grade[i][1]%k == 0 ? grade[i][1]/k : grade[i][1]/k+1;

            total += female + male;
        }

        bw.write(Integer.toString(total));
        bw.flush();
        bw.close();
        br.close();

    }
}
