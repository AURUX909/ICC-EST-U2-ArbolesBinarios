package main.Materia.Controllers;

import main.Materia.Modelo.NodeG;
import java.util.ArrayList;
import java.util.List;

public class Graph {
    private List<NodeG> nodes;

    public Graph() {
        this.nodes = new ArrayList<>();
    }

    public NodeG addNode(int value) {
        NodeG nodeGraph = new NodeG(value);
        nodes.add(nodeGraph);
        return nodeGraph;
    }

    public void addEdge(NodeG src, NodeG dest) {
        if (src != null && dest != null) {
            src.addNeighbor(dest);
            dest.addNeighbor(src);
        }
    }

    public void printGraph() {
        for (NodeG nodeGraph : nodes) {
            System.out.print("Vertice " + nodeGraph.getValue() + ": ");
            for (NodeG neighbor : nodeGraph.getNeighbors()) {
                System.out.print(neighbor.getValue() + " - ");
            }
            System.out.println();
        }
    }

    public void getDFS(NodeG startNode) {
        boolean[] visited = new boolean[nodes.size()];
        getDFSUtil(startNode, visited);
    }

    private void getDFSUtil(NodeG nodeGraph, boolean[] visited) {
        visited[nodes.indexOf(nodeGraph)] = true;
        System.out.print(nodeGraph.getValue() + " ");

        for (NodeG neighbor : nodeGraph.getNeighbors()) {
            if (!visited[nodes.indexOf(neighbor)]) {
                getDFSUtil(neighbor, visited);
            }
        }
    }

    public void getBFS(NodeG startNode) {
        boolean[] visited = new boolean[nodes.size()];
        ArrayList<NodeG> queue = new ArrayList<>();

        visited[nodes.indexOf(startNode)] = true;
        queue.add(startNode);

        while (!queue.isEmpty()) {
            NodeG nodeGraph = queue.remove(0);
            System.out.print(nodeGraph.getValue() + " ");

            for (NodeG neighbor : nodeGraph.getNeighbors()) {
                if (!visited[nodes.indexOf(neighbor)]) {
                    visited[nodes.indexOf(neighbor)] = true;
                    queue.add(neighbor);
                }
            }
        }
    }

    public int[][] getAdjacencyMatrix() {
        int size = nodes.size();
        int[][] matrix = new int[size][size];

        for (int i = 0; i < size; i++) {
            NodeG nodeGraph = nodes.get(i);
            for (NodeG neighbor : nodeGraph.getNeighbors()) {
                matrix[i][nodes.indexOf(neighbor)] = 1;
            }
        }
        return matrix;
    }

    public void printAdjacencyMatrix() {
        int[][] matrix = getAdjacencyMatrix();
        for (int[] row : matrix) {
            for (int cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }
}