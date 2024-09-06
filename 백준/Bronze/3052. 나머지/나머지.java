import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = 10;
        int tempCount = 10;

        int[] n = new int[10];
        for (int i = 0; i < 10; i++) {
            int a = sc.nextInt();
            n[i] = a%42;
        }
        for (int j = 0; j < 9; j++) {
            for (int k = j+1; k < 10; k++) {
                if (n[j] != -1 && n[k] != -1) {
                    if (n[j] == n[k]) {
                        count -= 1;
                        n[k] = -1;
                    }
                }
            }
            if (tempCount != count) {
                n[j] = -1;
                tempCount = count;
            }
        }
        System.out.println(count);
    }
}
