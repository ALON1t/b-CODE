package T2;

import java.util.List;

public class TreeTraversal {//前序

    public static void preTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.printf("%c", root.val);//根
        preTraversal(root.left);//左子树
        preTraversal(root.right);//右子树

    }

    public static void inTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        inTraversal(root.left);
        System.out.printf("%c", root.val);
        inTraversal(root.right);
    }

    public static void postTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        postTraversal(root.left);
        postTraversal(root.right);
        System.out.printf("%c", root.val);
    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode('A');//先构造结点
        TreeNode b = new TreeNode('B');
        TreeNode c = new TreeNode('C');
        TreeNode d = new TreeNode('D');
        TreeNode e = new TreeNode('E');
        TreeNode f = new TreeNode('F');
        TreeNode g = new TreeNode('G');
        TreeNode h = new TreeNode('H');
        TreeNode i = new TreeNode('I');
        TreeNode j = new TreeNode('J');
        //连接结点
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
       /* preTraversal(a);
        System.out.println();
        inTraversal(a);
        System.out.println();
        postTraversal(a);
        System.out.println();*/


    }
   /* public static TreeNode b(TreeNode root) {
        System.out.printf("%c",root.val);
        b(root);
        return


    }*/

   /* public static int hight (TreeNode root){
        int hight = 0;
        if(root == null) {
            return 0;
        } else if(root.left ==){
            hight++;
            hight(root);
            hight(root.left);
            hight(root.right);

        }
        return hight;
    }*/


}
