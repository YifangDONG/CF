package round785;

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
        String s = sc.nextLine();
        if (s.length() % 2 == 0) {
            int sum = s.chars()
                .map(a -> a - 96)
                .sum();
            System.out.println("Alice " + sum);
        } else {
            int alice = 0;
            int bob = 0;
            if (s.charAt(0) < s.charAt(s.length() - 1)) {
                alice = s.chars()
                    .skip(1)
                    .map(a -> a - 96)
                    .sum();
                bob = s.codePointAt(0) - 96;
            } else {
                alice = s.chars()
                    .limit(s.length() - 1)
                    .map(a -> a - 96)
                    .sum();
                bob = s.codePointAt(s.length() - 1) - 96;
            }

            if (alice > bob) {
                System.out.println("Alice " + (alice - bob));
            } else {
                System.out.println("Bob " + (bob - alice));
            }
        }
    }
}
