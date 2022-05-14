package pinely1639;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Scanner;

public class A {

    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)) {
            int n = Integer.parseInt(sc.nextLine());
            for (int i = 0; i < n; i++) {
                test(sc);
            }

        }
    }

    public static void test(Scanner sc) {
        int V = sc.nextInt();
        int E = sc.nextInt();
        int start = sc.nextInt();
        int steps = sc.nextInt();
        int[][] G = new int[V + 1][V + 1];
        boolean[] visited = new boolean[V + 1];
        visited[start] = true;
        for (int i = 0; i < E; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            G[v1][v2] = 1;
            G[v2][v1] = 1;
        }

        sc.nextLine();
        String indicator = sc.nextLine();
        while (!indicator.equals("AC") && !indicator.equals("F")) {
            int choice = 1;
            boolean findNotVisited = false;
            String[] strings = indicator.split(" ");
            int D = Integer.parseInt(strings[1]);
            List<Pair> pairs = new ArrayList<>();
            for (int i = 0; i < D; i++) {
                int degree = Integer.parseInt(strings[2 + i * 2]);
                int flag = Integer.parseInt(strings[3 + i * 2]);
                Pair pair = new Pair(i + 1, degree, flag);
                pairs.add(pair);
            }
            Optional<Pair> first = pairs.stream()
                .sorted(Comparator.comparingInt(Pair::getDegree).reversed())
                .filter(p -> p.flag == 0)
                .findFirst();

            if(first.isPresent()) {
                choice = first.get().getId();
            }else {

                choice = pairs.stream()
                    .max(Comparator.comparingInt(Pair::getDegree)).get().id;

            }

            System.out.println(choice);
            System.out.flush();
            indicator = sc.nextLine();
        }
    }
    private static class Pair{
        final int id;
        final int degree;
        final int flag;

        public Pair(int id, int degree, int flag) {
            this.id = id;
            this.degree = degree;
            this.flag = flag;
        }

        public int getId() {
            return id;
        }

        public int getDegree() {
            return degree;
        }

        public int getFlag() {
            return flag;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;
            Pair pair = (Pair) o;
            return id == pair.id && degree == pair.degree && flag == pair.flag;
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, degree, flag);
        }
    }
}
