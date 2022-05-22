import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Solution {

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
        int l = input.nextInt();
        boolean[] end = new boolean[n];
        List<Map.Entry<Double, Boolean>> ants = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ants.add(Map.entry(input.nextDouble(), input.nextInt() == 1)); // isRight
        }
        while (ans.size() != n) {
            boolean[] changed = new boolean[n];
            for (int i = 0; i < n; i++) {
                if (!end[i]) {
                    var anti = ants.get(i);
                    double position = anti.getKey();
                    if (position >= l || position <= 0) {
                        ans.add(i + 1);
                        end[i] = true;
                    } else if (!changed[i]) {
                        for (int j = 0; j < n; j++) {
                            if (!end[j] && j != i) {
                                var antj = ants.get(j);
                                if (!changed[j] && anti.getValue() != antj.getValue()) {
                                    if ((anti.getValue() ? 1 : -1) * (antj.getKey() - anti.getKey()) == 2) {
                                        double pos = anti.getKey() + (anti.getValue() ? 1 : -1);
                                        ants.set(i, Map.entry(pos, !anti.getValue()));
                                        ants.set(j, Map.entry(pos, !antj.getValue()));
                                        changed[i] = true;
                                        changed[j] = true;
                                    } else if ((anti.getValue() ? 1 : -1) * (antj.getKey() - anti.getKey()) == 1) {
                                        ants.set(i, Map.entry(anti.getKey(), !anti.getValue()));
                                        ants.set(j, Map.entry(antj.getKey(), !antj.getValue()));
                                        changed[i] = true;
                                        changed[j] = true;
                                    }
                                } else if (changed[j] && anti.getValue() == antj.getValue()) {
                                    if ((anti.getValue() ? 1 : -1) * (antj.getKey() - anti.getKey()) == 1) {
                                        double pos = anti.getKey() + (anti.getValue() ? 1 : -1);
                                        ants.set(i, Map.entry(pos, !anti.getValue()));
                                        changed[i] = true;
                                    } else if ((anti.getValue() ? 1 : -1) * (antj.getKey() - anti.getKey()) == 0.5) {
                                        ants.set(i, Map.entry(anti.getKey(), !anti.getValue()));
                                        changed[i] = true;
                                    }
                                }
                            }
                        }
                        if (!changed[i]) {
                            double pos = anti.getKey() + (anti.getValue() ? 1 : -1);
                            ants.set(i, Map.entry(pos, anti.getValue()));
                            changed[i] = true;
                        }
                    }
                }

            }
        }
        return ans.stream().map(String::valueOf).collect(Collectors.joining(" "));
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

        public double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }

        public long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        public void close() throws IOException {
            br.close();
        }
    }
}
