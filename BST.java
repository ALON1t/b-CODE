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

    //判断
    public boolean remove(Integer key) {
        //查找key值所在的结点，记作node，node的双亲结点记作parent
        Node parent = null;
        Node cur = root;

        while (cur != null) {
            int cmp = key.compareTo(cur.key);
            if(cmp == 0) {//找到了 进行删除操作
                removeInternal(cur,parent);
                return true;
            } else if(cmp < 0){//去左子树找
                parent = cur;
                cur = cur.left;
            } else { //去右子树找
                parent = cur;
                cur = cur.right;
            }
        }
        return false;//未找到
    }

    private void removeInternal(Node node,Node parent) {
        //情况一
        if(node.left == null && node.right == null) {//node为叶子结点
            if(node == root) {//node为根节点时，直接删除 root == null
                root = null;
            } else if(node == parent.left) {//node为parent的左孩子
                parent.left = null;
            } else {
                parent.right = null;//node为parent的右孩子
            }
            //情况二
        } else if(node.left != null && node.right == null) { //node只有左孩子
            if(node == root) {
                root = node.left;
            } else if(node == parent.left) {
                parent.left = node.left; //node的左孩子变为parent的左孩子
            } else {
                parent.right = node.left;//node的左孩子变为parent的右孩子
            }
            //情况三
        } else if(node.left == null){//node只有右孩子
            if(node == root) {
                root = node.right;//根节点时直接让node的右孩子变为根节点
            } else if(node == parent.left) {
                parent.left = node.right;//node的右孩子变为parent的左孩子
            } else {
                parent.right = node.right;//node的右孩子变为parent的右孩子
            }
            //情况四
        } else {//左右孩子都有
            Node ghostParent = node;
            Node ghost = node.left;
            while(ghost.right != null) {
                ghostParent = ghost;
                ghost = ghost.right; //一路朝右查找 直到ghost.right == null
            }
            //替换
            node.key = ghost.key;
            //删除 ghost结点（其右孩子一定为null）
            if(node == ghostParent) {
                ghostParent.left = ghost.left;
            } else {
                ghostParent.right = ghost.left;
            }
        }
    }
}
