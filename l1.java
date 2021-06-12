import java.util.ArrayList;

public class l1 {

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static int size(TreeNode root) {
        return root == null ? 0 : size(root.left) + size(root.right) + 1;
    }

    public static int height(TreeNode root) {
        return root == null ? -1 : Math.max(height(root.left), height(root.right)) + 1;
    }

    public static int Maximum(TreeNode root) {
        return root == null ? -(int) 1e9 : Math.max(Math.max(Maximum(root.left), Maximum(root.right)), root.val);
    }

    public static boolean find(TreeNode root, int data) {
        if (root == null)
            return false;
        if (root.val == data)
            return true;

        return find(root.left, data) || find(root.right, data);
    }

    public static boolean nodeToRootPath(TreeNode root, int data, ArrayList<TreeNode> path) {
        if (root == null)
          return false;
        if (root.val == data) {
          path.add(root);
          return true;
        }
    
        boolean res = nodeToRootPath(root.left, data, path) || nodeToRootPath(root.right, data, path);
        if (res)
          path.add(root);
    
        return res;
      }
    
      public static ArrayList<TreeNode> nodeToRootPath(TreeNode root, int data) {
        ArrayList<TreeNode> path = new ArrayList<>();
        nodeToRootPath(root, data, path);
        return path;
      }

}
