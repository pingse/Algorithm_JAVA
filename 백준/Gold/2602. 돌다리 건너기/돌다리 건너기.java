import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String str = br.readLine();
        String angel = br.readLine();
        String devil = br.readLine();
        int[][][] bridge = new int[str.length()][angel.length()][2];

        for (int i = 0; i < str.length(); i++) {
            char now = str.charAt(i);
            for (int j = 0; j < angel.length(); j++) {
                if (angel.charAt(j) == now) {
                    if (i == 0) {
                        bridge[i][j][0] = 1;
                    } else {
                        for (int k = 0; k < j; k++) {
                            if (devil.charAt(k) == str.charAt(i - 1)) {
                                bridge[i][j][0] += bridge[i-1][k][1];
                            }
                        }
                    }
                }
                if (devil.charAt(j) == now) {
                    if (i == 0) {
                        bridge[i][j][1] = 1;
                    } else {
                        for (int k = 0; k < j; k++) {
                            if (angel.charAt(k) == str.charAt(i - 1)) {
                                bridge[i][j][1] += bridge[i-1][k][0];
                            }
                        }
                    }
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < angel.length(); i++) {
            if (angel.charAt(i) == str.charAt(str.length() - 1)) {
                ans += bridge[str.length()-1][i][0];
            }
            if (devil.charAt(i) == str.charAt(str.length() - 1)) {
                ans += bridge[str.length()-1][i][1];
            }
        }
        System.out.print(ans);
    }
}
