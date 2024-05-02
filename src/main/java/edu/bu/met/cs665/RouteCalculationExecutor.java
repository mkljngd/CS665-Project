package edu.bu.met.cs665;

import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultWeightedEdge;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class RouteCalculationExecutor {

    private static final Logger LOGGER = Logger.getLogger(RouteCalculationExecutor.class.getName());
    private ExecutorService executor;
    private Graph<Integer, DefaultWeightedEdge> graph;

    public RouteCalculationExecutor(Graph<Integer, DefaultWeightedEdge> graph, int threadCount) {
        this.graph = graph;
        this.executor = Executors.newFixedThreadPool(threadCount); // Creating a fixed thread pool
    }

    public void executeRouteCalculation(int startVertex, int endVertex, RouteStrategy strategy) {
        executor.submit(() -> {
            try {
                List<Integer> route = strategy.calculateRoute(graph, startVertex, endVertex);
                if (route != null && !route.isEmpty()) {
                    LOGGER.info("Route from " + startVertex + " to " + endVertex + ":\n" + formatRoute(route));
                } else {
                    LOGGER.info("No available route from " + startVertex + " to " + endVertex);
                }
            } catch (Exception e) {
                LOGGER.log(Level.SEVERE, "Error calculating route", e);
            }
        });
    }

    private String formatRoute(List<Integer> route) {
        return "Path: " + route.stream().map(Object::toString).collect(Collectors.joining(" -> "));
    }

    public void shutdown() {
        executor.shutdown();
        try {
            if (!executor.awaitTermination(60, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            LOGGER.log(Level.SEVERE, "Thread was interrupted", e);
        }
    }
}

