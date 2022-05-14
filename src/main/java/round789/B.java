package round789;

import java.io.*;
import java.util.ArrayList;
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

    public static void test(Scanner sc, PrintWriter pw) throws IOException {
        int n = sc.nextInt();
        char[] chars = sc.next().toCharArray();
        int count = 1;

        boolean isBeauty = true;
        List<Integer> segs = new ArrayList<>();
        for (int i = 0; i < n - 1; i++) {
            if (chars[i] == chars[i + 1]) {
                count++;
            } else {
                if (count % 2 != 0) {
                    isBeauty = false;
                }
                segs.add(count);
                count = 1;
            }
        }
        segs.add(count);

        if (isBeauty) {
            pw.println(0);
        } else {
            // 11 000 11 000
            // 3 2 2 3
            // oe....eo -> eoeo -> eeoo -> eeee (3)
            //
            // oeeooeeo
            // 0 3 4 7 8 10 12
            // oeo -> eoo -> eeee (2)
            // oe oe oeo -> ooeeoeo -> ooeeeoo -> 4
            // oe oe oe eo
            // 3 3 2 2  ooee -> ee
            // eooe 11 001 111 00
            int ans = 0;
            List<Integer> pos = new ArrayList<>();
            for (int i = 0; i < segs.size(); i++) {
                if (segs.get(i) % 2 != 0) {
                    pos.add(i);
                }
            }
            for (int i = 0; i < pos.size(); i += 2) {
                ans += pos.get(i + 1) - pos.get(i);
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
