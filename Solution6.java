class Solution {
    public int sumNumbers(TreeNode root) {
        int[] res=new int[1];
        f(root,res,0);
        return res[0];
    }
    public void f(TreeNode root,int[] res,int sum)
    {
        if(root==null)
            return;
        if(root.left==null && root.right==null)
        {
            sum=sum*10+root.val;
            res[0]+=sum;
        }
        sum=sum*10+root.val;
        f(root.left,res,sum);
        f(root.right,res,sum);
    }
}