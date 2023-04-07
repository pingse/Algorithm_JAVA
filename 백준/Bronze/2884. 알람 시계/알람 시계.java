import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();

        //변환

        if (a==24) {
            a = 0;
        } else if (b==60){
            b = 0;
        }

        if (b >= 45 && b < 60) {
            b = b - 45;
        } else {
            b = 60 - (45 - b);

            if (a == 0) {
                a = 23;
            } else {
                a = a - 1;
            }

        }

        System.out.print(a+" "+b);



    }
}