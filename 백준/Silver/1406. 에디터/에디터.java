import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        String str = br.readLine();
        int cursor;
        String a;
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        cursor = sb.length();
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            a = br.readLine();

            switch (a.charAt(0)) {
                case 'L':
                    if (cursor != 0) {
                        cursor--;
                    }
                    break;
                case 'D':
                    if (cursor != sb.length()) {
                        cursor++;
                    }
                    break;
                case 'B':
                    if (cursor != 0) {
                        sb.deleteCharAt(cursor-1);
                        cursor--;
                    }
                    break;
                case 'P':
                    sb.insert(cursor, a.charAt(2));
                    cursor++;
                    break;
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
