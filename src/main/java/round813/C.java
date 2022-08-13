package round813;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

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
        int n = sc.nextInt();
        List<Integer> array = new ArrayList<>();
        Map<Integer, List<Integer>> positions = new HashMap<>();
        for (int i = 0; i < n; i++) {
            var e = sc.nextInt();
            array.add(e);
            positions.putIfAbsent(e, new ArrayList<>());
            positions.get(e).add(i);
        }

        if (n == 1) {
            pw.println(0);
        } else {
            int minP = n - 1;
            for (int i = n - 1; i - 1 >= 0; i--) {
                if (array.get(i - 1) > array.get(i)) {
                    break;
                } else {
                    minP = i - 1;
                }
            }

            if (minP == 0) {
                pw.println(0);
            } else {
                int min = array.get(minP);
                int lastP = 0;
                for (int i = 0; i < minP; i++) {
                    var e = array.get(i);
                    if (e > min) {
                        var pos = positions.get(e);
                        lastP = Math.max(lastP, pos.get(pos.size() - 1));
                    }
                }

                int result = 0;
                Set<Integer> zeros = new HashSet<>();
                for (int i = 0; i <= lastP; i++) {
                    if (!zeros.contains(i)) {
                        result++;
                        zeros.addAll(positions.get(array.get(i)));
                    }
                }

                pw.println(result);
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
