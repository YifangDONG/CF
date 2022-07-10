package round131;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class C {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            test(sc, pw);
        }
        pw.flush();
        sc.close();
    }

    private static void test(Scanner sc, PrintWriter pw) throws IOException {
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] workers = new int[n];
        Arrays.fill(workers, 0);
        for (int i = 0; i < m; i++) {
            int w = sc.nextInt();
            workers[w-1]++;
        }
        long l = 0;
        long r = m * 2;
        while (r - l > 1) {
            long mid = (l + r) / 2;
            if (canReduceTime(workers, mid)) {
                r = mid;
            } else {
                l = mid;
            }
        }
        pw.println(r);
    }

    private static boolean canReduceTime(int[] a, long t) {
        long remain = 0;
        for (int task : a) {
            if (t > task) {
                remain -= (t - task) / 2;
            } else {
                remain += task - t;
            }
        }
        return remain <= 0;
    }

    private static class Scanner {
        StringTokenizer st;
        BufferedReader br;

        public Scanner(InputStream s) {
            br = new BufferedReader(new InputStreamReader(s));
        }

        public Scanner(String s) throws FileNotFoundException {
            br = new BufferedReader(new InputStreamReader(new FileInputStream(s)));
        }

        public String next() throws IOException {
            while (st == null || !st.hasMoreTokens())
                st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        public long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        public void close() throws IOException {
            br.close();
        }
    }
}
