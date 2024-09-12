import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        int total = 0;
        int i = 1;
        String answer = "";

        while (true) {
            int n = scanner.nextInt();

            if (n == -1) {
                break;
            }
            i = 1;

            while (true) {
                if (n%i == 0){
                    if (i == 1) {
                        total = 1;
                        answer = "1";
                    } else if(i > (n/2)) {
                        if (total == n) {
                            System.out.println(n + " = " + answer);
                            break;
                        } else {
                            System.out.println(n + " is NOT perfect.");
                            break;
                        }
                    } else {
                        total += i;
                        answer = answer + " + " + Integer.toString(i);
                        if (total > n) {
                            System.out.println(n + " is NOT perfect.");
                            break;
                        }
                    }
                }
                i++;
            }
        }

    }
}
