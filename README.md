# january21_2025
The problems that I solved today

1.You are given a 0-indexed 2D array grid of size 2 x n, where grid[r][c] represents the number of points at position (r, c) on the matrix. Two robots are playing a game on this matrix. 
Both robots initially start at (0, 0) and want to reach (1, n-1). Each robot may only move to the right ((r, c) to (r, c + 1)) or down ((r, c) to (r + 1, c)). At the start of the game, the first robot moves from (0, 0) to (1, n-1), collecting all the points from the cells on its path. For all cells (r, c) traversed on the path, grid[r][c] is set to 0. Then, the second robot moves from (0, 0) to (1, n-1), collecting the points on its path. Note that their paths may intersect with one another. The first robot wants to minimize the number of points collected by the second robot. In contrast, the second robot wants to maximize the number of points it collects. If both robots play optimally, return the number of points collected by the second robot.

Code:
class Solution {
    public long gridGame(int[][] grid) {
        long fSum=0,sSum=0;
        long min=Long.MAX_VALUE;
        int m=grid[0].length,i;
        for(i=0;i<m;i++)
            fSum+=grid[0][i];
        for(i=0;i<m;i++)
        {
            fSum-=grid[0][i];
            min=Math.min(min,Math.max(fSum,sSum));
            sSum+=grid[1][i];
        }
        return min;
    }
}

2.A trie (pronounced as "try") or prefix tree is a tree data structure used to efficiently store and retrieve keys in a dataset of strings. There are various applications of this data structure, such as autocomplete and spellchecker. Implement the Trie class: Trie() Initializes the trie object. void insert(String word) Inserts the string word into the trie. boolean search(String word) Returns true if the string word is in the trie (i.e., was inserted before), and false otherwise. boolean startsWith(String prefix) Returns true if there is a previously inserted string word that has the prefix prefix, and false otherwise.

Code:
class Trie {
    Trie[] t;
    boolean isEnd;
    public Trie() {
        t=new Trie[26];
        isEnd=false;
        for(int i=0;i<26;i++)
            t[i]=null;
    }
    
    public void insert(String word) {
        Trie r=this;
        for(char c:word.toCharArray())
        {
            if(r.t[c-'a']==null)
                r.t[c-'a']=new Trie();
            r=r.t[c-'a'];
        }
        r.isEnd=true;
    }
    
    public boolean search(String word) {
        Trie r=this;
        for(char c:word.toCharArray())
        {
            if(r.t[c-'a']==null)
                return false;
            r=r.t[c-'a'];
        }
        return r.isEnd;
    }
    
    public boolean startsWith(String prefix) {
        Trie r=this;
        for(char c:prefix.toCharArray())
        {
            if(r.t[c-'a']==null)
                return false;
            r=r.t[c-'a'];
        }
        return true;
    }
}

3.Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2. You have the following three operations permitted on a word: Insert a character Delete a character Replace a character 

Code:
class Solution {
    public int minDistance(String word1, String word2) {
        int n=word1.length();
        int m=word2.length();
        int[][] dp=new int[n+1][m+1];
        int i,j;
        for(i=0;i<=n;i++)
        {
            for(j=0;j<=m;j++)
            {
                if(i==0 || j==0)
                    dp[i][j]=i==0?j:i;
                else if(word1.charAt(i-1)==word2.charAt(j-1))
                    dp[i][j]=dp[i-1][j-1];
                else
                    dp[i][j]=1+Math.min(dp[i-1][j-1],Math.min(dp[i][j-1],dp[i-1][j]));
            }
        }
        return dp[n][m];
    }
}

4.Given the root of a complete binary tree, return the number of the nodes in the tree. According to Wikipedia, every level, except possibly the last, is completely filled in a complete binary tree, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h. Design an algorithm that runs in less than O(n) time complexity.

Code:
class Solution {
    public int countNodes(TreeNode root) {
        if(root==null)
            return 0;
        return countNodes(root.left)+countNodes(root.right)+1;
    }
}

5.Given the root of a binary tree and an integer targetSum, return true if the tree has a root-to-leaf path such that adding up all the values along the path equals targetSum. A leaf is a node with no children.

Code:
class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null)
            return false;
        if(root.left==null && root.right==null)
            return targetSum==root.val;
        if(hasPathSum(root.left,targetSum-root.val))
            return true;
        if(hasPathSum(root.right,targetSum-root.val))
            return true;
        return false;
    }
}

6.You are given the root of a binary tree containing digits from 0 to 9 only. Each root-to-leaf path in the tree represents a number. For example, the root-to-leaf path 1 -> 2 -> 3 represents the number 123. Return the total sum of all root-to-leaf numbers. Test cases are generated so that the answer will fit in a 32-bit integer. A leaf node is a node with no children.

Code:
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
