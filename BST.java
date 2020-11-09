package BinarySearchTree;

public class BST {
    private Node root;

    public BST() {
        root = null;//构造一个空树
    }


    //方法需要用到对象的一定是非静态的
    //可以使用静态，则也一定可以使用非静态
    public boolean search(Integer key) {//查找
        Node cur = root;
        while(cur != null) {
            int cmp = key.compareTo(cur.key);
            if(cmp == 0) {
                return true;//找到了
            } else if(cmp < 0) {//去左子树找
                cur = cur.left;
            } else {
                cur = cur.right;//去右子树找
            }
        }
        return false;
    }

    public void insert(Integer key) {//插入

        if(root == null) {
            root = new Node(key);
            return;
        }
        //先查找二叉树中是否存在key
        //定义一个parent 结点记录插入位置的父节点
        Node parent = null;
        Node cur = root;
        int cmp = 0;
        while(cur != null) {
            cmp = key.compareTo(cur.key);
            if(cmp == 0) {
                throw new RuntimeException("key值重复");
            } else if(cmp < 0){
                parent = cur;
                cur = cur.left;
            } else {
                parent = cur;
                cur = cur.right;
            }
        }
        //cur = null
        //parent 为插入新节点的双亲结点
        Node node = new Node(key);
        if(cmp < 0) {
            parent.left = node;
        } else {
            parent.right = node;
        }
    }
}
