import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        String pattern = br.readLine();
        String[] patterns = pattern.split("\\*");
        int len = patterns[0].length() + patterns[1].length();

        for (int i = 0; i<n; i++) {
            String str = br.readLine();
            if (str.length() < len) {
                System.out.println("NE");
                continue;
            }
            if (str.startsWith(patterns[0]) && str.endsWith(patterns[1])) System.out.println("DA");
            else System.out.println("NE");
        }
    }
}
