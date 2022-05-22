package kickstart2022c;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class B {

    public static void main(String[] args) throws IOException {
        var inputStream = System.in;
        var outputStream = System.out;
        executeTask(inputStream, outputStream);
    }

    public static void test(String inputFile, String outputFile) {
        try (InputStream inputStream = new FileInputStream(inputFile);
             OutputStream outputStream = new FileOutputStream(outputFile)) {
            executeTask(inputStream, outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void executeTask(InputStream inputStream, OutputStream outputStream) throws IOException {
        Scanner scanner = new Scanner(inputStream);
        var writer = new PrintWriter(outputStream);
        int testCount = scanner.nextInt();
        for (int i = 1; i <= testCount; i++) {
            var result = evaluate(scanner);
            writer.printf("Case #%d: %s\n", i, result);
        }
        writer.flush();
    }

    private static String evaluate(Scanner input) throws IOException {
        int n = input.nextInt();
        int x = input.nextInt();
        int y = input.nextInt();
        int sum = (1 + n) * n / 2;
        if (sum % (x + y) != 0) {
            return "IMPOSSIBLE";
        }else {
            StringBuilder ans = new StringBuilder("POSSIBLE\n");
            int target = sum / (x + y) * x;
            Set<Integer> subSet = new HashSet<>();
            int a = 0;
            int max = n;
            int add = Math.min(max, target - a);
            while(a != target) {
                if(!subSet.contains(add)) {
                    subSet.add(add);
                    a += add;
                    max = add - 1;
                    add = Math.min(max, target - a);
                }else {
                    max = add - 1;
                    add = Math.min(max, target - a);
                }
            }
            ans.append(subSet.size());
            ans.append("\n");
            String sub = subSet.stream().map(String::valueOf).collect(Collectors.joining(" "));
            ans.append(sub);
            return ans.toString();
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

        String next() throws IOException {
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
