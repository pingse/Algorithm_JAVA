import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        long n = Long.parseLong(bufferedReader.readLine());
        long sum = 0;

        for (long i = (n-2); i>=1; i--) {
            if (i == 1) {
                sum += 1;
            } else {
                sum = sum + (i*(i+1)/2);
            }
        }
        System.out.println(sum);
        System.out.println("3");
    }
}
