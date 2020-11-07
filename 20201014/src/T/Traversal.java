package T;

import java.util.*;

public class Traversal {
    public static void preOrder(TreeNode root){//前序遍历
        if(root != null) {
            System.out.printf("%c",root.val);
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    public static void inOrder(TreeNode root) {//中序遍历
        if(root != null) {
            inOrder(root.left);
            System.out.printf("%c",root.val);
            inOrder(root.right);
        }
    }

    public static void postOrder(TreeNode root) {//后序遍历
        if(root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.printf("%c",root.val);
        }
    }

    public static void preOrder1(TreeNode root){//不同的打印方式
        if(root != null) {
            System.out.printf("%c",root.val);
            System.out.print(" {");
            preOrder1(root.left);
            System.out.print("} { ");
            preOrder1(root.right);
            System.out.print(" }");
        }
    }
    private static int count;//静态变量
    //注意：静态方法内不能使用非静态变量
    public  static int sumTreeNodeSize(TreeNode root) {
        //int count = 0;//局部变量
        count = 0;
        pre(root);
        return count;
    }

    public static void pre(TreeNode root) {
        if(root != null) {
            count++;
            pre(root.left);
            pre(root.right);
        }
    }

    public static int sumTreeNode1(TreeNode root) {
        //root可能有两种情况：
        // 1. root != null;
        // 2. root == null;
        if(root == null) {//空
            return 0;
        }
        int rootNode = 1;
        int leftSubTreeNode = sumTreeNode1(root.left);
        int rightSunTreeNode = sumTreeNode1(root.right);
        return rootNode + leftSubTreeNode +rightSunTreeNode;
    }

    public static int sumTreeNodeLeaf(TreeNode root) {
        //叶子结点：既没有左孩子也没有右孩子
        count = 0;
        pre1(root);
        return count;
    }
    public static void pre1(TreeNode root) {//前序
        if(root != null) {
            if(root.left == null && root.right == null) {
                count++;//为叶子结点时
            }
            pre1(root.left);
            pre1(root.right);
        }
    }

    public static int sumTreeNodeLeaf1(TreeNode root) {
        if(root == null) {//空树
            return 0;
        } else if(root.left == null && root.right == null) {//只有一个结点的树
            return 1;
        } else {
            //至少有两个结点
            //叶子结点的个数 = 左子树叶子结点个数 + 右子树叶子结点个数
            int leftSumTreeLeaf = sumTreeNodeLeaf1(root.left);
            int rightSumTreeLeaf = sumTreeNodeLeaf1(root.right);
            return leftSumTreeLeaf + rightSumTreeLeaf;
        }
    }

    public static int sumKLevalNode (TreeNode root,int k) {
        if(root == null) {
            //1.空树
            return 0;
        } else if(k == 1) {
            //2.root 不是空树，但是 k == 1
            return 1;
        } else {
            //3.其他情况
            int leftSubTreeK = sumKLevalNode(root.left,k - 1);
            int rightSubTreeK = sumKLevalNode(root.right,k - 1);
            return leftSubTreeK + rightSubTreeK;
        }
    }

    public static int hight(TreeNode root) {
        int max = 0;
        if(root == null) {
            return 0;
        } else if(root.left == null && root.right == null) {
            return 1;
        } else {
            int left = hight(root.left);
            int right = hight(root.right);
            return Math.max(left , right) + 1;
        }
    }

    public static boolean contains(TreeNode root,int v) {

        if(root == null) {
            return false;
        } else if(root.val == v) {
            return true;
        } else {
            boolean left = contains(root.left,v);
            if(left) {
                return true;
            }
            return contains(root.right,v);
        }
    }

/*    public int widthOfBinaryTree(TreeNode root) {
        if(root == null) {//空树
            return 0;
        }
        if(root.left == null && root.right == null) {//根结点
            return 1;
        }

    }*/

    public  static int getHeight(TreeNode root) {//高度
        if(root == null) {
           return 0;
        }
        int left = getHeight(root.left);
        int right = getHeight(root.right);
        return Math.max(left,right) + 1;
    }
    public static void sequenceTra(TreeNode root) {//层序遍历


    }

    private static int size = 0;
    private static int max = 0;

    public boolean isCompleteTree(TreeNode root) {
        if(root == null) {
            return false;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean curNull = false;
        while(!queue.isEmpty()) {
            int count = queue.size();
            while (count-- > 0) {
                TreeNode cur = queue.poll();
                if(cur == null && !curNull ) {
                    return true;
                }
                if(cur != null && curNull) {
                    return false;
                }
                if(cur != null && !curNull) {
                    queue.add(cur.left);
                    queue.add(cur.right);
                }
            }
        }
        return true;
    }

    public static void fun(TreeNode root,int index) {
        if(root == null) {
            return;
        }
        max = Math.max(max,index);
        fun(root.left,2*index);
        fun(root.right,2*index + 1);
        size++;
    }
    public static void main(String[] args) {
        //构造结点
        TreeNode a = new TreeNode('A');
        TreeNode b = new TreeNode('B');
        TreeNode c = new TreeNode('C');
        TreeNode d = new TreeNode('D');
        TreeNode e = new TreeNode('E');
        TreeNode f = new TreeNode('F');
        TreeNode g = new TreeNode('G');
        TreeNode h = new TreeNode('H');
        TreeNode i = new TreeNode('I');
        TreeNode j = new TreeNode('J');
        //把结点之间的关系连接起来
        a.left = b;
        a.right = c;

        b.left = d;
        b.right = null;

        c.left = e;
        c.right = f;

        d.left = null;
        d.right = g;

        e.left = null;
        e.right = null;

        f.left = h;
        f.right = i;

        g.left = j;
        g.right = null;

        h.left = null;
        h.right = null;

        i.left = null;
        i.right = null;

        j.left = null;
        j.right = null;

       // preOrder1(a);
        //preOrder(a);
       // boolean sum = contains(null,'C');
        int sum = getHeight(a);
        System.out.println(sum);
    }
}
