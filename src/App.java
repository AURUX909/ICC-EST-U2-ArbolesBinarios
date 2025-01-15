import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import main.Ejercicio_02_invert.InvertBinaryTree;
import main.Ejercicio_03_listLevels.ListLevels;
import main.Ejercicio_04_depth.Depth;
import main.Materia.Controllers.ArbolAVL;
import main.Materia.Controllers.ArbolBinario;
import main.Materia.Controllers.ArbolRecorrido;
import main.Materia.Modelo.Node;

public class App {
    private static ArbolBinario arbolBinario;
    private static ArbolRecorrido arbolRecorrido;
    private static final int[] VALORES = { 40, 20, 60, 10, 30, 50, 70, 5, 15, 55 };

    public static void main(String[] args) {
        System.out.println("=== EJERCICIO 1: Insertar en BST ===");
        runEjercicio1();

        System.out.println("\n=== EJERCICIO 2: Invertir Árbol Binario ===");
        runEjercicio2();

        System.out.println("\n=== EJERCICIO 3: Listar por Niveles ===");
        runEjercicio3();

        System.out.println("\n=== EJERCICIO 4: Calcular Profundidad ===");
        runEjercicio4();

        inicializarArboles();
        runArbolAvl();

        System.out.println("\nÁrbol Binario:");
        arbolBinario.printTree();

        System.out.println("\nPreorden Iterativo:");
        arbolRecorrido.preorderIterativo(arbolBinario.getRoot());

        System.out.println("\nPreorden Recursivo:");
        arbolRecorrido.preOrderRecursivo(arbolBinario.getRoot());

        System.out.println("\nPostorden:");
        arbolRecorrido.posOrderRecursivo(arbolBinario.getRoot());

        System.out.println("\nInorden:");
        arbolRecorrido.InOrderRecursivo(arbolBinario.getRoot());
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
        int[] valores = {5, 3, 7, 2, 4, 6, 8};
        
        for (int valor : valores) {
            arbol.insert(valor);
        }
        
        System.out.println("Arbol BST resultante:");
        arbol.printTree();
    }
    
    private static void runEjercicio2() {
        ArbolBinario arbol = new ArbolBinario();
        int[] valores = {4, 2, 7, 1, 3, 6, 9};
        
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
        int[] valores = {4, 2, 7, 1, 3, 6, 9}; 
        
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
}