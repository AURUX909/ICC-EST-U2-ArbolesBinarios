package main.Materia.Controllers;

import java.util.Stack;

import main.Materia.Modelo.Node;

public class ArbolRecorrido {
    public void preorderIterativo(Node root){
        //VERIFICAR SINO ESTA VACIO
        if(root == null){
            return;
        }
        //PILA PARA MANEJAR LOS NODOS DEL ARBOL DURANTE EL RECORRIDO
        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node node = stack.pop();
            System.out.print(node.getValue() + ", ");

            if(node.getRight() != null){
                stack.push(node.getRight());
            }
            if(node.getLeft() != null){
                stack.push(node.getLeft());

            }
        }
    }
    public void preOrderRecursivo(Node node){
        //VERIFICAR SI EL NODO ESTA VACIO
        if(node != null){
            //IMPRIMIR EL VALOR ACTUAL
            System.out.print(node.getValue() + ", ");
            preOrderRecursivo(node.getLeft());
            preOrderRecursivo(node.getRight());
        }
    }
    public void posOrderRecursivo(Node node){
        if(node != null){
            posOrderRecursivo(node.getLeft());
            posOrderRecursivo(node.getRight());
            System.out.print(node.getValue() + ", ");
        }
    }
    public void InOrderRecursivo(Node node){
        if(node != null){
            InOrderRecursivo(node.getLeft());
            System.out.print(node.getValue() + ", ");
            InOrderRecursivo(node.getRight());
        }
    }
}