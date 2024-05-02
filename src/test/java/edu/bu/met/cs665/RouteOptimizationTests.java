/**
 * Name: Mukul Jangid
 * Course: CS-665 Software Designs & Patterns
 * Date: 04/12/2024
 * File Name: DriverNotificationTest.java
 * Description: Test cases for the assignment.
 */

package edu.bu.met.cs665;

import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.BufferedReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class RouteOptimizationTests {

  @Test
  public void testGraphBuilding() {
    GraphBuilder<Integer, DefaultWeightedEdge> builder = new GraphBuilder<>();
    builder.addVertex(1).addVertex(2).addEdge(1, 2, 5.0);
    Graph<Integer, DefaultWeightedEdge> graph = builder.build();

    assertTrue(graph.containsVertex(1));
    assertTrue(graph.containsVertex(2));
    assertTrue(graph.containsEdge(1, 2));
    assertEquals(5.0, graph.getEdgeWeight(graph.getEdge(1, 2)), 0.01);
  }

  @Test
  public void testDijkstraAlgorithm() {
    GraphBuilder<Integer, DefaultWeightedEdge> builder = new GraphBuilder<>();
    builder.addVertex(1).addVertex(2).addVertex(3);
    builder.addEdge(1, 2, 1.0).addEdge(2, 3, 2.0).addEdge(1, 3, 4.0);
    Graph<Integer, DefaultWeightedEdge> graph = builder.build();
    DijkstraStrategy strategy = new DijkstraStrategy();

    List<Integer> path = strategy.calculateRoute(graph, 1, 3);

    assertEquals(Arrays.asList(1, 2, 3), path);
  }

  @Test
  public void testBellmanFordAlgorithm() {
    GraphBuilder<Integer, DefaultWeightedEdge> builder = new GraphBuilder<>();
    builder.addVertex(1).addVertex(2).addVertex(3);
    builder.addEdge(1, 2, -1.0).addEdge(2, 3, 2.0).addEdge(1, 3, 2.0);
    Graph<Integer, DefaultWeightedEdge> graph = builder.build();
    BellmanFordStrategy strategy = new BellmanFordStrategy();

    List<Integer> path = strategy.calculateRoute(graph, 1, 3);

    assertEquals(Arrays.asList(1, 2, 3), path);
  }

  @Test
  public void testRouteCalculationExecution() {
    // Assuming that there is a method to check output in the logger or files
    GraphBuilder<Integer, DefaultWeightedEdge> builder = new GraphBuilder<>();
    builder.addVertex(1).addVertex(2).addEdge(1, 2, 1.0);
    Graph<Integer, DefaultWeightedEdge> graph = builder.build();
    RouteCalculationExecutor executor = new RouteCalculationExecutor(graph, 1);
    DijkstraStrategy strategy = new DijkstraStrategy();

    executor.executeRouteCalculation(1, 2, strategy);
    executor.shutdown();

    // You would need to verify the log file or output stream here to check the result
  }

  @Test
  public void testGraphLoadingFromFile() throws Exception {
    // Prepare the data as a string and pass it to a BufferedReader
    String data = "1\t2\t1.0\n2\t3\t2.0";
    BufferedReader reader = new BufferedReader(new StringReader(data));

    // Pass the BufferedReader directly to the loadGraph method
    Graph<Integer, DefaultWeightedEdge> graph = RoadNetworkLoader.loadGraph(reader);

    assertNotNull(graph);
    assertTrue(graph.containsVertex(1));
    assertTrue(graph.containsVertex(2));
    assertTrue(graph.containsVertex(3));
    assertTrue(graph.containsEdge(1, 2));
    assertTrue(graph.containsEdge(2, 3));
    assertEquals(1.0, graph.getEdgeWeight(graph.getEdge(1, 2)), 0.01);
    assertEquals(2.0, graph.getEdgeWeight(graph.getEdge(2, 3)), 0.01);
  }


}


