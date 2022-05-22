package round793;

import java.io.*;
import java.util.Arrays;
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
        int l = sc.nextInt();
        String s = sc.next();
        int[] chars = new int[26];
        char[] array = s.toCharArray();
        for (int i = 0; i < l; i++) {
            chars[array[i] - 'a'] = 1;
        }
        if (Arrays.stream(chars).sum() == 1) {
            pw.println(l);
        } else {
            int ans = 0;
            char x = s.charAt(l / 2);
            for (int i = l / 2 - 1; i >= 0; i--) {
                if (s.charAt(i) == x) {
                    ans++;
                } else {
                    break;
                }
            }
            ans *= 2;
            if (l % 2 != 0) {
                ans++;
            }
            pw.println(ans);
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
