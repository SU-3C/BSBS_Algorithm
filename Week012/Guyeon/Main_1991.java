package week12;

import java.io.*;

public class Main_1991 {
    static TreeNode[] tn;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char root, left, right;
        String[] in;
        tn = new TreeNode[n];
        for (int i = 0; i < n; i++) {
            in = br.readLine().split(" ");
            root = in[0].charAt(0);
            left = in[1].charAt(0);
            right = in[2].charAt(0);
            tn[root-'A'] = new TreeNode(root, left, right);
        }
        preorder(tn[0]); bw.write("\n");
        inorder(tn[0]); bw.write("\n");
        postorder(tn[0]);
        bw.flush();
    }
    static void preorder(TreeNode node) throws IOException {
        bw.write(node.getRoot()+"");
        if(node.getLeft() != '.')
            preorder(tn[node.getLeft()-'A']);
        if(node.getRight() != '.')
            preorder(tn[node.getRight()-'A']);
    }

    static void inorder(TreeNode node) throws IOException {
        if(node.getLeft() != '.')
            inorder(tn[node.getLeft()-'A']);
        bw.write(node.getRoot()+"");
        if(node.getRight() != '.')
            inorder(tn[node.getRight()-'A']);
    }

    static void postorder(TreeNode node) throws IOException {
        if(node.getLeft() != '.')
            postorder(tn[node.getLeft()-'A']);
        if(node.getRight() != '.')
            postorder(tn[node.getRight()-'A']);
        bw.write(node.getRoot()+"");
    }
}
class TreeNode{
    private char root, left, right;
    public TreeNode(char root, char left, char right) {
        this.root = root;
        this.left = left;
        this.right = right;
    }
    public char getRoot() {
        return root;
    }
    public char getLeft() {
        return left;
    }
    public char getRight() {
        return right;
    }
}