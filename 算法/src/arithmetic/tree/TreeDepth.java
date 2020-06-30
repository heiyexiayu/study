package arithmetic.tree;

public class TreeDepth {
    public static int maxDepth(TreeNode treeNode){
        return treeNode==null?0:Math.max(maxDepth(treeNode.left),maxDepth(treeNode.right))+1;
    }
}
