import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[] alphabet;
        StringTokenizer st;
        String str1;
        String str2;
        boolean state;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            str1 = st.nextToken();
            str2 = st.nextToken();
            state = false;
            alphabet = new int[26];

            if (str1.length() != str2.length()) {
                state = true;
            } else {

                for (int j = 0; j < str1.length(); j++) {
                    alphabet[str1.charAt(j) - 'a']++;
                }
                for (int j = 0; j < str2.length(); j++) {
                    alphabet[str2.charAt(j) - 'a']--;
                    if (alphabet[str2.charAt(j) - 'a'] == -1) {
                        state = true;
                        break;
                    }
                }
            }

            if (state) {
                bw.write("Impossible\n");
            } else {
                bw.write("Possible\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
