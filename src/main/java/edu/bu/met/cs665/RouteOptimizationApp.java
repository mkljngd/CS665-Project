package edu.bu.met.cs665;
import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultWeightedEdge;
import java.util.Scanner;

public class RouteOptimizationApp {

    private static final String DATA_FILE_PATH = "roadNet-CA mini.txt";
    private Graph<Integer, DefaultWeightedEdge> graph;

    public RouteOptimizationApp() {
        graph = RoadNetworkLoader.loadGraph(DATA_FILE_PATH);
    }

    public void run() {
        try (Scanner scanner = new Scanner(System.in)) {
            RouteCalculationExecutor executor = new RouteCalculationExecutor(graph, 10); // Configurable thread pool size
            System.out.println("Enter start and end vertices separated by space, choose algorithm: Dijkstra or BellmanFord ('exit' to quit)");

            while (scanner.hasNextLine()) {
                String input = scanner.nextLine();
                if ("exit".equalsIgnoreCase(input)) {
                    break;
                }
                String[] parts = input.split(" ");
                if (parts.length < 3) {
                    System.out.println("Please enter start vertex, end vertex, and algorithm name.");
                    continue;
                }
                int start = Integer.parseInt(parts[0]);
                int end = Integer.parseInt(parts[1]);
                RouteStrategy strategy = "BellmanFord".equalsIgnoreCase(parts[2]) ? new BellmanFordStrategy() : new DijkstraStrategy();

                executor.executeRouteCalculation(start, end, strategy);
            }

            executor.shutdown();
        }
    }

    public static void main(String[] args) {
        new RouteOptimizationApp().run();
    }
}
