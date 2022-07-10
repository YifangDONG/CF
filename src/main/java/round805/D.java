package round805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class D {

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
        String s = sc.next();
        long target = sc.nextLong();
        long sum = s.chars().map(i -> i - 96).sum();
        if (sum <= target) {
            pw.println(s);
        } else {
            TreeMap<Integer, Integer> freq = new TreeMap<>(Comparator.reverseOrder());
            for (char c : s.toCharArray()) {
                int key = c - 'a' + 1;
                freq.put(key, freq.getOrDefault(key, 0) + 1);
            }
            while (sum > target) {
                Map.Entry<Integer, Integer> entry = freq.pollFirstEntry();
                if (sum - entry.getKey() * entry.getValue() > target) {
                    sum -= entry.getKey() * entry.getValue();
                } else {
                    int t = (int) (sum - target + entry.getKey() - 1) / entry.getKey();
                    freq.put(entry.getKey(), entry.getValue() - t);
                    sum -= entry.getKey() * t;
                }
            }
            StringBuilder result = new StringBuilder();
            for (char c : s.toCharArray()) {
                int key = c - 'a' + 1;
                if(freq.containsKey(key) && freq.get(key) > 0) {
                    result.append(c);
                    freq.put(key, freq.get(key) - 1);
                }
            }
            pw.println(result);
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
