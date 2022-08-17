package grusie.tree

class Node {
    var data = 0.toChar()
    var left: Node? = null
    var right: Node? = null

    constructor(data: Char){
        this.data = data
    }
}
class Tree {
    var root:Node? = null
    fun makeNode(data: Char, left: Char, right: Char){
        if(this.root == null) {
            this.root = Node(data)
            this.root!!.left = if (left == '.') null else Node(left)
            this.root!!.right = if (right == '.') null else Node(right)
        }
        else {
            searchNode(root!!, data, left, right)
        }
    }

    fun searchNode(root: Node?, data: Char, left: Char, right: Char) {
        if(root == null) return
        if(root.data == data){
            root!!.left = if (left == '.') null else Node(left)
            root!!.right = if (right == '.') null else Node(right)
        }
        else{
            searchNode(root.left, data , left, right)
            searchNode(root.right, data , left, right)
        }
    }
    fun preorder(node: Node?) {
        if (node != null) {
            print(node.data)
            preorder(node.left)
            preorder(node.right)
        }
    }

    fun inorder(node: Node?) {
        if (node != null) {
            inorder(node.left)
            print(node.data)
            inorder(node.right)
        }
    }

    fun postorder(node: Node?) {
        if (node != null) {
            postorder(node.left)
            postorder(node.right)
            print(node.data)
        }
    }
}
fun main() {
    val order = readLine()!!.toInt()
    var t = Tree()

    for (i in 0 until order) {
        var (root, left, right) = readLine()!!.split(" ").map { it.toCharArray()[0] }
        t.makeNode(root, left, right)
    }
    t.preorder(t.root)
    println()
    t.inorder(t.root)
    println()
    t.postorder(t.root)
}