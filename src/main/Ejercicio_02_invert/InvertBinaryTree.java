package main.Ejercicio_02_invert;

import main.Materia.Modelo.Node;

public class InvertBinaryTree {
    public Node invertTree(Node root) {
        if (root == null) {
            return null;
        }
        
        // Invertir recursivamente los subárboles
        Node left = invertTree(root.getLeft());
        Node right = invertTree(root.getRight());
        
        // Intercambiar los hijos
        root.setLeft(right);
        root.setRight(left);
        
        return root;
    }
}
