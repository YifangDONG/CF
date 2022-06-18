package round801;

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

    private static void test(Scanner sc, PrintWriter pw) throws IOException {
        int n = sc.nextInt();
        List<Long> piles = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            piles.add(sc.nextLong());
        }

        if (n % 2 == 0) {
            Pair m = min(piles, true);
            Pair j = min(piles, false);
            if(m.res > j.res) {
                pw.println("Mike");
            }else if (m.res < j.res) {
                pw.println("Joe");
            } else {
                if(m.pos < j.pos) {
                    pw.println("Joe");
                }else {
                    pw.println("Mike");
                }
            }
        } else {
            pw.println("Mike");
        }
    }

    private static Pair min(List<Long> piles, boolean even) {
        long res = Long.MAX_VALUE;
        int pos = 0;
        for (int i = even ? 0 : 1; i < piles.size(); i += 2) {
            if(piles.get(i) < res) {
                pos = i;
                res = piles.get(i);
            }
        }
        return new Pair(res, pos);
    }

    static class Pair {
        long res;
        long pos;

        public Pair(long res, long pos) {
            this.res = res;
            this.pos = pos;
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
