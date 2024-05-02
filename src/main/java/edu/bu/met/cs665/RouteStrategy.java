package edu.bu.met.cs665;

import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultWeightedEdge;

import java.util.List;

public interface RouteStrategy {
    List<Integer> calculateRoute(
            Graph<Integer, DefaultWeightedEdge> graph,
            int startVertex,
            int endVertex
    );
}


