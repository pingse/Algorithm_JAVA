import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        float credit = 0;
        float grade = 0;
        for (int i = 0; i < 20; i++) {
            String[] strings = scanner.nextLine().split(" ");
            credit += Float.parseFloat(strings[1]);

            switch (strings[2].charAt(0)) {
                case 'A' :
                    if (strings[2].charAt(1) == '+') {
                        grade += Float.parseFloat(strings[1]) * 4.5;
                    } else {
                        grade += Float.parseFloat(strings[1]) * 4.0;
                    }
                    break;
                case 'B' :
                    if (strings[2].charAt(1) == '+') {
                        grade += Float.parseFloat(strings[1]) * 3.5;
                    } else {
                        grade += Float.parseFloat(strings[1]) * 3.0;
                    }
                    break;
                case 'C' :
                    if (strings[2].charAt(1) == '+') {
                        grade += Float.parseFloat(strings[1]) * 2.5;
                    } else {
                        grade += Float.parseFloat(strings[1]) * 2.0;
                    }
                    break;
                case 'D' :
                    if (strings[2].charAt(1) == '+') {
                        grade += Float.parseFloat(strings[1]) * 1.5;
                    } else {
                        grade += Float.parseFloat(strings[1]) * 1.0;
                    }
                    break;
                case 'F' :
                    grade += 0.0;
                    break;
                case 'P' :
                    credit -= Float.parseFloat(strings[1]);
                    break;
            }
        }
        System.out.println(grade/credit);
    }
}