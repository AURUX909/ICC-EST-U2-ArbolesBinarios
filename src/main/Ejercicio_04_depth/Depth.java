package main.Ejercicio_04_depth;

import main.Materia.Modelo.Node;

public class Depth {
    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        
        int leftDepth = maxDepth(root.getLeft());
        int rightDepth = maxDepth(root.getRight());
        
        return Math.max(leftDepth, rightDepth) + 1;
    }
}