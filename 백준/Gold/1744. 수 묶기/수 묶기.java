import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        List<Integer> plist = new ArrayList<>();
        List<Integer> mlist = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int a = Integer.parseInt(br.readLine());
            if (a > 0) {
                plist.add(a);
            } else {
                mlist.add(a);
            }
        }

        plist.sort(Collections.reverseOrder());
        Collections.sort(mlist);

        int answer = 0;

        for (int i = 0; i < plist.size(); i++) {
            if (i+1 < plist.size() && plist.get(i) != 1 && plist.get(i + 1) != 1) {
                answer += plist.get(i++) * plist.get(i);
            } else {
                answer += plist.get(i);
            }
        }

        for (int i = 0; i < mlist.size(); i++) {
            if (i + 1 < mlist.size()) {
                answer += mlist.get(i++) * mlist.get(i);
            } else {
                answer += mlist.get(i);
            }
        }

        System.out.print(answer);
    }
}
