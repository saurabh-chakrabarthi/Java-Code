package com.java.poc.dsa_templates;

import com.java.poc.dsa.tree.TreeNode;

public class Dfs {
    public static void main(String[] args) {

    }

    public static boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;

        // Check if it's a leaf node
        if (root.left == null && root.right == null) {
            return sum == root.val;
        }

        // Recursively check both subtrees
        return hasPathSum(root.getLeft(), sum - root.val) || hasPathSum(root.right, sum - root.val);
    }

}
