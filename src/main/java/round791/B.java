package round791;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class B {

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
        long sum = 0;
        long all = 0;
        long[] array = new long[n + 1];
        Set<Integer> change = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            long e = sc.nextLong();
            array[i] = e;
            sum += e;
        }
        for (int i = 0; i < q; i++) {
            String type = sc.next();
            if (type.equals("2")) {
                change.clear();
                long value = sc.nextLong();
                sum = value * n;
                all = value;
                pw.println(sum);
            } else {
                int index = sc.nextInt();
                long value = sc.nextLong();
                if (all == 0 || change.contains(index)) {
                    sum += value - array[index];
                } else {
                    sum += value - all;
                }
                pw.println(sum);
                array[index] = value;
                change.add(index);
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
