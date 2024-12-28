import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static class Node {
        int parent;
        Node left;
        Node right;

        public Node(int parent) {
            this.parent = parent;
            this.left = null;
            this.right = null;
        }

        public void insert(int n) {
            if (this.parent > n) {
                if (this.left == null) {
                    this.left = new Node(n);
                } else {
                    this.left.insert(n);
                }
            } else {
                if (this.right == null) {
                    this.right = new Node(n);
                } else {
                    this.right.insert(n);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Node tree = new Node(Integer.parseInt(br.readLine()));
        String input;
        while (true) {
            input = br.readLine();
            if (input == null || input.equals("")) {
                break;
            }
            tree.insert(Integer.parseInt(input));
        }
        postorder(tree);
        bw.flush();
        bw.close();
        br.close();
    }

    static void postorder(Node n) throws IOException {
        if (n == null) {
            return;
        }
        postorder(n.left);
        postorder(n.right);
        bw.write(n.parent + "\n");
    }
}
