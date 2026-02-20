import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int money = 1000 - n;

        int[] coins = {500, 100, 50, 10, 5, 1};
        int answer = 0;

        for (int i = 0; i<coins.length; i++) {
            answer += (money / coins[i]);
            money %= coins[i];
        }

        System.out.println(answer);
    }
}
