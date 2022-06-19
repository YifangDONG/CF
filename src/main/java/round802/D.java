package round802;

import java.io.*;
import java.util.StringTokenizer;

public class D {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        test(sc, pw);
        pw.flush();
        sc.close();
    }

    private static void test(Scanner sc, PrintWriter pw) throws IOException {
        int n = sc.nextInt();
        long[] locks = new long[n];
        long sum = 0;
        for (int i = 0; i < n; i++) {
            locks[i] = sc.nextLong();
            sum += locks[i];
        }

        long l = 1;
        long r = 1_000_000_000;
        long ans = 0;
        while (l <= r) {
            // mid is the second we want to check whether it's possible to fill all locks
            long mid = l + (r - l) / 2;
            long carry = 0;
            boolean flag = true;
            for (int i = 0; i < n; i++) {
                carry += mid; // for each open lock, it can get mid liter
                if (locks[i] > carry) {
                    flag = false;
                    break;
                }
                carry -= locks[i];
            }
            if (flag) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        int q = sc.nextInt();
        for (int i = 0; i < q; i++) {
            long second = sc.nextLong();
            if(second < ans) {
                pw.println(-1);
            }else {
                pw.println((sum + second - 1) / second); // to have upper value
            }
        }
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
