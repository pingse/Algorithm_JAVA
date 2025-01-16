import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        String func;
        int count;
        String array;
        String[] arr;
        Deque<Integer> deque;
        boolean reverse;
        boolean err;

        for (int i = 0; i < n; i++) {
            func = br.readLine();
            count = Integer.parseInt(br.readLine());
            array = br.readLine();
            deque = new ArrayDeque<>();
            reverse = false;
            err = false;

            array = array.substring(1, array.length()-1);
            array.replaceAll(" ", "");

            arr = array.split(",");
            for (int j = 0; j < count; j++) {
                deque.addLast(Integer.parseInt(arr[j]));
            }

            for (int j = 0; j < func.length(); j++) {
                switch (func.charAt(j)) {
                    case 'R':
                        reverse = !reverse;
                        break;

                    case 'D':
                        if (reverse) {
                            if (deque.isEmpty()) {
                                err = true;
                            } else {
                                deque.pollLast();
                            }
                        } else {
                            if (deque.isEmpty()) {
                                err = true;
                            } else {
                                deque.pollFirst();
                            }
                        }
                        break;
                }
                if (err) {
                    break;
                }
            }
            if (err) {
                bw.write("error\n");
            } else {
                int size = deque.size();
                bw.write("[");
                if (!reverse) {
                    for (int j = 0; j < size; j++) {
                        bw.write(Integer.toString(deque.pollFirst()));
                        if (j != size - 1) {
                            bw.write(",");
                        }
                    }
                } else {
                    for (int j = 0; j < size; j++) {
                        bw.write(Integer.toString(deque.pollLast()));
                        if (j != size - 1) {
                            bw.write(",");
                        }
                    }
                }
                bw.write("]\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
