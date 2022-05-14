package round788;

import java.io.*;
import java.util.*;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class B {

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
        int l = Integer.parseInt(sc.next());
        String s = sc.next();
        int sl = sc.nextInt();

        List<String> special = new ArrayList<>();
        for (int i = 0; i < sl; i++) {
            special.add(sc.next());
        }
        Map<String, List<Integer>> index = new HashMap<>();
        for (String c : special) {
            int i = s.indexOf(c);
            index.put(c, new ArrayList<>());
            while (i >= 0) {
                index.get(c).add(i);
                i = s.indexOf(c, i + 1);
            }
        }
        int ans = 0;
        List<Integer> list = new ArrayList<>(index.values().stream().flatMap(Collection::stream).collect(Collectors.toList()));
        list.sort(Comparator.comparingInt(i -> i));
        while (!list.isEmpty()) {
            list.removeIf(i -> i == 0);
            if (list.isEmpty()) {
                break;
            }
            for (int i = 0; i < list.size(); i++) {
                if (i != list.size() - 1 && list.get(i) + 1 == list.get(i + 1)) {
                    list.set(i, 0);
                }
                list.set(i, list.get(i) - i - 1);
            }
            list.removeIf(i -> i <= 0);
            ans++;
        }
        pw.println(ans);
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
