package main.Ejercicio_03_listLevels;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import main.Materia.Modelo.Node;

public class ListLevels {
    public List<List<Node>> listLevels(Node root) {
        if (root == null) {
            return new ArrayList<>(); // Devuelve una lista vacía si el árbol está vacío.
        }

        List<List<Node>> result = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size(); // Número de nodos en el nivel actual.
            List<Node> currentLevel = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                Node currentNode = queue.poll();
                currentLevel.add(currentNode);

                if (currentNode.getLeft() != null) {
                    queue.add(currentNode.getLeft());
                }
                if (currentNode.getRight() != null) {
                    queue.add(currentNode.getRight());
                }
            }

            result.add(currentLevel); // Agrega el nivel completo a la lista de resultados.
        }

        return result;
    }
}