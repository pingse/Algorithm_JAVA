import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        long C = Long.parseLong(st.nextToken());

        st = new StringTokenizer(br.readLine());
        long X = Long.parseLong(st.nextToken());
        long Y = Long.parseLong(st.nextToken());
        long Z = Long.parseLong(st.nextToken());

        long answer = Math.min(A, X) + Math.min(B, Y) + Math.min(C, Z);
        long t = Math.min(A, X);
        X -= t;
        A -= t;

        t = Math.min(B, Y);
        Y -= t;
        B -= t;

        t = Math.min(C, Z);
        Z -= t;
        C -= t;

        while (A > 0 || B > 0 || C > 0) {
            if (X >= 3) {
                t = X / 3;
                X %= 3;
                Y += t;

                long extra = Math.min(B, Y);
                B -= extra;
                Y -= extra;

                answer+= extra;
            } else if (Y >= 3) {
                t = Y / 3;
                Y %= 3;
                Z += t;

                long extra = Math.min(C, Z);
                C -= extra;
                Z -= extra;

                answer += extra;
            } else if (Z >= 3) {
                t = Z / 3;
                Z %= 3;
                X += t;

                long extra = Math.min(A, X);
                A -= extra;
                X -= extra;

                answer += extra;
            } else break;
        }

        System.out.println(answer);


    }
}
