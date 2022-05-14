package kickstart2022b;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class A {

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
            writer.printf("Case #%d: %f\n", i, result);
        }
        writer.flush();
    }

    private static double evaluate(Scanner input) {
        int r = input.nextInt();
        int a = input.nextInt();
        int b = input.nextInt();

        double sum = 0;
        sum += Math.pow(r, 2);
        int c = r;
        while (c != 0) {
            c = c * a;
            sum += Math.pow(c, 2);
            c = c / b;
            sum += Math.pow(c, 2);
        }
        return Math.PI * sum;

    }
}
