import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static Node[] tree;
    static class Node {
        char parent;
        Node left;
        Node right;

        public Node(char parent) {
            this.parent = parent;
            this.left = null;
            this.right = null;
        }
    }

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        tree = new Node[n+1];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            char parent = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            if (tree[parent - 'A'] == null) {
                tree[parent - 'A'] = new Node(parent);
            }

            if (left != '.') {
                tree[left - 'A'] = new Node(left);
                tree[parent - 'A'].left = tree[left - 'A'];
            }

            if (right != '.') {
                tree[right - 'A'] = new Node(right);
                tree[parent - 'A'].right = tree[right - 'A'];
            }
        }

        preorder(tree[0]);
        bw.write("\n");

        inorder(tree[0]);
        bw.write("\n");

        postorder(tree[0]);
        bw.write("\n");

        bw.flush();
        bw.close();
        br.close();

    }

    static void preorder(Node n) throws IOException {
        if (n == null) {
            return;
        }
        bw.write(n.parent);
        preorder(n.left);
        preorder(n.right);
    }

    static void inorder(Node n) throws IOException {
        if (n == null) {
            return;
        }
        inorder(n.left);
        bw.write(n.parent);
        inorder(n.right);
    }

    static void postorder(Node n) throws IOException {
        if (n == null) {
            return;
        }

        postorder(n.left);
        postorder(n.right);
        bw.write(n.parent);
    }
}
