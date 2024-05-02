package edu.bu.met.cs665;

import java.util.List;
import org.jgrapht.Graph;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;

public class DijkstraStrategy implements RouteStrategy {

  @Override
  public List<Integer> calculateRoute(
      Graph<Integer, DefaultWeightedEdge> graph, int startVertex, int endVertex) {
    DijkstraShortestPath<Integer, DefaultWeightedEdge> dijkstra = new DijkstraShortestPath<>(graph);
    return dijkstra.getPath(startVertex, endVertex).getVertexList();
  }
}
