package round812;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

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
        var n = sc.nextInt();
        long[] result = new long[n];

        var k = n - 1;
        while (k > 0) {
            long square;
            if ((int)Math.sqrt(k) * (int)Math.sqrt(k) == k) {
                square = k;
            } else {
                var v = Math.floor(Math.sqrt(k)) + 1;
                square = (long) (v * v);
            }
            if (square - k > k) {
                pw.println("-1");
                break;
            } else {
                int res = (int) (square - k);
                for (int i = res; i <= k; i++) {
                    result[i] = square - i;
                }
                k = res - 1;
            }
        }
        pw.println(Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
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
