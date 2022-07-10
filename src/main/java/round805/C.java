package round805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
        int q = sc.nextInt();
        List<Long> stations = new ArrayList<>(n);
        Map<Long, Integer> positions = new HashMap<>();
        Map<Long, Integer> lastPositions = new HashMap<>();
        for (int i = 0; i < n; i++) {
            long station = sc.nextLong();
            if (!positions.containsKey(station)) {
                positions.put(station, i);
            }
            stations.add(station);
            lastPositions.put(station, i);
        }

        for (int i = 0; i < q; i++) {
            long a = sc.nextLong();
            long b = sc.nextLong();
            if (!positions.containsKey(a) || !positions.containsKey(b)) {
                pw.println("NO");
            } else {
                if(positions.get(a) < lastPositions.get(b) ) {
                    pw.println("YES");
                }else {
                    pw.println("NO");
                }
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
