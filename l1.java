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
    
    // Node to Root Path

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
    
    // Root to All Leaf Path

    public static void rootToAllLeafPath(TreeNode root, ArrayList<Integer> smallAns,
                                       ArrayList<ArrayList<Integer>> ans) {
    if (root == null)
      return;
    if (root.left == null && root.right == null) {
      ArrayList<Integer> base = new ArrayList<>(smallAns);
      base.add(root.val);
      ans.add(base);
      return;
    }

    smallAns.add(root.val);

    rootToAllLeafPath(root.left, smallAns, ans);
    rootToAllLeafPath(root.right, smallAns, ans);

    smallAns.remove(smallAns.size() - 1);
  }

  public static ArrayList<ArrayList<Integer>> rootToAllLeafPath(TreeNode root) {
    ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
    ArrayList<Integer> smallAns = new ArrayList<Integer>();

    rootToAllLeafPath(root, smallAns, ans);
    return ans;
  }
    
    // Single Child Parent in Binary Tree
public static void exactlyOneChild(TreeNode node, ArrayList<Integer> ans) {
  if (node == null || (node.left == null && node.right == null))
    return;

  if (node.left == null || node.right == null)
    ans.add(node.val);

  exactlyOneChild(node.left, ans);
  exactlyOneChild(node.right, ans);

}

public static ArrayList<Integer> exactlyOneChild(TreeNode root) {
  ArrayList<Integer> ans = new ArrayList<>();
  exactlyOneChild(root, ans);
  return ans;
}

//Count Single Child Parent 
public static int countExactlyOneChild(TreeNode node) {
  if (node == null || (node.left == null && node.right == null))
    return 0;

  int left = countExactlyOneChild(node.left);
  int right = countExactlyOneChild(node.right);
  int sum = left + right;
  if (node.left == null || node.right == null)
    sum += 1;
  return sum;
}
    
}
