package round794;

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

    public static void test(Scanner sc, PrintWriter pw) throws IOException {
        int n = sc.nextInt();
        long[] array = new long[n];
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextLong();
        }
        if (n == 3) {
            pw.println("NO");
        } else {
            long[] ans = new long[n];
            Arrays.sort(array);
            int c = 0;
            for (int i = 0; i < n; i += 2) {
                ans[i] = array[c++];
            }
            for (int i = 1; i < n; i += 2) {
                ans[i] = array[c++];
            }
            for (int i = 1; i < n; i++) {
                if (!(
                    ((ans[i] < ans[(i + 1) % n]) && (ans[i] < ans[i - 1]))
                    || ((ans[i] > ans[(i + 1) % n]) && (ans[i] > ans[i - 1]))
                )) {
                    pw.println("NO");
                    return;
                }
            }
            pw.println("YES");
            pw.println(Arrays.stream(ans).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
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