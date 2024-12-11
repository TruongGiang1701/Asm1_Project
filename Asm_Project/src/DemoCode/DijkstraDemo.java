package DemoCode;
import java.util.*;

class DijkstraDemo {
    static class Node implements Comparable<Node> {
        int vertex, weight;
        Node(int v, int w) { vertex = v; weight = w; }
        public int compareTo(Node other) { return this.weight - other.weight; }
    }

    static void dijkstra(int[][] graph, int source) {
        int n = graph.length;
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[source] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(source, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int u = current.vertex;

            for (int v = 0; v < n; v++) {
                if (graph[u][v] != 0 && dist[u] + graph[u][v] < dist[v]) {
                    dist[v] = dist[u] + graph[u][v];
                    pq.add(new Node(v, dist[v]));
                }
            }
        }

        System.out.println("Shortest distances from source:");
        for (int i = 0; i < n; i++) System.out.println("To " + i + " : " + dist[i]);
    }

    public static void main(String[] args) {
        int[][] graph = {
                {0, 10, 0, 0, 0},
                {10, 0, 5, 0, 0},
                {0, 5, 0, 20, 1},
                {0, 0, 20, 0, 2},
                {0, 0, 1, 2, 0}
        };
        dijkstra(graph, 0);
    }
}
