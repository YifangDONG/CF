package round791;

import java.io.*;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class C {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        test(sc, pw);
        pw.flush();
        sc.close();
    }

    public static void test(Scanner sc, PrintWriter pw) throws IOException {
        int n = sc.nextInt();
        int q = sc.nextInt();
        TreeMap<Integer, Integer> rows = new TreeMap<>();
        TreeMap<Integer, Integer> cols = new TreeMap<>();
        for (int i = 0; i < q; i++) {
            String type = sc.next();
            if (type.equals("3")) {
                int x1 = sc.nextInt();
                int y1 = sc.nextInt();
                int x2 = sc.nextInt();
                int y2 = sc.nextInt();
                boolean coverX = rows.subMap(x1, true, x2, true).keySet().size() == x2 - x1 + 1;
                boolean coverY = true;
                if (!coverX) {
                    coverY = cols.subMap(y1, true, y2, true).keySet().size() == y2 - y1 + 1;
                }
                if (coverX || coverY) {
                    pw.println("YES");
                } else {
                    pw.println("NO");
                }
            } else {
                int row = sc.nextInt();
                int col = sc.nextInt();
                if (type.equals("1")) {
                    rows.compute(row, (k, v) -> v == null ? 1 : v + 1);
                    cols.compute(col, (k, v) -> v == null ? 1 : v + 1);
                } else {
                    rows.compute(row, (k, v) -> v - 1 == 0 ? null : v - 1);
                    cols.compute(col, (k, v) -> v - 1 == 0 ? null : v - 1);
                }
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
