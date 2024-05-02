package edu.bu.met.cs665;


import org.jgrapht.Graph;

import org.jgrapht.graph.DefaultDirectedWeightedGraph;
import org.jgrapht.graph.DefaultWeightedEdge;
public class GraphBuilder<V, E> {
    private Graph<V, E> graph;

    public GraphBuilder() {
        this.graph = (Graph<V, E>) new DefaultDirectedWeightedGraph<>(DefaultWeightedEdge.class);
    }

    public GraphBuilder<V, E> addVertex(V vertex) {
        graph.addVertex(vertex);
        return this;
    }

    public GraphBuilder<V, E> addEdge(V sourceVertex, V targetVertex, double weight) {
        graph.addVertex(sourceVertex);
        graph.addVertex(targetVertex);
        E edge = graph.addEdge(sourceVertex, targetVertex);
        graph.setEdgeWeight(edge, weight);
        return this;
    }

    public Graph<V, E> build() {
        return graph;
    }
}

