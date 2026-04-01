import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        String str = br.readLine();
        String cambridge = "CAMBRIDGE";
        StringBuilder sb = new StringBuilder();

        boolean[] alphabet = new boolean[26];

        for (int i = 0; i<cambridge.length(); i++) {
            alphabet[cambridge.charAt(i) - 'A'] = true;
        }

        for (int i = 0; i<str.length(); i++) {
            if (!alphabet[str.charAt(i) - 'A']) sb.append(str.charAt(i));
        }
        System.out.println(sb);
    }
}
