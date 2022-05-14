package round789;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class A {

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
        List<Integer> arr = new ArrayList<>();
        int zeros = 0;
        for (int i = 0; i < n; i++) {
            int e = sc.nextInt();
            if(e == 0) {
                zeros++;
            }
            arr.add(e);
        }
        if(zeros > 0) {
            pw.println(arr.size() - zeros);
        }else {
            arr.sort(Comparator.comparingInt(i ->i));
            boolean hasEqual = false;
            for (int i = 0; i < n-1; i++) {
                if(arr.get(i) == arr.get(i+1)) {
                    hasEqual = true;
                    break;
                }
            }
            if(hasEqual) {
                pw.println(arr.size());
            }else {
                pw.println(arr.size() + 1);
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
