package round767;

import java.util.*;
import java.util.stream.Collectors;

public class A {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        for(int i = 0; i < n; i++) {
            test(sc);
        }
        sc.close();
    }

    public static void test(Scanner sc) {
        int count = sc.nextInt();
        int cap = sc.nextInt();
        sc.nextLine();
        List<Integer> cost = Arrays.stream(sc.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        List<Integer> gain = Arrays.stream(sc.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        List<Map.Entry<Integer,Integer>> costToGain = new ArrayList<>();
        for(int i = 0; i < count; i++) {
            costToGain.add(Map.entry(cost.get(i), gain.get(i)));
        }
        costToGain.sort(Map.Entry.comparingByKey());

        for(int i = 0; i < count; i++) {
            if(cap >= costToGain.get(i).getKey()) {
                cap += costToGain.get(i).getValue();
            }
        }

        System.out.println(cap);
    }
}
