import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        String str1 = br.readLine();
        String str2 = br.readLine();
        int[] alphabet = new int[26];
        int total = 0;

        for (int i = 0; i < str1.length(); i++) {
            alphabet[str1.charAt(i) - 'a']++;
        }

        for (int i = 0; i < str2.length(); i++) {
            alphabet[str2.charAt(i)-'a']--;
        }

        for (int i = 0; i < 26; i++) {
            total += Math.abs(alphabet[i]);
        }
        bw.write(Integer.toString(total));
        bw.flush();
        bw.close();
        br.close();
    }
}
