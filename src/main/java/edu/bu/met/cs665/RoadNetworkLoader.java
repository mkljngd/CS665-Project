package edu.bu.met.cs665;

import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultWeightedEdge;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class RoadNetworkLoader {
    public static Graph<Integer, DefaultWeightedEdge> loadGraph(BufferedReader reader) {
        GraphBuilder<Integer, DefaultWeightedEdge> builder = new GraphBuilder<>();
        int linesProcessed = 0;

        try {
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.startsWith("#")) {
                    linesProcessed++;
                    if (linesProcessed % 1_000_000 == 0) {
                        System.out.println("Processed " + linesProcessed + " lines...");
                    }
                    String[] parts = line.split("\t");
                    if (parts.length == 2) {
                        int fromNodeId = Integer.parseInt(parts[0]);
                        int toNodeId = Integer.parseInt(parts[1]);
                        builder.addEdge(fromNodeId, toNodeId, 1.0);
                    } else if (parts.length == 3) {
                        int fromNodeId = Integer.parseInt(parts[0]);
                        int toNodeId = Integer.parseInt(parts[1]);
                        double weight = Double.parseDouble(parts[2]);
                        builder.addEdge(fromNodeId, toNodeId, weight);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Failed to read the file: " + e.getMessage());
            return null;
        }
        return builder.build();
    }

//    public static Graph<Integer, DefaultWeightedEdge> loadGraph(String filePath) {
//        GraphBuilder<Integer, DefaultWeightedEdge> builder = new GraphBuilder<>();
//        int linesProcessed = 0;
//
//        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
//            String line;
//            while ((line = reader.readLine()) != null) {
//                if (!line.startsWith("#")) {
//                    linesProcessed++;
//                    if (linesProcessed % 1_000_000 == 0) {
//                        System.out.println("Processed " + linesProcessed + " lines...");
//                    }
//                    String[] parts = line.split("\t");
//                    if (parts.length == 2) {
//                        int fromNodeId = Integer.parseInt(parts[0]);
//                        int toNodeId = Integer.parseInt(parts[1]);
//                        builder.addEdge(fromNodeId, toNodeId, 1.0);
//                    } else if (parts.length == 3) {
//                        int fromNodeId = Integer.parseInt(parts[0]);
//                        int toNodeId = Integer.parseInt(parts[1]);
//                        double weight = Double.parseDouble(parts[2]);
//                        builder.addEdge(fromNodeId, toNodeId, weight);
//                    }
//                }
//            }
//        } catch (IOException e) {
//            System.err.println("Failed to read the file: " + e.getMessage());
//            return null;
//        }
//        System.out.println("Finished loading the graph.");
//        return builder.build();
//    }
//
}
