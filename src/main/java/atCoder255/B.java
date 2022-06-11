package atCoder255;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
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
        int k = sc.nextInt();
        double[] dists = new double[n+1];
        List<Integer> lights = new ArrayList<>();
        int[][] positions = new int[n+1][2];
        for (int i = 0; i < k; i++) {
            lights.add(sc.nextInt());
        }
        for (int i = 1; i <= n; i++) {
            positions[i][0] = sc.nextInt();
            positions[i][1] = sc.nextInt();
        }
        Set<Integer> lightNumber = new HashSet<>(lights);

        for (int i = 1; i <= n; i++) {
            if(lightNumber.contains(i)) {
                dists[i] = 0;
            }else {
                double min = Double.MAX_VALUE;
                for (int j = 0; j < k; j++) {
                    double dist = dist(positions[i], positions[lights.get(j)]);
                    min = Math.min(min, dist);
                }
                dists[i] = min;
            }
        }
        Arrays.sort(dists);
        pw.println(dists[n]);
    }

    public static double dist(int[] a, int[] b) {
        return Math.sqrt(Math.pow(a[0] - b[0], 2) + Math.pow(a[1] - b[1], 2));
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
