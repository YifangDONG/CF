package round785;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class B {

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
        Set<Integer> chars = s.chars().boxed().collect(Collectors.toSet());
        if (chars.size() == 1) {
            System.out.println("YES");
        } else {
            for (int i = 0; i < s.length() - 1; i++) {
                if (s.charAt(i) == s.charAt(i + 1)) {
                    System.out.println("NO");
                    return;
                }
            }
            Map<Integer, TreeSet<Integer>> freq = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                int code = s.codePointAt(i);
                if (freq.containsKey(code)) {
                    freq.get(code).add(i);
                } else {
                    TreeSet<Integer> v = new TreeSet<>();
                    v.add(i);
                    freq.put(code, v);
                }
            }

            for (TreeSet<Integer> f1 : freq.values()) {
                if (f1.size() == 1) {
                    continue;
                }
                Integer l = f1.pollFirst();
                while (!f1.isEmpty()) {
                    Integer r = f1.pollFirst();
                    Set<Integer> sub = s.substring(l, r + 1).chars().boxed().collect(Collectors.toSet());
                    if (sub.size() < chars.size()) {
                        System.out.println("NO");
                        return;
                    }
                    l = r;
                }
            }
            System.out.println("YES");
        }
    }
}
