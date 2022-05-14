package round767;

import java.util.*;
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
        int l = sc.nextInt();
        int r = sc.nextInt();
        int k = sc.nextInt();
        if (k == 0) {
            if (r == l) {
                //only one element
                if (r == 1) {
                    System.out.println("NO");
                } else {
                    System.out.println("YES");
                }
            } else {
                System.out.println("NO");
            }
        } else {
            // YES if k >= odd
            int odd = 0;
            if(l % 2 == 0) {
                odd = Math.floorDiv(r - l + 1, 2);
            }else {
                odd = Math.floorDiv(r - l, 2) + 1;
            }
            if(odd > k) {
                System.out.println("NO");
            }else {
                System.out.println("YES");
            }
        }

    }

/*
1 NO
3 4 5 NO
13 YES
4 YES
3 4 5 6 7 -> 4 times -> 12 5 6 7 -> 12 30 7 -> 12 210 YES
4 5 6 7 8 9 10 -> 3 times -> 3 odd YES
2 3 4 NO
1 2 3 4 5 6 7 -> 3 times -> 4 odd NO
1 2 3 4 5 -> 3 times -> 3 odd YES

3 4 5 6 7 8 9 10 11 12 -> 4
8 9 -> 1
 */
}
