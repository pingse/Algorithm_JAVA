import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int number = Integer.parseInt(stringTokenizer.nextToken());
        int n = Integer.parseInt(stringTokenizer.nextToken());
        bufferedReader.close();
        char change = '0';
        String answer = "";

        while (number / n != 0) {
            if (number % n > 9) {
                change = (char) (number % n + 55);
                answer = String.valueOf(change) + answer;
            } else {
                change = (char) (number % n + 48);
                answer = String.valueOf(change) + answer;
            }
            number = (number - (number % n)) / n;
        }
        answer = (char) (9<number ? number+55 : number+48) + answer;
        System.out.println(answer);
    }
}
