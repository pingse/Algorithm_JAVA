import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();

        double c = 0;
        double a = 0;

        for (int i = 0; i<N; i++) {
            if (str.charAt(i) == 'C') c++;
            else a++;
        }

        int answer = (int) Math.ceil(c / (a+1.0));

        System.out.println(answer);
    }
}
