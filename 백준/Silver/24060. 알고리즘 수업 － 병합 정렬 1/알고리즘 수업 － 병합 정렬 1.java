import java.io.*;
import java.util.StringTokenizer;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    static int count = 0;
    static int number = -1;
    static String[] temp;
    public static void main(String[] args) throws IOException {
        String str1 = br.readLine();
        StringTokenizer st = new StringTokenizer(str1);
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        temp = new String[n];

        String[] str = br.readLine().split(" ");
        mergeSort(str, 0, str.length-1, m);
        bw.write(Integer.toString(number));
        bw.flush();
        bw.close();
    }

    static void mergeSort(String[] str, int l, int r, int c) {
        if (count > c) {
            return;
        }
        if (l == r) {
            return;
        }

        int m = (l+r) / 2;

        mergeSort(str, l, m, c);
        mergeSort(str, m + 1, r, c);

        merge(str, l, m, r, c);

    }

    static void merge(String[] str, int l, int m, int r, int c) {
        int left = l;
        int right = m + 1;
        int idx = l;

        while (left <= m && right <= r) {
            if (Integer.parseInt(str[left]) <= Integer.parseInt(str[right])) {
                temp[idx] = str[left];
                left++;
            } else {
                temp[idx] = str[right];
                right++;
            }
            idx++;
        }

        if (left > m) {
            while (right <= r) {
                temp[idx] = str[right];
                right++;
                idx++;
            }
        } else {
            while (left <= m) {
                temp[idx] = str[left];
                left++;
                idx++;
            }
        }

        for (int i = l; i<=r; i++){
            count++;
            if (count == c) number = Integer.parseInt(temp[i]);
            str[i] = temp[i];
        }
    }

}
