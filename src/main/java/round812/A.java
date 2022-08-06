package round812;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class A {

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
        int x1 = 0;
        int x2 = 0;
        int y1 = 0;
        int y2 = 0;
        for (int i = 0; i < n; i++) {
            var x = sc.nextInt();
            var y = sc.nextInt();
            if (x != 0) {
                if (x > 0) {
                    x1 = Math.max(x1, x);
                } else {
                    x2 = Math.min(x2, x);
                }
            } else {
                if (y > 0) {
                    y1 = Math.max(y1, y);
                } else {
                    y2 = Math.min(y2, y);
                }
            }
        }
        pw.println(2 * (x1 - x2 + y1 - y2));
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
