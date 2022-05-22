package round793;

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

    public static void test(Scanner sc, PrintWriter pw) throws IOException {
        int l = sc.nextInt();
        int[] ranged = new int[l];
        List<Integer> in = new ArrayList<>();
        Map<Integer, Integer> occer = new HashMap<>();
        for (int i = 0; i < l; i++) {
            int e = sc.nextInt();
            if (occer.getOrDefault(e, 0) != 2) {
                in.add(e);
                occer.put(e, occer.getOrDefault(e, 0) + 1);
            }
        }
        l = in.size();
        pw.println((l + 1) / 2);
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
