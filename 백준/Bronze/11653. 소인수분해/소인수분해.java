import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(bufferedReader.readLine());
        bufferedReader.close();

        int i = 2;

        while (n != 1) {
            while (true) {
                if (n % i == 0) {
                    n = n/i;
                    System.out.println(i);
                    i = 2;
                    break;
                }
                i++;
            }
        }

    }
}
