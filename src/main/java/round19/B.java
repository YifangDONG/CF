package round19;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

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
        int count = sc.nextInt();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            list.add(sc.nextInt());
        }

    }

    private int mex(List<Integer> list) {
        var copy = new ArrayList<>(list);
        Collections.sort(copy);
        for (int i = 0; i < list.size(); i++) {
            if(copy.get(i) != i) {
                return i;
            }
        }
        return list.size();
    }
}
