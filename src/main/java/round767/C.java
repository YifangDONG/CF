package round767;

import java.util.*;
import java.util.stream.Collectors;

public class C {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            try {
                test(sc);
            } catch (Exception e) {
                System.err.println(e);
            }
        }
        sc.close();
    }

    private static void test(Scanner sc) {
        int l = sc.nextInt();
        List<Integer> a = new ArrayList<>();
        for (int i = 0; i < l; i++) {
            a.add(sc.nextInt());
        }
        // pos[i] store the index where i appears in the array a
        List<Deque<Integer>> pos = new ArrayList<>();
        for(int i = 0; i <= l; i++) {
            pos.add(new ArrayDeque<>());
        }

        for(int i = 0; i < a.size(); i++) {
            Integer element = a.get(i);
            pos.get(element).offerLast(i);
        }

        List<Integer> b = new ArrayList<>();

        int index = 0;
        while(index != l) {
            int maxIndex = index;
            for(int i = 0; i <=l; i++) {
                while(pos.get(i).size() > 0 && pos.get(i).peekFirst() < index) {
                    pos.get(i).pollFirst();
                }
                if(pos.get(i).size() > 0) {
                    maxIndex = Math.max(maxIndex, pos.get(i).peekFirst());
                } else {
                    b.add(i);
                    index = maxIndex + 1;
                    break;
                }
            }
        }

        System.out.println(b.size());
        System.out.println(b.stream().map(String::valueOf).collect(Collectors.joining(" ")));

    }


/*
max each number with min length used in a

 */
}
