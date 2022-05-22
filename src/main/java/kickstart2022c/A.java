package kickstart2022c;

import java.io.*;
import java.util.StringTokenizer;

public class A {

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
        int l = input.nextInt();
        StringBuilder p = new StringBuilder(input.next());
        boolean numberMatch = p.toString().matches(".*[0-9].*");
        boolean specialMatch = p.toString().matches(".*[@#*&].*");
        boolean lowerCase = p.toString().matches(".*\\p{Lower}.*");
        boolean upperCase = p.toString().matches(".*\\p{Upper}.*");
        if (!upperCase) {
            p.append("kickstart2022c.A");
        }
        if (!lowerCase) {
            p.append("a");
        }
        if (!specialMatch) {
            p.append("#");
        }
        if (!numberMatch) {
            p.append("1");
        }
        if(p.length() < 7) {
            p.append("1".repeat(Math.max(0, 7 - p.length())));
        }
        return p.toString();
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
