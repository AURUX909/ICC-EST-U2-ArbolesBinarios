import main.Ejercicio_03_listLevels.ListLevels;
import main.Materia.Controllers.ArbolBinario;
import main.Materia.Controllers.ArbolRecorrido;
import main.Materia.Modelo.Node;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class App {
    private static ArbolBinario arbolBinario;
    private static ArbolRecorrido arbolRecorrido;
    private static final int[] VALORES = {40, 20, 60, 10, 30, 50, 70, 5, 15, 55};

    public static void main(String[] args) {
        runEjercicio3(); // Llamada al ejercicio 3.
        inicializarArboles(); // Inicializa árboles para otros ejercicios.

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
    // Usamos una cola para realizar un recorrido nivel por nivel.
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
        System.out.println(); // Salto de línea después de cada nivel.
    }
}


    public static void runEjercicio3() {
        ArbolBinario arbolBinario = new ArbolBinario();
        ListLevels levels = new ListLevels();
        int[] valores = {4, 2, 7, 1, 3, 6, 9}; // Valores para el árbol de ejemplo.

        // Construcción del árbol.
        for (int valor : valores) {
            arbolBinario.insert(valor);
        }

        // Imprime la estructura del árbol.
        System.out.println("\nÁrbol para el Ejercicio 3:");
        arbolBinario.printTree();

        // Obtiene los niveles del árbol.
        List<List<Node>> niveles = levels.listLevels(arbolBinario.getRoot());

        // Impresión en formato simple.
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

        // Impresión en formato detallado.
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