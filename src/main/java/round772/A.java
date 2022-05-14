package round772;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class A {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            test(sc);
        }
        sc.close();
    }

    public static void test(Scanner sc) {
        int count = sc.nextInt();
        List<char[]> binaries = new ArrayList<>();
        int maxLength = 0;
        for (int i = 0; i < count; i++) {
            var a = sc.nextInt();
            var chars = Integer.toBinaryString(a).toCharArray();
            if (maxLength < chars.length) {
                maxLength = chars.length;
            }
            binaries.add(chars);
        }
        for (int i = 0; i < maxLength; i++) {
            boolean has1 = false;
            for (char[] chars : binaries) {
                var pos = chars.length - 1 - i;
                if (pos >= 0) {
                    if (has1) {
                        chars[pos] = '0';
                    } else if (chars[pos] == '1') {
                        has1 = true;
                    }
                }
            }
        }
        int sum = 0;
        for (char[] chars : binaries) {
            sum += Integer.parseInt(new String(chars), 2);
        }
        System.out.println(sum);
    }
}
