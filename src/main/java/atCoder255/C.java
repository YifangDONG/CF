package atCoder255;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class C {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        test(sc, pw);
        pw.flush();
        sc.close();
    }

    public static void test(Scanner sc, PrintWriter pw) throws IOException {
        long x = sc.nextLong();
        long a = sc.nextLong();
        int d = sc.nextInt();
        long n = sc.nextLong();
        long max = d > 0 ? a + d * n : a;
        long min = d > 0 ? a : a + d * n;
        if (x <= min) {
            pw.println(min - x);
        } else if (x >= max) {
            pw.println(x - max);
        } else {
            if (d == 1 || d == -1) {
                pw.println(0);
            } else {
                long smaller = d > 0 ? 0 : n;
                long lager = d > 0 ? n : 0;
                while (Math.abs(lager - smaller) > 1) {
                    long mid = smaller + (lager - smaller) / 2;
                    if (a + d * mid < x) {
                        smaller = mid;
                    } else if (a + d * mid > x) {
                        lager = mid;
                    } else {
                        pw.println(0);
                        return;
                    }
                }
                pw.println(Math.min(Math.abs(x - (a + d * smaller)), Math.abs((a + d * lager) - x)));
            }
        }
    }

    public static class Scanner {
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
