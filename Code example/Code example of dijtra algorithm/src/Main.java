import java.util.*;

class DijkstraAlgorithm {

    // Helper class to represent an edge in the graph
    static class Edge {
        int targetNode, weight;

        Edge(int targetNode, int weight) {
            this.targetNode = targetNode;
            this.weight = weight;
        }
    }

    public static void dijkstra(Map<Integer, List<Edge>> graph, int start) {
        // Priority queue to store (distance, node), sorted by distance
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(pair -> pair[0]));
        priorityQueue.add(new int[]{0, start});

        // Distance array to store the shortest distance to each node
        Map<Integer, Integer> distances = new HashMap<>();
        for (int node : graph.keySet()) {
            distances.put(node, Integer.MAX_VALUE);
        }
        distances.put(start, 0);

        // Set to keep track of visited nodes
        Set<Integer> visited = new HashSet<>();

        while (!priorityQueue.isEmpty()) {
            int[] current = priorityQueue.poll();
            int currentDistance = current[0];
            int currentNode = current[1];

            // Skip if the node is already visited
            if (visited.contains(currentNode)) continue;
            visited.add(currentNode);

            // Update distances for neighboring nodes
            for (Edge edge : graph.get(currentNode)) {
                int newDist = currentDistance + edge.weight;
                if (newDist < distances.get(edge.targetNode)) {
                    distances.put(edge.targetNode, newDist);
                    priorityQueue.add(new int[]{newDist, edge.targetNode});
                }
            }
        }

        // Print shortest distances
        System.out.println("Shortest distances from node " + start + ":");
        for (Map.Entry<Integer, Integer> entry : distances.entrySet()) {
            System.out.println("Node " + entry.getKey() + " - Distance: " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        // Example graph as an adjacency list
        Map<Integer, List<Edge>> graph = new HashMap<>();
        graph.put(0, Arrays.asList(new Edge(1, 4), new Edge(2, 1)));
        graph.put(1, Arrays.asList(new Edge(3, 1)));
        graph.put(2, Arrays.asList(new Edge(1, 2), new Edge(3, 5)));
        graph.put(3, new ArrayList<>());

        int startNode = 0;
        dijkstra(graph, startNode);
    }
}
