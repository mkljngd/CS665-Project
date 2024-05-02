package edu.bu.met.cs665;

import java.util.List;
import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultWeightedEdge;

public interface RouteStrategy {
  List<Integer> calculateRoute(
      Graph<Integer, DefaultWeightedEdge> graph, int startVertex, int endVertex);
}
