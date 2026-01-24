import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static String T = ".OP.";
    static String F = "I..P";
    static String Lz = "O..P";
    public static void main(String[] args) throws IOException {
        String cardinal = br.readLine();
        char[][] jump = new char[2][2];

        for (int i = 0; i<2; i++) {
            String str = br.readLine();
            jump[i][0] = str.charAt(0);
            jump[i][1] = str.charAt(1);
        }

        int n = 0;

        switch(cardinal) {
            case "S" :
                break;
            case "E" :
                n = 1;
                break;
            case "N":
                n = 2;
                break;
            case "W":
                n = 3;
                break;
        }

        for (int i = 0; i<n; i++) {
            char temp = jump[0][0];

            jump[0][0] = jump[1][0];
            jump[1][0] = jump[1][1];
            jump[1][1] = jump[0][1];
            jump[0][1] = temp;
        }

        String j = String.valueOf(jump[0][0])
                + String.valueOf(jump[0][1])
                + String.valueOf(jump[1][0])
                + String.valueOf(jump[1][1]);

        if (j.equals(T)) {
            System.out.println("T");
        } else if (j.equals(F)) {
            System.out.println("F");
        } else if (j.equals(Lz)) {
            System.out.println("Lz");
        } else {
            System.out.println("?");
        }
    }
}
