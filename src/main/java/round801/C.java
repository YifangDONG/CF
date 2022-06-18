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
        if (r == 1) {
            pw.println(sum(map[0]) == 0 ? "YES" : "NO");
        } else if (c == 1) {
            pw.println(sumCol(map, 0) == 0 ? "YES" : "NO");
        } else {

            Map<Pair, Set<Integer>> result = new HashMap<>();
            int s = 0;
            for (int i = 0; i < c; i++) {
                s += map[0][i];
                Pair key = new Pair(0, i);
                result.put(key, Set.of(s));
            }

            s = 0;
            for (int i = 0; i < r; i++) {
                s += map[i][0];
                Pair key = new Pair(i, 0);
                result.put(key, Set.of(s));
            }

            for (int i = 1; i < r; i++) {
                for (int j = 1; j < c; j++) {
                    int current = map[i][j];
                    Pair key1 = new Pair(i - 1, j);
                    Pair key2 = new Pair(i, j - 1);
                    if(!result.containsKey(key1) && !result.containsKey(key2)) {
                        continue;
                    }
                    int max = r - i + c - j;
                    Set<Integer> values = new HashSet<>();
                    if(result.containsKey(key1)) {
                        for(int v : result.get(key1)) {
                            int newValue = v + current;
                            if(newValue < max) {
                                values.add(newValue);
                            }
                        }
                    }
                    if(result.containsKey(key2)) {
                        for(int v : result.get(key2)) {
                            int newValue = v + current;
                            if(newValue < max) {
                                values.add(newValue);
                            }
                        }
                    }
                    if (!values.isEmpty()) {
                        result.put(new Pair(i, j), values);
                    }
                }
            }
            Set<Integer> sums = result.get(new Pair(r - 1, c - 1));
            if (sums == null) {
                pw.println("NO");
            } else {
                pw.println(sums.contains(0) ? "YES" : "NO");
            }
        }
    }

    static int sumCol(int[][] array, int col) {
        int res = 0;
        for (int[] ints : array) {
            res += ints[col];
        }
        return res;
    }

    static int sum(int[] array) {
        int res = 0;
        for (int j : array) {
            res += j;
        }
        return res;
    }

    private static Pair min(List<Long> piles, boolean even) {
        long res = Long.MAX_VALUE;
        int pos = 0;
        for (int i = even ? 0 : 1; i < piles.size(); i += 2) {
            if (piles.get(i) < res) {
                pos = i;
                res = piles.get(i);
            }
        }
        return new Pair(res, pos);
    }

    static class Pair {
        long x;
        long y;

        public Pair(long x, long y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return x == pair.x && y == pair.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
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
