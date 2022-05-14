package round789;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
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

    public static void test(Scanner sc, PrintWriter pw) throws IOException {
        int n = sc.nextInt();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }
        int ans = 0;
        List<List<Integer>> pair1 = new ArrayList<>();
        List<List<Integer>> pair2 = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 2; j < list.size(); j++) {
                if (list.get(i) < list.get(j)) {
                    pair1.add(List.of(i, j));
                } else if (list.get(i) > list.get(j)) {
                    pair2.add(List.of(i, j));
                }
            }
        }
        /*
        int i = 0;
        int j = 0;
        while (i < pair1.size() && j < pair2.size()) {
            if (pair1.get(i).get(0) < pair2.get(j).get(0)
                    && pair1.get(i).get(1) > pair2.get(j).get(0)) {
                ans++;
                j++;
            } else {

            }
        }
        */

        for (int i = 0; i < pair1.size(); i++) {
            for (int j = 0; j < pair2.size(); j++) {
                if (pair1.get(i).get(0) < pair2.get(j).get(0)
                        && pair1.get(i).get(1) > pair2.get(j).get(0)) {
                    ans++;
                }
            }
        }


        System.out.println(ans);
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
