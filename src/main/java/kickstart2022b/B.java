package kickstart2022b;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/*
Let a and b be two factors of A such that A=ab and a≤b. Then a ≤ √A.
It follows that we can find all factors of A by checking the first √A numbers only.
For each factor a ≤ √A, the number b=A/a ≥ √A is also a factor of A.
The time complexity of the optimized algorithm is O(√A).
 */
public class B {

    public static void main(String[] args) {
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

    private static void executeTask(InputStream inputStream, OutputStream outputStream) {
        Scanner scanner = new Scanner(inputStream);
        var writer = new PrintWriter(outputStream);
        int testCount = scanner.nextInt();
        for (int i = 1; i <= testCount; i++) {
            var result = evaluate(scanner);
            writer.printf("Case #%d: %d\n", i, result);
        }
        writer.flush();
    }

    private static long evaluate(Scanner input) {
        long n = input.nextLong();
        long ans = 0;
        for (long i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                if (isPalindromes(i)) {
                    ans++;
                }
                if (isPalindromes(n / i)) {
                    if(n / i == i) {
                        continue;
                    }
                    ans++;
                }
            }
        }
        return ans;
    }

    private static boolean isPalindromes(long n) {
        String s = Long.toString(n);
        StringBuilder rev = new StringBuilder(s);
        rev.reverse();
        return s.equals(rev.toString());
    }

}
