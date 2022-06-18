package atCoder256;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class D {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        test(sc, pw);
        pw.flush();
        sc.close();
    }

    private static void test(Scanner sc, PrintWriter pw) throws IOException {
        int n = sc.nextInt();
        List<Interval> intervals = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            intervals.add(new Interval(sc.nextInt(), sc.nextInt()));
        }
        Collections.sort(intervals);
        List<Interval> union = new ArrayList<>();
        int start = Integer.MAX_VALUE;
        int end = Integer.MIN_VALUE;

        for(Interval i : intervals) {
            int s = i.start;
            int e = i.end;
            if(s < start && e >= end) {
                start = s;
                end = e;
            }
            if(s <= end && e > end) {
                end = e;
            }
            if(s > end) {
                union.add(new Interval(start, end));
                start = s;
                end = e;
            }
        }
        union.add(new Interval(start, end));

        for(Interval i : union) {
            pw.println(String.format("%s %s", i.start, i.end));
        }
    }

    static class Interval implements Comparable<Interval>{
        int start;
        int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
        @Override
        public int compareTo(Interval o) {
            return this.start - o.start;
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
