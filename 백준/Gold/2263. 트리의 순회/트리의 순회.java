import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] inorder, postorder, preorder;
    static int n;
    static int idx;

    public static void main(String[] args) throws IOException {

        n = Integer.parseInt(br.readLine());

        inorder = new int[n];
        postorder = new int[n];
        preorder = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            inorder[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            postorder[i] = Integer.parseInt(st.nextToken());
        }

        getPreorder(0, n - 1, 0, n - 1);
        for (int i : preorder) {
            bw.write(i + " ");
        }
        bw.flush();
        bw.close();
        br.close();

    }

    static void getPreorder(int is, int ie, int ps, int pe) {
        if (is <= ie && ps <= pe) {
            preorder[idx++] = postorder[pe];

            int pos = is;

            for (int i = is; i <= ie; i++) {
                if (inorder[i] == postorder[pe]) {
                    pos = i;
                    break;
                }
            }

            getPreorder(is, pos-1, ps, ps + pos - is - 1);
            getPreorder(pos + 1, ie, ps + pos - is, pe - 1);
        }
    }
}
