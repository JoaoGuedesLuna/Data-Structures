package std.guedes.mybinarysearchtree;

import std.guedes.mybinarysearchtree.util.MyBinarySearchTree;
import std.guedes.mybinarysearchtree.util.MyBinaryTree;
import std.guedes.mybinarysearchtree.util.Node;

/**
 * @author João Guedes.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("---------------------- ÁRVORE BINÁRIA ----------------------");
        MyBinaryTree<Integer> binaryTree = new MyBinaryTree<>(7);
        binaryTree.getRoot().setLeft(new Node<>(18));
        binaryTree.getRoot().getLeft().setLeft(new Node<>(14));
        binaryTree.getRoot().getLeft().getLeft().setLeft(new Node<>(15));
        binaryTree.getRoot().setRight(new Node<>(16));
        binaryTree.getRoot().getRight().setLeft(new Node<>(12));
        binaryTree.getRoot().getRight().getLeft().setRight(new Node<>(9));
        binaryTree.getRoot().getRight().setRight(new Node<>(23));
        binaryTree.getRoot().getRight().getRight().setRight(new Node<>(3));
        binaryTree.getRoot().getRight().getRight().getRight().setLeft(new Node<>(37));
        binaryTree.getRoot().getRight().getRight().getRight().getLeft().setLeft(new Node<>(14));
        System.out.println("Percurso em pré ordem: " + binaryTree.preorderTraversal());
        System.out.println("Percurso em ordem: " + binaryTree.inorderTraversal());
        System.out.println("Percurso em pós ordem: " + binaryTree.postorderTraversal());
        System.out.println("Altura da árvore: " + binaryTree.height());
        System.out.println("------------------ ÁRVORE BINÁRIA DE BUSCA ------------------");
        MyBinarySearchTree<Integer> binarySearchTree = new MyBinarySearchTree<>();
        binarySearchTree.add(7);
        binarySearchTree.add(18);
        binarySearchTree.add(14);
        binarySearchTree.add(15);
        binarySearchTree.add(16);
        binarySearchTree.add(12);
        binarySearchTree.add(9);
        binarySearchTree.add(23);
        binarySearchTree.add(3);
        binarySearchTree.add(37);
        binarySearchTree.add(14);
        System.out.println("Percurso em pré ordem: " + binarySearchTree.preorderTraversal());
        System.out.println("Percurso em ordem: " + binarySearchTree.inorderTraversal());
        System.out.println("Percurso em pós ordem: " + binarySearchTree.postorderTraversal());
        System.out.println("Altura da árvore: " + binarySearchTree.height());
        System.out.println("Removendo elemento 14... ");
        binarySearchTree.remove(14);
        System.out.println("Árvore: " + binarySearchTree);
        System.out.println("Altura da árvore: " + binarySearchTree.height());
        System.out.println("Removendo raiz...");
        binarySearchTree.remove(binarySearchTree.getRoot().getData());
        System.out.println("Árvore: " + binarySearchTree);
        System.out.println("Altura da árvore: " + binarySearchTree.height());
        System.out.println("Menor elemento da árvore: " + binarySearchTree.min());
        System.out.println("Maior elemento da árvore: " + binarySearchTree.max());
        System.out.println("-------------- SUB ÁRVORE BINÁRIA DE BUSCA (14) --------------");
        MyBinarySearchTree<Integer> subBinarySearchTree = binarySearchTree.search(14);
        System.out.println("Percurso em pré ordem: " + subBinarySearchTree.preorderTraversal());
        System.out.println("Percurso em ordem: " + subBinarySearchTree.inorderTraversal());
        System.out.println("Percurso em pós ordem: " + subBinarySearchTree.postorderTraversal());
        System.out.println("Altura da sub árvore: " + subBinarySearchTree.height());
        System.out.println("Árvore: " + subBinarySearchTree);
        System.out.println("Árvore vazia? " + subBinarySearchTree.isEmpty());
        System.out.println("Limpando árvore...");
        subBinarySearchTree.clear();
        System.out.println("Árvore: " + subBinarySearchTree);
        System.out.println("Árvore vazia? " + subBinarySearchTree.isEmpty());
    }

}