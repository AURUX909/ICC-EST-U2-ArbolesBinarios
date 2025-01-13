package main.Materia.Controllers;

import main.Materia.Modelo.Node;

public class ArbolAVL {
    private Node root;

    public void insert(int value) {
        System.out.println("Nodo a insertar: " + value);
        root = insert(root, value);
        System.out.println("Nodo insertado " + value + ", Balance: " + getBalance(root));
        System.out.println("───────");
        printTree();
    }

    private Node insert(Node node, int value) {
        if (node == null) {
            Node newNode = new Node(value);
            newNode.setHeight(1);
            return newNode;
        }

        if (value < node.getValue()) {
            node.setLeft(insert(node.getLeft(), value));
        } else if (value > node.getValue()) {
            node.setRight(insert(node.getRight(), value));
        } else {
            System.out.println("Duplicado: " + value);
            return node;
        }

        node.setHeight(1 + Math.max(height(node.getLeft()), height(node.getRight())));
        int balance = getBalance(node);

        System.out.println(" -Nodo actual: " + node.getValue());
        System.out.println("             Altura del nodo: " + node.getValue() + " es = " + node.getHeight());
        System.out.println("             Equilibrio del nodo: " + node.getValue() + " = " + balance);

        // Rotaciones
        if (balance > 1 && value < node.getLeft().getValue()) {
            System.out.println("             Izquierda-Izquierda a nodo " + node.getValue());
            Node rotatedNode = rigthRotate(node);
            printTree();
            return rotatedNode;
        }
        if (balance < -1 && value > node.getRight().getValue()) {
            System.out.println("             Derecha-Derecha a nodo " + node.getValue());
            Node rotatedNode = leftRotate(node);
            printTree();
            return rotatedNode;
        }
        if (balance > 1 && value > node.getLeft().getValue()) {
            System.out.println("             Izquierda-Derecha a nodo " + node.getValue());
            node.setLeft(leftRotate(node.getLeft()));
            printTree();
            Node rotatedNode = rigthRotate(node);
            printTree();
            return rotatedNode;
        }
        if (balance < -1 && value < node.getRight().getValue()) {
            System.out.println("             Derecha-Izquierda a nodo " + node.getValue());
            node.setRight(rigthRotate(node.getRight()));
            printTree();
            Node rotatedNode = leftRotate(node);
            printTree();
            return rotatedNode;
        }

        return node;
    }

    private Node rigthRotate(Node y) {
        Node x = y.getLeft();
        Node temp = x.getRight();
        System.out.println("Rotacion Derecha en nodo: " + y.getValue() + ", Balance " + getBalance(y));
        x.setRight(y);
        y.setLeft(temp);
        y.setHeight(Math.max(height(y.getLeft()), height(y.getRight())) + 1);
        x.setHeight(Math.max(height(x.getLeft()), height(x.getRight())) + 1);
        System.out.println("Nueva Raiz despues de rotacion derecha: " + x.getValue());
        return x;
    }

    private Node leftRotate(Node x) {
        Node y = x.getRight();
        Node temp = y.getLeft();
        System.out.println("Rotacion Izquierda en nodo: " + x.getValue() + ", Balance " + getBalance(x));
        y.setLeft(x);
        x.setRight(temp);
        x.setHeight(Math.max(height(x.getLeft()), height(x.getRight())) + 1);
        y.setHeight(Math.max(height(y.getLeft()), height(y.getRight())) + 1);
        System.out.println("Nueva raiz despues de rotacion izquierda: " + y.getValue());
        return y;
    }

    private int height(Node node) {
        if (node == null) {
            return 0;
        }
        return node.getHeight();
    }

    private int getBalance(Node node) {
        if (node == null) {
            return 0;
        }
        return height(node.getLeft()) - height(node.getRight());
    }

    public void printTree() {
        printTree(root, " ", true);
    }

    private void printTree(Node node, String prefix, boolean isLeft) {
        if (node != null) {
            System.out.println(prefix + (isLeft ? "├──" : "└──") + node.getValue());
            if (node.getLeft() != null || node.getRight() != null) {
                if (node.getLeft() != null) {
                    printTree(node.getLeft(), prefix + (isLeft ? "│  " : "   "), true);
                } else {
                    System.out.println(prefix + (isLeft ? "│  " : "   ") + "├── null");
                }

                if (node.getRight() != null) {
                    printTree(node.getRight(), prefix + (isLeft ? "│  " : "   "), false);
                } else {
                    System.out.println(prefix + (isLeft ? "│  " : "   ") + "└── null");
                }
            }
        }
    }
}
