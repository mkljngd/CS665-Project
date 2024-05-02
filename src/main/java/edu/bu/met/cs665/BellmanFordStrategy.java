package edu.bu.met.cs665;

import org.jgrapht.Graph;
import org.jgrapht.alg.shortestpath.BellmanFordShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;

import java.util.List;

public class BellmanFordStrategy implements RouteStrategy {

    @Override
    public List<Integer> calculateRoute( Graph<Integer, DefaultWeightedEdge> graph, int startVertex, int endVertex ) {
        BellmanFordShortestPath<Integer, DefaultWeightedEdge> bellmanFord =
                new BellmanFordShortestPath<>(graph);
        return bellmanFord.getPath(startVertex, endVertex).getVertexList();
    }
}

