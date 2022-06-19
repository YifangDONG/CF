package round802;

import java.io.*;
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

    /*
    ->
    1 -2 3 -4 5
         |
         -2 -9 0  => 5
               |
               -9 => 9
    <-
          |
     -6-9-9       => 7
      |
      -9          => 3
                  => 9
     */
    private static void test(Scanner sc, PrintWriter pw) throws IOException {
        int n = sc.nextInt();
        long[] nums = new long[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        long ops = 0;
        for (int i = 1; i < n; i++) {
            nums[i] -= ops;
            if(nums[i] > nums[i-1]) {
                ops += nums[i] - nums[i-1];
                nums[i] = nums[i-1];
            }
        }
        long ans = ops;
        long min = nums[n - 1];
        ops = 0;
        for (int i = n - 2; i >= 0; i--) {
            nums[i] -= ops;
            if(nums[i] > min) {
                ops += nums[i] - min;
                nums[i] = min;
            }

        }
        pw.println(ans + ops + Math.abs(nums[0]));
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
