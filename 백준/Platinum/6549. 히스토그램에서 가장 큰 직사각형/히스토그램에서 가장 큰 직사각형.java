import java.io.*;
import java.util.StringTokenizer;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    static long[] graph;

    public static void main(String[] args) throws IOException {
        int n;
        StringTokenizer st;
        while (true) {
            st = new StringTokenizer(br.readLine(), " ");
            n = Integer.parseInt(st.nextToken());
            if (n == 0) {
                break;
            }
            graph = new long[n];
            for (int i = 0; i < n; i++) {
                graph[i] = Long.parseLong(st.nextToken());
            }
            bw.write(Long.toString(area(0, graph.length - 1)) + "\n");
            graph = null;
        }
        bw.flush();
        bw.close();
    }

    static long area(int start, int end) {
        if (end == start) {
            return graph[start];
        }

        int mid = (start + end) / 2;

        long areaA = area(start, mid);
        long areaB = area(mid + 1, end);

        long max = Math.max(areaA, areaB);

        max = Math.max(max, areaMid(start, end, mid));

        return max;

    }

    static long areaMid(int start, int end, int mid) {

        int startMid = mid;
        int endMid = mid;

        long height = graph[mid];
        long maxArea = height;

        while (start < endMid && startMid < end) {
            if (graph[endMid - 1] < graph[startMid + 1]) {
                startMid++;
                height = Math.min(height, graph[startMid]);
            } else {
                endMid--;
                height = Math.min(height, graph[endMid]);
            }

            maxArea = Math.max(maxArea, height * (startMid - endMid + 1));
        }
        while (startMid < end) {
            startMid++;
            height = Math.min(height, graph[startMid]);
            maxArea = Math.max(maxArea, height * (startMid - endMid + 1));
        }

        while (start < endMid) {
            endMid--;
            height = Math.min(height, graph[endMid]);
            maxArea = Math.max(maxArea, height * (startMid - endMid + 1));
        }
        return maxArea;
    }
}
