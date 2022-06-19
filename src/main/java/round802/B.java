package round802;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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
        int l = sc.nextInt();
        String n = sc.next();
        int first = Integer.parseInt(String.valueOf(n.charAt(0)));
        String target;
        if (first >= 4) {
            target = "1".repeat(l + 1);
        } else {
            target = String.valueOf(first * 2).repeat(l);
        }
        String res = minus(target, n);
        if (res.charAt(0) == '0') {
            target = String.valueOf(first * 2 + 1).repeat(l);
            res = minus(target, n);
        }
        System.err.println(target);
        pw.println(res);

    }

    private static String minus(String a, String b) {
        List<String> res = new ArrayList<>(a.length());
        char[] chars1 = a.toCharArray();
        char[] chars2 = b.toCharArray();
        boolean borrow = false;
        for (int i = b.length() - 1; i >= 0; i--) {
            int c = Integer.parseInt(String.valueOf(chars1[i]))
                    - Integer.parseInt(String.valueOf(chars2[i]))
                    + (borrow ? -1 : 0);
            if (c >= 0) {
                res.add(String.valueOf(c));
                borrow = false;
            } else {
                res.add(String.valueOf(c + 10));
                borrow = true;
            }
        }
        Collections.reverse(res);
        return String.join("", res);
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
