/**
 * Name: Mukul Jangid
 * Course: CS-665 Software Designs & Patterns
 * Date: 05/02/2024
 * File Name: BellmanFordStrategy.java
 * Description: Implements the Bellman-Ford algorithm to calculate the shortest path in a graph.
 */

package edu.bu.met.cs665;

import java.util.List;
import org.jgrapht.Graph;
import org.jgrapht.alg.shortestpath.BellmanFordShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;

public class BellmanFordStrategy implements RouteStrategy {

  @Override
  public List<Integer> calculateRoute(
      Graph<Integer, DefaultWeightedEdge> graph, int startVertex, int endVertex) {
    BellmanFordShortestPath<Integer, DefaultWeightedEdge> bellmanFord =
        new BellmanFordShortestPath<>(graph);
    return bellmanFord.getPath(startVertex, endVertex).getVertexList();
  }
}
