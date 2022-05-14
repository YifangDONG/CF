package round19;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

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
        List<Integer> array = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            array.add(sc.nextInt());
        }
        for (int i = 1; i < count; i++) {
            var max = array.subList(0, i)
                .stream()
                .max(Comparator.comparingInt(e -> e))
                .get();
            var min = array.subList(i, count)
                .stream()
                .min(Comparator.comparingInt(e -> e))
                .get();
            if(max > min) {
                System.out.println("YES");
                return;
            }
        }

        System.out.println("NO");
    }
}
