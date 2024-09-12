import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        String[] inputs = scanner.nextLine().split(" ");
        scanner.close();
        String[] numbers = inputs[0].split("");
        int binary = Integer.parseInt(inputs[1]);
        int answer = 0;

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i].charAt(0) > 64) {
                answer += (numbers[i].charAt(0) - 55) * Math.pow(binary, numbers.length - 1 - i);
            } else if (numbers[i].charAt(0) < 58) {
                answer += (numbers[i].charAt(0) - 48) * Math.pow(binary, numbers.length - 1 - i);
            }
        }
        System.out.println(answer);
    }
}
