import java.util.*;

class PrimAlgorithm {

    // Helper class to represent an edge in the graph
    static class Edge implements Comparable<Edge> {
        int targetNode, weight;

        Edge(int targetNode, int weight) {
            this.targetNode = targetNode;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge other) {
            return Integer.compare(this.weight, other.weight);
        }
    }

    public static void prim(Map<Integer, List<Edge>> graph, int start) {
        // Priority queue to store edges sorted by weight
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>();
        Set<Integer> visited = new HashSet<>();
        List<Edge> mst = new ArrayList<>();
        int totalCost = 0;

        // Add all edges of the starting node to the priority queue
        visited.add(start);
        priorityQueue.addAll(graph.get(start));

        while (!priorityQueue.isEmpty()) {
            // Get the edge with the smallest weight
            Edge currentEdge = priorityQueue.poll();

            // If the target node is already visited, skip this edge
            if (visited.contains(currentEdge.targetNode)) {
                continue;
            }

            // Mark the target node as visited
            visited.add(currentEdge.targetNode);
            mst.add(currentEdge); // Add the edge to the MST
            totalCost += currentEdge.weight;

            // Add all edges of the newly visited node to the queue
            for (Edge neighbor : graph.get(currentEdge.targetNode)) {
                if (!visited.contains(neighbor.targetNode)) {
                    priorityQueue.add(neighbor);
                }
            }
        }

        // Output the result
        System.out.println("Minimum Spanning Tree:");
        for (Edge edge : mst) {
            System.out.println("Target: " + edge.targetNode + " - Weight: " + edge.weight);
        }
        System.out.println("Total cost of MST: " + totalCost);
    }

    public static void main(String[] args) {
        // Example graph as an adjacency list
        Map<Integer, List<Edge>> graph = new HashMap<>();
        graph.put(0, Arrays.asList(new Edge(1, 4), new Edge(7, 8)));
        graph.put(1, Arrays.asList(new Edge(0, 4), new Edge(2, 8), new Edge(7, 11)));
        graph.put(2, Arrays.asList(new Edge(1, 8), new Edge(3, 7), new Edge(5, 4), new Edge(8, 2)));
        graph.put(3, Arrays.asList(new Edge(2, 7), new Edge(4, 9), new Edge(5, 14)));
        graph.put(4, Arrays.asList(new Edge(3, 9), new Edge(5, 10)));
        graph.put(5, Arrays.asList(new Edge(2, 4), new Edge(3, 14), new Edge(4, 10), new Edge(6, 2)));
        graph.put(6, Arrays.asList(new Edge(5, 2), new Edge(7, 1), new Edge(8, 6)));
        graph.put(7, Arrays.asList(new Edge(0, 8), new Edge(1, 11), new Edge(6, 1), new Edge(8, 7)));
        graph.put(8, Arrays.asList(new Edge(2, 2), new Edge(6, 6), new Edge(7, 7)));

        int startNode = 0;
        prim(graph, startNode);
    }
}
