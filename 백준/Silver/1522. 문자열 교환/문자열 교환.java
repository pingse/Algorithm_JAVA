import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        String str = br.readLine();

        int len = str.length();

        int aCount = 0;
        for (int i = 0; i<len; i++) {
            if (str.charAt(i) == 'a') aCount++;
        }

        String ss = str+str;

        int bCount = 0;

        for (int i = 0; i<aCount; i++) {
            if (str.charAt(i) == 'b') bCount++;
        }

        int ans = bCount;

        for (int i = aCount; i<aCount+len; i++) {
            if(ss.charAt(i-aCount) == 'b') bCount--;
            if(ss.charAt(i) == 'b') bCount++;
            ans = Math.min(ans, bCount);
        }

        System.out.println(ans);
    }
}
