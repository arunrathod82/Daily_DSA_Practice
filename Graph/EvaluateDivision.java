import java.util.*;

class EvaluateDivision {

    // Problem: Evaluate Division
    // Platform: LeetCode
    // Approach: DFS + Weighted Graph
    // Time Complexity: O(Q * (V + E))
    // Space Complexity: O(V + E)

    Map<String, List<Pair<String, Double>>> graph = new HashMap<>();

    public double[] calcEquation(
            List<List<String>> equations,
            double[] values,
            List<List<String>> queries) {

        // Build the weighted graph
        for(int i = 0; i < equations.size(); i++){

            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);

            double value = values[i];

            graph.putIfAbsent(a, new ArrayList<>());
            graph.putIfAbsent(b, new ArrayList<>());

            // a / b = value
            // Edge: a -> b with weight = value
            graph.get(a).add(new Pair<>(b, value));

            // b / a = 1 / value
            // Edge: b -> a with weight = 1/value
            graph.get(b).add(new Pair<>(a, 1.0 / value));
        }

        double[] res = new double[queries.size()];

        int index = 0;

        // Process every query
        for(List<String> query : queries){

            String start = query.get(0);
            String end = query.get(1);

            double ans;

            // If start or end variable does not exist
            if(!graph.containsKey(start)){
                ans = -1.0;
            }

            else if(!graph.containsKey(end)){
                ans = -1.0;
            }

            else{
                Set<String> visited = new HashSet<>();

                // Start DFS with product = 1
                ans = DFS(start, end, 1.0, visited);
            }

            res[index] = ans;
            index++;
        }

        return res;
    }

    // DFS to find a path from curr to destination
    // Product of edge weights gives the required answer
    public double DFS(
            String curr,
            String des,
            double product,
            Set<String> visited){

        // Destination reached
        if(curr.equals(des)){
            return product;
        }

        // Mark current variable as visited
        visited.add(curr);

        // Explore all neighbouring variables
        for(Pair<String, Double> edge : graph.get(curr)){

            String neighbour = edge.getKey();
            double weight = edge.getValue();

            // Visit only unvisited neighbours
            if(!visited.contains(neighbour)){

                // Multiply current product by edge weight
                double res = DFS(
                        neighbour,
                        des,
                        product * weight,
                        visited
                );

                // Valid path found
                if(res != -1.0){
                    return res;
                }
            }
        }

        // No path exists
        return -1.0;
    }

    // Pair class because Java does not have a built-in Pair class
    static class Pair<K, V> {

        private K key;
        private V value;

        Pair(K key, V value){
            this.key = key;
            this.value = value;
        }

        public K getKey(){
            return key;
        }

        public V getValue(){
            return value;
        }
    }

    // Main function
    public static void main(String[] args){

        Solution solution = new Solution();

        // Equations:
        // a / b = 2.0
        // b / c = 3.0
        List<List<String>> equations = new ArrayList<>();

        equations.add(Arrays.asList("a", "b"));
        equations.add(Arrays.asList("b", "c"));

        // Values corresponding to equations
        double[] values = {2.0, 3.0};

        // Queries
        List<List<String>> queries = new ArrayList<>();

        queries.add(Arrays.asList("a", "c"));
        queries.add(Arrays.asList("b", "a"));
        queries.add(Arrays.asList("a", "e"));
        queries.add(Arrays.asList("a", "a"));
        queries.add(Arrays.asList("x", "x"));

        // Calculate answers
        double[] result =
                solution.calcEquation(
                        equations,
                        values,
                        queries
                );

        // Print result
        System.out.println(Arrays.toString(result));
    }
}