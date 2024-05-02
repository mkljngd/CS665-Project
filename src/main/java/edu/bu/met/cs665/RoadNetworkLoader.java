package edu.bu.met.cs665;

import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultDirectedWeightedGraph;
import org.jgrapht.graph.DefaultWeightedEdge;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class RoadNetworkLoader {

    public static Graph<Integer, DefaultWeightedEdge> loadGraph(String filePath) {
        Graph<Integer, DefaultWeightedEdge> graph = new DefaultDirectedWeightedGraph<>(DefaultWeightedEdge.class);

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.startsWith("#")) { // Ignore comments in the file
                    String[] parts = line.split("\t");
                    if (parts.length == 2) { // Handle lines with only two values
                        int fromNodeId = Integer.parseInt(parts[0]);
                        int toNodeId = Integer.parseInt(parts[1]);

                        // Add vertices and edge with default weight (e.g., 1.0)
                        graph.addVertex(fromNodeId);
                        graph.addVertex(toNodeId);
                        DefaultWeightedEdge edge = graph.addEdge(fromNodeId, toNodeId);
                        graph.setEdgeWeight(edge, 1.0); // Set default weight
                    } else if (parts.length == 3) { // Handle lines with three values
                        int fromNodeId = Integer.parseInt(parts[0]);
                        int toNodeId = Integer.parseInt(parts[1]);
                        double weight = Double.parseDouble(parts[2]);

                        // Add vertices and edge
                        graph.addVertex(fromNodeId);
                        graph.addVertex(toNodeId);
                        DefaultWeightedEdge edge = graph.addEdge(fromNodeId, toNodeId);
                        graph.setEdgeWeight(edge, weight);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return graph;
    }
}
