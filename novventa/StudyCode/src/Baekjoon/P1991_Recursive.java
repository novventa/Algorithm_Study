package Baekjoon;

import java.util.Scanner;

class Node {
    char V;
    Node left;
    Node right;

    public Node(char V) {
        this.V = V;
    }
}

class Tree {

    Node root;

    public void add(char V, char l_V, char r_V) {
        if (root == null) {
            if (V != '.')
                root = new Node(V);
            if (l_V != '.')
                root.left = new Node(l_V);
            if (r_V != '.')
                root.right = new Node(r_V);
        } else
            search(root, V, l_V, r_V);
    }

    public void search(Node root2, char V, char l_V, char r_V) {
        if (root == null)
            return;
        else if (root.V == V) {
            if (l_V != '.')
                root.left = new Node(l_V);
            if (r_V != '.')
                root.right = new Node(r_V);
        } else {
            search(root.left, V, l_V, r_V);
            search(root.right, V, l_V, r_V);
        }
    }

    public void preOrder(Node root) {
        System.out.println(root.V);

        if (root.left != null)
            preOrder(root.left);
        if (root.right != null)
            preOrder(root.right);
    }

    public void inOrder(Node root) {
        if (root.left != null)
            inOrder(root.left);

        System.out.println(root.V);

        if (root.right != null)
            inOrder(root.right);
    }

    public void postOrder(Node root) {
        if (root.left != null)
            postOrder(root.left);
        if (root.right != null)
            postOrder(root.right);

        System.out.println(root.V);
    }

}

public class P1991_Recursive {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        Tree tree = new Tree();

        for (int i = 0; i < N; i++) {
            tree.add(sc.next().charAt(0), sc.next().charAt(0), sc.next().charAt(0));
        }

        tree.preOrder(tree.root);
        System.out.println();
        tree.inOrder(tree.root);
        System.out.println();
        tree.postOrder(tree.root);
    }
}