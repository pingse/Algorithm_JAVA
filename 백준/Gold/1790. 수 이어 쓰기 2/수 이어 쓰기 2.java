import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        long k = Long.parseLong(st.nextToken());

        long numLen = 1;
        long numCount = 9;
        while (k > numLen * numCount) {
            k-=numLen*numCount;
            numLen++;
            numCount*=10;
        }
        k-=1;

        long value = (long) Math.pow(10, numLen-1) + k/numLen;
        if (value > n) {
            System.out.print("-1");
        } else {
            System.out.print(String.valueOf(value).charAt((int) (k % numLen)));
        }

    }
}
