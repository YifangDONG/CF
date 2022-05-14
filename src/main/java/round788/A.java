package round788;

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
        int l = sc.nextInt();
        List<Integer> a = new ArrayList<>();
        int negative = 0;
        for (int i = 0; i < l; i++) {
            int e = sc.nextInt();
            if (e < 0) {
                negative++;
            }
            a.add(e);
        }

        for (int i = 0; i < l; i++) {
            if (i < negative) {
                if (a.get(i) > 0) {
                    a.set(i, -a.get(i));
                }
            } else {
                if (a.get(i) < 0) {
                    a.set(i, -a.get(i));
                }
            }
        }

        for (int i = 0; i < l - 1; i++) {
            if (a.get(i) > a.get(i + 1)) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }
}
