package round812;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B {

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
        var array = new ArrayList<Long>();
        for (int i = 0; i < n; i++) {
            array.add(sc.nextLong());
        }
        if (n < 3) {
            pw.println("YES");
        } else {
            int downi = 0;
            boolean down = false;
            int upi = 0;
            boolean up = false;

            var pre = array.get(0);
            for (int i = 1; i < n; i++) {
                var curr = array.get(i);
                if(curr < pre && !down) {
                    down = true;
                    downi = i;
                }
                if(curr > pre) {
                    up = true;
                    upi = i;
                }
                pre = curr;
            }
            if (up && down && (downi < upi)) {
                pw.println("NO");
            } else {
                pw.println("YES");
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
