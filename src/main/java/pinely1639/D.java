package pinely1639;

import java.util.Random;
import java.util.Scanner;

public class D {

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

        for(int i = 1; i <= V ;i++) {
            for(int j = 1; j < V; j++) {
                System.out.printf(G[i][j] + ",");
            }
            System.out.println(G[i][V]);
        }
        sc.nextLine();
        String indicator = sc.nextLine();
        while (!indicator.equals("AC") && !indicator.equals("F")) {
            int choice = 1;
            boolean findNotVisited = false;
            String[] strings = indicator.split(" ");
            int D = Integer.parseInt(strings[1]);
//            int minD = D;
            for (int i = 0; i < D; i++) {
                int degree = Integer.parseInt(strings[2 + i * 2]);
                int flag = Integer.parseInt(strings[3 + i * 2]);
                if (flag == 0) {
                    choice = i + 1;
                    findNotVisited = true;
                    break;
//                    minD = degree;
                }
            }
            Random random = new Random();
            if(!findNotVisited) {
                choice = random.nextInt(2) == 1 ? choice : D;
            }

            System.out.println(choice);
            System.out.flush();
            indicator = sc.nextLine();
        }
    }
}
