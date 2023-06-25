package week12;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.*;

public class Main_1068 {
    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = parseInt(br.readLine());
        String[] in = br.readLine().split(" ");
        int d = parseInt(br.readLine());
        Tree tree = new Tree(n);
        for (int i = 0; i < n; i++) {
            tree.AddNode(new Node2(i, parseInt(in[i])));
        }
        tree.setTreeChild();
        tree.CutTree(d);
        int cnt = tree.search();
        bw.write(cnt + "");
        bw.flush();
    }
}

class Node2 {
    private int value, parent;
    private List<Node2> treechild;
    public Node2(int value, int parent) {
        this.value = value;
        this.parent = parent;
        treechild = new ArrayList<>();
    }
    public int getValue(){ return value; }
    public int getParent(){ return parent; }
    public List<Node2> getTreechild(){ return treechild; }

}
class Tree{
    private Node2[] tree;
    private int ancestor;
    public Tree(int size){
        tree = new Node2[size];
    }
    public void AddNode(Node2 node2){
        int i = node2.getValue();
        tree[i] = node2;
    }
    public void setTreeChild(){
        for (Node2 node2 : tree) {
            if (node2.getParent() != -1)
                tree[node2.getParent()].getTreechild().add(node2);
            else
                ancestor = node2.getValue();
        }
    }
    public void CutTree(int delete) {
        int parent = tree[delete].getParent();
        if(parent != -1) {
            List<Node2> childOfParent = tree[parent].getTreechild();
            for (Node2 node2 : childOfParent) {
                if(node2.getValue() == delete) {
                    tree[parent].getTreechild().remove(node2);
                    break;
                }
            }
        }
        tree[delete] = null;
    }

    private int cnt;
    private boolean[] visited;
    public int search(){
        visited = new boolean[tree.length];
        cnt=0;
        recurTree(ancestor);
        return cnt;
    }
    private void recurTree(int start){
        visited[start] = true;
        if (tree[start] == null) return;
        else if(tree[start].getTreechild().size() == 0)
            cnt++;
        else {
            for(Node2 node2 : tree[start].getTreechild()){
                if (!visited[node2.getValue()])
                    recurTree(node2.getValue());
            }
        }
    }
}

//import java.io.*;
//import java.util.ArrayList;
//import java.util.LinkedList;
//import java.util.List;
//
//public class Main {
//    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//    public static void main(String[] args) throws Exception {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int n = Integer.parseInt(br.readLine());
//        String[] in = br.readLine().split(" ");
//        int d = Integer.parseInt(br.readLine());
//        Tree tree = new Tree(n);
//        Node node;
//        for (int i = 0; i < n; i++) {
//            node = new Node(i, Integer.parseInt(in[i]));
//            tree.AddNode(Integer.parseInt(in[i]), node);
//        }
//        List<Node>[] treeList = tree.getTree();
//
//        for (List<Node> list : treeList) {
//            for (Node node1 : list) {
//                bw.write(node1.getValue() + " ");
//            }bw.write("\n");
//        } bw.write("\n");
//        int cnt = tree.search();
//        bw.write(cnt + "\n");
//        tree.CutTree(d);
//
//        for (List<Node> list : treeList) {
//            if (list != null) {
//                for (Node node1 : list) {
//                    bw.write(node1.getValue() + " ");
//                }
//            }bw.write("\n");
//        } bw.write("\n");
//        cnt = tree.search();
//        bw.write(cnt + "\n");
//        bw.flush();
//    }
//}
//
//class Node{
//    private int value, parent;
//
//    public Node(int value) {
//        this.value = value;
//    }
//    public Node(int value, int parent) {
//        this.value = value;
//        this.parent = parent;
//    }
//    public int getValue(){ return value; }
//    public int getParent(){ return parent; }
//}
//
//class Tree{
//    private List<Node>[] tree;
//    private Main main = new Main();
//    public Tree(int size){
//        tree = new List[size];
//        for (int i = 0; i < size; i++) {
//            tree[i] = new LinkedList<>();
//        }
//    }
//    public void AddNode(int parent, Node node){
//        int i = node.getValue();
//        tree[i].add(node);
//        if (parent != -1) {
//            tree[parent].add(node);
//        }
//    }
//    public List<Node>[] getTree(){
//        return tree;
//    }
//    public void CutTree(int delete) {
//        int parent = tree[delete].get(0).getParent();
//        if(parent != -1) {
//            tree[parent].remove((Object)delete);
//        }
//        tree[delete] = null;
//
////        for (int i = 0; i < tree.length; i++) {
////            if(tree[i].contains(delete)){
////                tree[i].remove(delete);
////                break;
////            }
////        }
////        if( parent == -1 )
////            tree[delete] = null;
////        else if (tree[parent].getLeft() == delete)
////            tree[parent].setLeft(-1);
////        else
////            tree[parent].setRight(-1);
//    }
//
//    private int cnt;
//    public int search() throws IOException {
//        boolean[] visited = new boolean[tree.length];
//        cnt=0;
//        if(tree[0] != null) {
//            main.bw.write("search start\n");
//            recurTree(visited, 0);
//            main.bw.write("search end\n");
//        }
//        return cnt;
//    }
//    private void recurTree(boolean[] visited, int start) throws IOException {
//        main.bw.write("called recultree : " + start + "\n");
//        visited[start] = true;
//        if (tree[start] == null) return;
//        if(tree[start].size() == 1) {
//            main.bw.write("\ncnt++");
//            cnt++;
//        }
//        else {
//            main.bw.write("else called : " + start + "\n");
//            for (int i = 1; i < tree[start].size(); i++) {
//                if (!visited[tree[start].get(i).getValue()])
//                    recurTree(visited, tree[start].get(i).getValue());
//            }
////            for (Node node : tree[start]) {
////                if(node != null && !visited[start]) {
////                    main.bw.write("\nrecul called : " + node.getValue());
////                    recurTree(visited, node.getValue());
////                }
////            }
//        }
//
////        int left = tree[start].getLeft(), right = tree[start].getRight();
////        if (left != -1)
////            if (!visited[left])
////                recurTree(visited, left);
////
////        if (right != -1)
////            if (!visited[right])
////                recurTree(visited, right);
////
////        if (left == -1 && right == -1)
////            cnt ++;
//    }
//}


//        for (int i = 0; i < n; i++) {
//        bw.write(treeA[i].getLeft() + " , " + treeA[i].getValue() + " , " + treeA[i].getRight() + "\n");
//        }



//import java.io.*;
//import java.util.ArrayList;
//import java.util.List;
//
//import static java.lang.Integer.*;
//
//public class Main {
//    public static void main(String[] args) throws Exception {
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int n = parseInt(br.readLine());
//        String[] in = br.readLine().split(" ");
//        int d = parseInt(br.readLine());
//        Tree tree = new Tree(n);
//        for (int i = 0; i < n; i++) {
//            tree.AddNode(new Node(i, parseInt(in[i])));
//        }
//        tree.setTreeChild();
//        Node[] treeList = tree.getTree();
//
//        for (Node node : treeList) {
//            bw.write(node.getValue() + " : ");
//            for (Node node1 : node.getTreechild()) {
//                bw.write(node1.getValue() + " ");
//            }bw.write("\n");
//        } bw.write("\n");
//        tree.CutTree(d);
//        for (Node node : treeList) {
//            if(node != null) {
//                bw.write(node.getValue() + " : ");
//                for (Node node1 : node.getTreechild()) {
//                    bw.write(node1.getValue() + " ");
//                }
//            }bw.write("\n");
//        } bw.write("\n");
//
//        int cnt = tree.search();
//        bw.write(cnt + "");
//        bw.flush();
//    }
//}
//
//class Node{
//    private int value, parent;
//    private List<Node> treechild;
//    public Node(int value, int parent) {
//        this.value = value;
//        this.parent = parent;
//        treechild = new ArrayList<>();
//    }
//    public int getValue(){ return value; }
//    public int getParent(){ return parent; }
//
//    public List<Node> getTreechild(){ return treechild; }
//
//}
//class Tree{
//    private Node[] tree;
//
//    public Node[] getTree() {
//        return tree;
//    }
//
//    private int ancestor;
//    public Tree(int size){
//        tree = new Node[size];
//    }
//    public void AddNode(Node node){
//        int i = node.getValue();
//        int parent = node.getParent();
//        tree[i] = node;
//    }
//    public void setTreeChild(){
//        for (Node node : tree) {
//            if (node.getParent() != -1)
//                tree[node.getParent()].getTreechild().add(node);
//            else
//                ancestor = node.getValue();
//        }
//    }
//    public void CutTree(int delete) {
//        int parent = tree[delete].getParent();
//        if(parent != -1) {
//            List<Node> childOfParent = tree[parent].getTreechild();
//            for (Node node : childOfParent) {
//                if(node.getValue() == delete) {
//                    tree[tree[delete].getParent()].getTreechild().remove(node);
//                    break;
//                }
//            }
//        }
//        tree[delete] = null;
//    }
//
//    private int cnt;
//    boolean[] visited;
//    public int search(){
//        visited = new boolean[tree.length];
//        cnt=0;
//        recurTree(ancestor);
//        return cnt;
//    }
//    private void recurTree(int start){
//        visited[start] = true;
//        if (tree[start] == null) return;
//        else if(tree[start].getTreechild().size() == 0)
//            cnt++;
//        else {
//            for(Node node : tree[start].getTreechild()){
//                if (!visited[node.getValue()]) {
//                    System.out.println("true     : tree[start].get(i).getValue() = " + node.getValue());
//                    recurTree(node.getValue());
//                } else {
//                    System.out.println("false : tree[start].get(i).getValue() = " + node.getValue());
//                }
//            }
//        }
//    }
//}


//import java.io.*;
//import java.util.LinkedList;
//import java.util.List;
//
//import static java.lang.Integer.*;
//
//public class Main {
//    public static void main(String[] args) throws Exception {
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int n = parseInt(br.readLine());
//        String[] in = br.readLine().split(" ");
//        int d = parseInt(br.readLine());
//        Tree tree = new Tree(n);
//        for (int i = 0; i < n; i++) {
//            tree.AddNode(new Node(i, parseInt(in[i])));
//        }
//        tree.CutTree(d);
//        int cnt = tree.search();
//        bw.write(cnt + "");
//        bw.flush();
//    }
//}
//
//class Node{
//    private int value, parent;
//    public Node(int value, int parent) {
//        this.value = value;
//        this.parent = parent;
//    }
//    public int getValue(){ return value; }
//    public int getParent(){ return parent; }
//
//}
//class Tree{
//    private List<Node>[] tree;
//    private int ancestor;
//    public Tree(int size){
//        tree = new List[size];
//        for (int i = 0; i < size; i++) {
//            tree[i] = new LinkedList<>();
//        }
//    }
//    public void AddNode(Node node){
//        int i = node.getValue();
//        int parent = node.getParent();
//        if (parent != -1) {
//            tree[i].add(node);
//            tree[parent].add(node);
//        } else {
//            tree[i].add(0, node);
//            ancestor = i;
//        }
//    }
//    public void CutTree(int delete) {
//        int parent = tree[delete].get(0).getParent();
//        if(parent != -1) {
//            for (Node node : tree[parent]) {
//                if(node.getValue() == delete) {
//                    tree[parent].remove(tree[parent].indexOf(node));
//                    break;
//                }
//            }
//        }
//        tree[delete] = null;
//    }
//
//    private int cnt;
//    boolean[] visited;
//    public int search(){
//        visited = new boolean[tree.length];
//        cnt=0;
//        recurTree(ancestor);
//        return cnt;
//    }
//    private void recurTree(int start){
//        visited[start] = true;
//        if (tree[start] == null) return;
//        else if(tree[start].size() == 1)
//            cnt++;
//        else {
//            for (int i = 1; i < tree[start].size(); i++) {
//                if (!visited[tree[start].get(i).getValue()])
//                    recurTree(tree[start].get(i).getValue());
//            }
//        }
//    }
//}