
// 1514. Path with Maximum Probability
// Algorithm
// Dijkstra
// make priority queue and map with pair of distance(probability), node

class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        double[] result = new double[n];
        Arrays.fill(result, 0);
        Map<Integer, List<Pair<Double, Integer>>> map = new HashMap<>();

        for (int i = 0; i < edges.length; i++) {
            int node1 = edges[i][0];
            int node2 = edges[i][1];
            double prob = succProb[i];

            map.putIfAbsent(node1, new ArrayList<>());
            map.putIfAbsent(node2, new ArrayList<>());

            map.get(node1).add(new Pair<>(prob, node2));
            map.get(node2).add(new Pair<>(prob, node1));
        }

        PriorityQueue<Pair<Double, Integer>> queue = new PriorityQueue<>(Comparator.comparing(
                Pair::getKey, Comparator.reverseOrder()));

        result[start] = 1.0;
        queue.offer(new Pair<>(1.0, start));

        while (!queue.isEmpty()) {
            Pair<Double, Integer> pair = queue.poll();
            double currentProb = pair.getKey();
            int currentNode = pair.getValue();

            if (map.containsKey(currentNode)) {
                List<Pair<Double, Integer>> adjacentEdges = map.get(currentNode);
                for (Pair<Double, Integer> edge : adjacentEdges) {
                    double adjProb = edge.getKey();
                    int adjNode = edge.getValue();

                    double newProb = adjProb * currentProb;
                    if (newProb > result[adjNode]) {
                        result[adjNode] = newProb;
                        queue.offer(new Pair<>(newProb, adjNode));
                    }
                }
            }
        }

        return result[end];
    }
}
