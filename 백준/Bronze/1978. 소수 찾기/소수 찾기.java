import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args){
        int n = scanner.nextInt();
        int[] numbers = new int[n];
        int count = 0;
        int k = 1;
        int answer = 0;

        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }

        for (int j = 0; j < n; j++) {

            if(numbers[j] != 1) {
                while (true) {
                    if (count == 1 && k > (numbers[j] / 2)) {
                        answer++;
                        count = 0;
                        break;
                    }
                    if (numbers[j] % k == 0) {
                        count++;
                    }
                    if (count > 1) {
                        count = 0;
                        break;
                    }
                    k++;
                }
                k = 1;
            }
        }
        System.out.println(answer);
    }
}
