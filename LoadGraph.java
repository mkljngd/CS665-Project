import java.io.*;
import java.util.*;

public class LoadGraph {
    private final Map<Integer, List<Integer>> adjacencyList = new HashMap<>();

    public LoadGraph(String filePath) throws IOException {
        loadGraph(filePath);
    }

    private void loadGraph(String filePath) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("#")) {
                    continue; // Skip comments
                }
                String[] parts = line.split("\t");
                int node1 = Integer.parseInt(parts[0]);
                int node2 = Integer.parseInt(parts[1]);
                addEdge(node1, node2);
            }
        }
    }

    private void addEdge(int node1, int node2) {
        adjacencyList.putIfAbsent(node1, new ArrayList<>());
        adjacencyList.putIfAbsent(node2, new ArrayList<>());
        adjacencyList.get(node1).add(node2);
        adjacencyList.get(node2).add(node1);
    }

}
