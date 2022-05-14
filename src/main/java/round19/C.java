package round19;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class C {

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
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            list.add(sc.nextInt());
        }
        int n22 = 0;
        int n11 = 0;
        int n12 = 0;
        int n21 = 0;
        for (int i = 1; i < list.size() - 1; i++) {
            if (list.get(i) % 2 == 0) {
                n22 += list.get(i) / 2;
            } else {
                if (list.get(i) == 1) {
                    n11++;
                } else {
                    n21 += list.get(i) / 2;
                    n12++;
                }
            }
        }
        int n1 = n11 + n12;
        int n2 = n21 + n22;
        if (n1 == 0) {
            System.out.println(n2);
        } else if (n1 == 1 && n22 == 0 || n11 > n22) {
            System.out.println(-1);
        } else {
            System.out.println(n2 + n1);
        }
    }
}
