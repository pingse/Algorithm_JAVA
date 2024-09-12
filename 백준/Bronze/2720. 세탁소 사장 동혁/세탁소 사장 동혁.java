import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        int[] moneys = new int[4];

        for (int i = 0; i < n; i++) {
            int money = scanner.nextInt();
            for (int j = 0; j < 4; j++) {
                switch (j) {
                    case 0:
                        moneys[j] = money / 25;
                        money = money % 25;
                        break;
                    case 1:
                        moneys[j] = money / 10;
                        money = money % 10;
                        break;
                    case 2:
                        moneys[j] = money / 5;
                        money = money % 5;
                        break;
                    case 3:
                        moneys[j] = money / 1;
                        money = money % 1;
                        break;
                }
                System.out.print(moneys[j] + " ");
            }
            System.out.println("");
        }
    }
}
