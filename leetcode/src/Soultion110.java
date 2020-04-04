public class Soultion110 {

    public static boolean isBalanced(TreeNode root) {
        if (root==null||root.left == null && root.right == null) {
            return true;
        }
        TreeNode tm=new TreeNode(0);
         hight(root,tm);
        return tm.val<2;

    }
    //计算树高 ,树高差值最大值存在tm节点里
    //暴力
    private static int hight(TreeNode root,TreeNode tm) {
        if (root == null) {
            return 0;
        }
        int left = hight(root.left,tm) + 1;
        int right = hight(root.right,tm) + 1;
        tm.val=Math.max(tm.val,Math.max(left-right,right-left));
        return Math.max(right,left);
    }
    //提前结束    int值不仅存储false结果还可以存储深度
    //如果递归到某一结点不是平衡二叉树，就不需要保存深度值了，直接返回不成立的标志，就不需要再比较或是判断其他节点是不是平衡的了
//        public  boolean isBalanced(TreeNode root) {
//            return recur(root) != -1;
//
//        }
    private int recur(TreeNode root) {
        if (root == null) return 0;
        int left = recur(root.left);
        if(left == -1) return -1;
        int right = recur(root.right);
        if(right == -1) return -1;
        return Math.abs(left - right) < 2 ? Math.max(left, right) + 1 : -1;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        TreeNode treeNode1 = new TreeNode(9);
        TreeNode treeNode2 = new TreeNode(20);
        TreeNode treeNode3 = new TreeNode(15);
        TreeNode treeNode4 = new TreeNode(7);
        TreeNode treeNode5 = new TreeNode(3);
        treeNode.left = treeNode1;
        treeNode.right = treeNode2;
        treeNode2.left = treeNode3;
        treeNode2.right = treeNode4;
     //   treeNode4.left=treeNode5;
        boolean hight = isBalanced(treeNode);
        System.out.println(hight);

    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}