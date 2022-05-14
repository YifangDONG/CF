package round791;

import java.io.*;
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

    public static void test(Scanner sc, PrintWriter pw) throws IOException {
        long n = sc.nextLong();
        /*
        4x + 6y = n
        2x + 3y = n / 2
        max(x+y) min(x+y)
         */
        if (n % 4 != 0) {
            if (n - 6 < 0 || (n - 6) % 4 != 0) {
                pw.println(-1);
                return;
            }
        }
        long min;
        if (n % 6 == 0) {
            min = n / 6;
        } else {
            if ((n - (n / 6) * 6) % 4 == 0) {
                min = n / 6 + 1;
            } else {
                min = (n - 6) / 6 + (n - (n / 6 - 1) * 6) / 4;
            }
        }
        long max = n % 4 == 0 ? n / 4 : 1 + ((n - 6) / 4);
        pw.println("" + min + " " + max);


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
