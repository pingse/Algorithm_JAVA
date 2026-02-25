import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {

        String str = br.readLine();
        String search = br.readLine();

        str = str.replace(search, "1");
        int answer = 0;
        for (int i = 0; i<str.length(); i++) {
            if (str.charAt(i) == '1') answer++;
        }

        System.out.println(answer);
    }
}
