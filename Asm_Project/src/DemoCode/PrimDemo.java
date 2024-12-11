package DemoCode;
import java.util.*;


class PrimDemo {
    static void prim(int[][] graph) {
        int n = graph.length;
        boolean[] inMST = new boolean[n];
        int[] key = new int[n];
        int[] parent = new int[n];
        Arrays.fill(key, Integer.MAX_VALUE);
        key[0] = 0;
        parent[0] = -1;

        for (int count = 0; count < n - 1; count++) {
            int u = minKey(key, inMST);
            inMST[u] = true;

            for (int v = 0; v < n; v++) {
                if (graph[u][v] != 0 && !inMST[v] && graph[u][v] < key[v]) {
                    parent[v] = u;
                    key[v] = graph[u][v];
                }
            }
        }

        printMST(parent, graph);
    }

    static int minKey(int[] key, boolean[] inMST) {
        int min = Integer.MAX_VALUE, minIndex = -1;
        for (int v = 0; v < key.length; v++) {
            if (!inMST[v] && key[v] < min) {
                min = key[v];
                minIndex = v;
            }
        }
        return minIndex;
    }

    static void printMST(int[] parent, int[][] graph) {
        System.out.println("Edge \tWeight");
        for (int i = 1; i < graph.length; i++)
            System.out.println(parent[i] + " - " + i + "\t" + graph[i][parent[i]]);
    }

    public static void main(String[] args) {
        int[][] graph = {
                {0, 10, 0, 0, 0},
                {10, 0, 5, 15, 0},
                {0, 5, 0, 4, 0},
                {0, 15, 4, 0, 2},
                {0, 0, 0, 2, 0}
        };
        prim(graph);
    }
}
