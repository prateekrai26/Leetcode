/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Pair{
    TreeNode root;
    int v;
    Pair(TreeNode root , int v){    
        this.v = v;
        this.root = root;
    }
}
class Solution {
    
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root , 0));
        int ans = 0;
        while(!q.isEmpty()){
           int size = q.size();
           int left =0 , right = 0;
           for(int i=0;i<size;i++){
               Pair p = q.poll();
               if(i ==0){
                   left = p.v;
               }
               if(i == size -1){
                   right = p.v;
               }
               if(p.root.left!=null){
                  q.offer(new Pair(p.root.left , 2*p.v));
               }
               if(p.root.right !=null){
                   q.offer(new Pair(p.root.right , 2*p.v + 1));
               }
           }
          ans= Math.max(ans , right-left +1);
        }
        return ans;
    }
}