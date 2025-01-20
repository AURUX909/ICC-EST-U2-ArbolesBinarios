import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import main.Ejercicio_02_invert.InvertBinaryTree;
import main.Ejercicio_03_listLevels.ListLevels;
import main.Ejercicio_04_depth.Depth;
import main.Materia.Controllers.ArbolAVL;
import main.Materia.Controllers.ArbolBinario;
import main.Materia.Controllers.ArbolRecorrido;
import main.Materia.Controllers.Graph;
import main.Materia.Modelo.Node;
import main.Materia.Modelo.NodeG;

public class App {
    private static ArbolBinario arbolBinario;
    private static ArbolRecorrido arbolRecorrido;
    private static final int[] VALORES = { 40, 20, 60, 10, 30, 50, 70, 5, 15, 55 };

    public static void main(String[] args) {
        System.out.println("==GRAPH==");
        runGraph();

        /*
         * System.out.println("=== EJERCICIO 1: Insertar en BST ===");
         * runEjercicio1();
         * 
         * System.out.println("\n=== EJERCICIO 2: Invertir Árbol Binario ===");
         * runEjercicio2();
         * 
         * System.out.println("\n=== EJERCICIO 3: Listar por Niveles ===");
         * runEjercicio3();
         * 
         * System.out.println("\n=== EJERCICIO 4: Calcular Profundidad ===");
         * runEjercicio4();
         * 
         * inicializarArboles();
         * runArbolAvl();
         * 
         * System.out.println("\nÁrbol Binario:");
         * arbolBinario.printTree();
         * 
         * System.out.println("\nPreorden Iterativo:");
         * arbolRecorrido.preorderIterativo(arbolBinario.getRoot());
         * 
         * System.out.println("\nPreorden Recursivo:");
         * arbolRecorrido.preOrderRecursivo(arbolBinario.getRoot());
         * 
         * System.out.println("\nPostorden:");
         * arbolRecorrido.posOrderRecursivo(arbolBinario.getRoot());
         * 
         * System.out.println("\nInorden:");
         * arbolRecorrido.InOrderRecursivo(arbolBinario.getRoot());
         */
    }

    private static void runArbolAvl() {
        System.out.println("\nArbolAVL");
        int[] values = { 10, 20, 15, 24, 9, 8, 21, 23, 50, 25 };
        ArbolAVL arbolAvl = new ArbolAVL();
        for (int value : values) {
            arbolAvl.insert(value);
            arbolAvl.printTree();
        }

    }

    private static void inicializarArboles() {
        arbolBinario = new ArbolBinario();
        arbolRecorrido = new ArbolRecorrido();

        for (int valor : VALORES) {
            arbolBinario.insert(valor);
        }
    }

    private static void imprimirArbolSimple(Node root) {
        if (root == null) {
            return;
        }
        Queue<Node> cola = new LinkedList<>();
        cola.add(root);

        while (!cola.isEmpty()) {
            int size = cola.size();
            for (int i = 0; i < size; i++) {
                Node nodo = cola.poll();
                if (nodo != null) {
                    System.out.print(nodo.getValue() + " ");
                    cola.add(nodo.getLeft());
                    cola.add(nodo.getRight());
                } else {
                    System.out.print("null ");
                }
            }
            System.out.println();
        }
    }

    private static void runEjercicio1() {
        ArbolBinario arbol = new ArbolBinario();
        int[] valores = { 5, 3, 7, 2, 4, 6, 8 };

        for (int valor : valores) {
            arbol.insert(valor);
        }

        System.out.println("Arbol BST resultante:");
        arbol.printTree();
    }

    private static void runEjercicio2() {
        ArbolBinario arbol = new ArbolBinario();
        int[] valores = { 4, 2, 7, 1, 3, 6, 9 };

        for (int valor : valores) {
            arbol.insert(valor);
        }

        System.out.println("Arbol original:");
        arbol.printTree();

        InvertBinaryTree inversor = new InvertBinaryTree();
        Node invertido = inversor.invertTree(arbol.getRoot());

        System.out.println("\nArbol invertido:");
        arbol.printTree2(invertido, "", true);

        System.out.println("\nFormato niveles del arbol invertido:");
        List<List<Node>> niveles = new ListLevels().listLevels(invertido);
        for (List<Node> nivel : niveles) {
            for (int i = 0; i < nivel.size(); i++) {
                System.out.print(nivel.get(i).getValue());
                if (i < nivel.size() - 1) {
                    System.out.print(" -> ");
                }
            }
            System.out.println();
        }
    }

    private static void runEjercicio4() {
        ArbolBinario arbol = new ArbolBinario();
        int[] valores = { 4, 2, 7, 1, 3, 6, 9 };

        for (int valor : valores) {
            arbol.insert(valor);
        }

        System.out.println("Arbol para calcular profundidad:");
        arbol.printTree();

        Depth profundidad = new Depth();
        int maxDepth = profundidad.maxDepth(arbol.getRoot());

        System.out.println("\nFormato niveles:");
        List<List<Node>> niveles = new ListLevels().listLevels(arbol.getRoot());
        for (List<Node> nivel : niveles) {
            for (int i = 0; i < nivel.size(); i++) {
                System.out.print(nivel.get(i).getValue());
                if (i < nivel.size() - 1) {
                    System.out.print(" -> ");
                }
            }
            System.out.println();
        }

        System.out.println("\nProfundidad maxima: " + maxDepth);
    }

    public static void runEjercicio3() {
        ArbolBinario arbolBinario = new ArbolBinario();
        ListLevels levels = new ListLevels();
        int[] valores = { 4, 2, 7, 1, 3, 6, 9 };

        for (int valor : valores) {
            arbolBinario.insert(valor);
        }

        System.out.println("\nÁrbol para el Ejercicio 3:");
        arbolBinario.printTree();

        List<List<Node>> niveles = levels.listLevels(arbolBinario.getRoot());

        System.out.println("\nFormato Simple:");
        for (List<Node> nivel : niveles) {
            for (int i = 0; i < nivel.size(); i++) {
                System.out.print(nivel.get(i).getValue());
                if (i < nivel.size() - 1) {
                    System.out.print("->");
                }
            }
            System.out.println();
        }

        System.out.println("\nFormato Detallado:");
        for (int i = 0; i < niveles.size(); i++) {
            List<Node> nivel = niveles.get(i);
            System.out.print("Nivel " + (i + 1) + ": [ ");
            for (int j = 0; j < nivel.size(); j++) {
                System.out.print(nivel.get(j).getValue());
                if (j < nivel.size() - 1) {
                    System.out.print(" , ");
                }
            }
            System.out.println(" ]");
        }
    }

    private static void runGraph() {
        // [Previous grafoNoDirigido code remains exactly the same]
        Graph grafoNoDirigido = new Graph();
        
        NodeG node5 = grafoNoDirigido.addNode(5);
        NodeG node7 = grafoNoDirigido.addNode(7);
        NodeG node9 = grafoNoDirigido.addNode(9);
        NodeG node11 = grafoNoDirigido.addNode(11);
        NodeG node3 = grafoNoDirigido.addNode(3);
        
        grafoNoDirigido.addEdge(node5, node7);
        grafoNoDirigido.addEdge(node5, node3);
        grafoNoDirigido.addEdge(node5, node9);
        grafoNoDirigido.addEdge(node7, node9);
        grafoNoDirigido.addEdge(node3, node11);
        grafoNoDirigido.addEdge(node3, node9);
        
        System.out.println("Grafo No Dirigido:");
        grafoNoDirigido.printGraph();
        grafoNoDirigido.getBFS(node5);
        grafoNoDirigido.getDFS(node5);
        
        // [Previous grafoDirigido code remains exactly the same]
        Graph grafoDirigido = new Graph();
        
        NodeG node0 = grafoDirigido.addNode(0);
        NodeG node1 = grafoDirigido.addNode(1);
        NodeG node2 = grafoDirigido.addNode(2);
        NodeG node3Dirigido = grafoDirigido.addNode(3);
        NodeG node4 = grafoDirigido.addNode(4);
        NodeG node5Dirigido = grafoDirigido.addNode(5);
        
        grafoDirigido.addEdgeUmi(node0, node3Dirigido);
        grafoDirigido.addEdgeUmi(node0, node5Dirigido);
        grafoDirigido.addEdgeUmi(node1, node0);
        grafoDirigido.addEdgeUmi(node2, node1);
        grafoDirigido.addEdgeUmi(node3Dirigido, node2);
        grafoDirigido.addEdgeUmi(node3Dirigido, node4);
        grafoDirigido.addEdgeUmi(node4, node1);
        
        System.out.println("\nGrafo Dirigido:");
        grafoDirigido.printGraph();
        System.out.println("\nDIRECCIONAL");
        grafoDirigido.getDFS(node0);
        grafoDirigido.getBFS(node0);
        
        // [Previous no direccional code remains the same]
        grafoDirigido.addEdge(node0, node3Dirigido);
        grafoDirigido.addEdge(node0, node5Dirigido);
        grafoDirigido.addEdge(node1, node0);
        grafoDirigido.addEdge(node2, node1);
        grafoDirigido.addEdge(node3Dirigido, node2);
        grafoDirigido.addEdge(node3Dirigido, node4);
        grafoDirigido.addEdge(node4, node1);
        
        System.out.println("\nNO DIRECCIONAL");
        grafoDirigido.getDFS(node0);
        grafoDirigido.getBFS(node0);
        
        // New graph implementation from the image
        Graph nuevoGrafo = new Graph();
        
        // Create nodes 0-9
        NodeG[] nodes = new NodeG[10];
        for (int i = 0; i < 10; i++) {
            nodes[i] = nuevoGrafo.addNode(i);
        }
        
        // Add directed edges according to the image
        nuevoGrafo.addEdgeUmi(nodes[0], nodes[1]);
        nuevoGrafo.addEdgeUmi(nodes[0], nodes[3]);
        nuevoGrafo.addEdgeUmi(nodes[0], nodes[5]);
        nuevoGrafo.addEdgeUmi(nodes[1], nodes[2]);
        nuevoGrafo.addEdgeUmi(nodes[1], nodes[4]);
        nuevoGrafo.addEdgeUmi(nodes[1], nodes[8]);
        nuevoGrafo.addEdgeUmi(nodes[2], nodes[3]);
        nuevoGrafo.addEdgeUmi(nodes[3], nodes[4]);
        nuevoGrafo.addEdgeUmi(nodes[3], nodes[7]);
        nuevoGrafo.addEdgeUmi(nodes[3], nodes[9]);
        nuevoGrafo.addEdgeUmi(nodes[7], nodes[3]);
        nuevoGrafo.addEdgeUmi(nodes[7], nodes[8]);
        
        System.out.println("\nNuevo Grafo Dirigido:");
        nuevoGrafo.printGraph();
        
        System.out.println("DFS desde el nodo 0:");
        nuevoGrafo.getDFS(nodes[0]);
        
        System.out.println("DFS desde el nodo 0 hasta el nodo 7: " + 
            nuevoGrafo.hasPathDFS(nodes[0], nodes[7]));
    }   
}