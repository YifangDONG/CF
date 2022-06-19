package round801;

import java.io.*;
import java.util.*;

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
        int r = sc.nextInt();
        int c = sc.nextInt();
        int[][] map = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        Pair[][] result = new Pair[r][c];
        int s = 0;
        for (int i = 0; i < c; i++) {
            s += map[0][i];
            result[0][i] = new Pair(s, s);
        }

        s = 0;
        for (int i = 0; i < r; i++) {
            s += map[i][0];
            result[i][0] = new Pair(s, s);
        }

        for (int i = 1; i < r; i++) {
            for (int j = 1; j < c; j++) {
                int current = map[i][j];
                long min = Math.min(result[i - 1][j].first, result[i][j - 1].first);
                long max = Math.max(result[i - 1][j].second, result[i][j - 1].second);
                // the possible values in the pos[i][j] is an arithmetic sequence whose common difference is 2
                result[i][j] = new Pair(min + current, max + current);
            }
        }
        Pair sums = result[r - 1][c - 1];
        if (sums.first <= 0 && sums.second >= 0 && (r + c - 1) % 2 == 0) {
            pw.println("YES");
        } else {
            pw.println("NO");
        }
    }

    static class Pair {
        long first;
        long second;

        public Pair(long first, long second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return first == pair.first && second == pair.second;
        }

        @Override
        public int hashCode() {
            return Objects.hash(first, second);
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
