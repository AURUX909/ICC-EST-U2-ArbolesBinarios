package main.Materia.Controllers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import main.Materia.Modelo.NodeG;

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

    public void addEdgeUmi(NodeG src, NodeG dest) {
        src.addNeighbor(dest);  
    }

    public void getDFS(NodeG start) {
        if (start == null) return;
        
        Set<NodeG> visitados = new HashSet<>();
        System.out.println("DFS desde el nodo " + start.getValue() + ":");
        getDFSutil(start, visitados);
        System.out.println();
    }
    
    private void getDFSutil(NodeG node, Set<NodeG> visitados) {
        if (node == null || visitados.contains(node)) {
            return;
        }
        visitados.add(node);
        System.out.print(node.getValue() + " ");
        for (NodeG neighbor : node.getNeighbors()) {
            getDFSutil(neighbor, visitados);
        }
    }

    public void getBFS(NodeG start) {
        Set<NodeG> visitados = new HashSet<>();
        Queue<NodeG> cola = new LinkedList<>();
    
        System.out.println("BFS desde el nodo " + start.getValue() + ":");
        cola.add(start); 
        visitados.add(start); 
    
        while (!cola.isEmpty()) {
            NodeG actual = cola.poll();
            System.out.print(actual.getValue() + " ");

            for (NodeG neighbor : actual.getNeighbors()) {
                if (!visitados.contains(neighbor)) {
                    visitados.add(neighbor); 
                    cola.add(neighbor);     
                }
            }
        }
        System.out.println(); 
    }
    public boolean hasPathDFS(NodeG start, NodeG end) {
        if (start == null || end == null) return false;
        Set<NodeG> visitados = new HashSet<>();
        return hasPathDFSUtil(start, end, visitados);
    }
    
    private boolean hasPathDFSUtil(NodeG current, NodeG end, Set<NodeG> visitados) {
        if (current == end) return true;
        if (visitados.contains(current)) return false;
        
        visitados.add(current);
        
        for (NodeG neighbor : current.getNeighbors()) {
            if (hasPathDFSUtil(neighbor, end, visitados)) {
                return true;
            }
        }
        return false;
    }
    
    public boolean hasPathBFS(NodeG start, NodeG end) {
        if (start == null || end == null) return false;
        
        Set<NodeG> visitados = new HashSet<>();
        Queue<NodeG> cola = new LinkedList<>();
        
        cola.add(start);
        visitados.add(start);
        
        while (!cola.isEmpty()) {
            NodeG current = cola.poll();
            if (current == end) return true;
            
            for (NodeG neighbor : current.getNeighbors()) {
                if (!visitados.contains(neighbor)) {
                    visitados.add(neighbor);
                    cola.add(neighbor);
                }
            }
        }
        return false;
    }


    

    /*public void getDFS(NodeG startNode) {
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
        */
}