package al.lt;

import sun.reflect.generics.tree.Tree;

import java.util.*;

public class Entry{
    public static void main(String[] args){
//        // 树相关的测试
//        TreeNode test = new TreeNode(10);
//        TreeNode root = test.createTree();
//        System.out.println(test.maxDepth(root));
//        System.out.println(test.bdfMaxDepth(root));
//        System.out.println(test.bfs2(root));



    }
}
// 其他
class Others{
    public static String twoSum(int[] nums, int target){
        int[] ans = new int[2];
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], i);
        }
        int component = 0;
        for(int i = 0; i < nums.length; i++){
            component = target - nums[i];
            if (map.containsKey(component)){
                ans[0] = i;
                ans[1] = map.get(component);
                return Arrays.toString(ans);
            }
        }
        return Arrays.toString(ans);
    }
    // 不重复最小子串长度
    public static int lengthOfLongestSubstring(String s){
        Set<Character> set = new HashSet<Character>();
        int left=0, right=0, ans=0, n=s.length();
        while(left < n && right < n){
            boolean flag;
            flag = ! set.contains(s.charAt(right));
            if(flag){
                set.add(s.charAt(right));
                right++;
                ans = Math.max(ans, right - left);
            }else{
                set.remove(s.charAt(left));
                left++;
            }
        }
        return ans;
    }
    // 宝石与石头之HashSet
    public static int numJewelsInstores(String J, String S){
        int jewels_count=0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < S.length(); i++){
            if(map.containsKey(S.charAt(i))){
                int count = map.get(S.charAt(i));
                count++;
                map.put(S.charAt(i), count);
            }else{
                map.put(S.charAt(i), 1);
            }
        }
        for (int j = 0; j < J.length(); j++){
            if(map.containsKey(J.charAt(j))){
                jewels_count += map.get(J.charAt(j));
            }
        }
        return jewels_count;
    }
    // 宝石与石头之indexOf
    public static int numJewelsInstores2(String J, String S){
        String tmp = null;
        int jewles = 0;
        for(int i = 0; i < S.length(); i++){
            tmp = S.substring(i, i+1);
            if(J.contains(tmp)){
                jewles++;
            }
        }
        return jewles;
    }
    // 汉明距离
    public static int hammingDistance(int x, int y){
        int distance = 0;
        String binary_x = Integer.toBinaryString(x);
        String binary_y = Integer.toBinaryString(y);
        String tmp_binary_x = String.format("%320d", 0);
        String tmp_binary_y = String.format("%320d", 0);

        int min = Math.min(binary_x.length(), binary_y.length());
        for(int i = 0; i < min; i++){
            if(binary_x.charAt(i) == binary_y.charAt(i)){
                distance++;
            }
        }
        return distance;
    }
}

// 对于树相关的算法首先应该想到的就是递归,然后就是队列和堆栈了。
class TreeNode {
    private int val;
    private TreeNode left;
    private TreeNode right;

    TreeNode(int x) {
        val = x;
        left = null;
        right = null;
    }

    public void setLeft(TreeNode node){
        left = node;
    }

    public void setRight(TreeNode node){
        right = node;
    }

    public TreeNode createTree(){
        ArrayList<TreeNode> list = new ArrayList<TreeNode>();
        for(int i=0; i < 9; i++){
            list.add(new TreeNode(i));
        }
        TreeNode root = list.get(0);
        for(int i=0; i< 4; i++){
            list.get(i).setLeft(list.get(2*i + 1));
            list.get(i).setRight(list.get(2*i + 2));
        }
        return root;
    }

    public int getValue() {
        return val;
    }

    public static void preOrder(TreeNode root) {
        if (root != null) {
            preOrder(root.left);
            System.out.println(root.getValue());
            preOrder(root.right);
        }
    }
    // 利用队列进行广度遍历
    public void bfs(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        TreeNode tmp = queue.poll();
        while(tmp != null){
            System.out.println(root.getValue());
            if(root.left != null){
                queue.offer(root.left);
            }
            if(root.right != null){
                queue.offer(root.right);
            }
            tmp = queue.poll();
        }


    }
    // 广度优先遍历
    public List<List<Integer>> bfs2(TreeNode root){
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        if(root == null) { return list;}
        list.add(new ArrayList<Integer>());
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        TreeNode tmp = null;
        int current_count=0, next_count=0, depth=0;
        queue.offer(root);
        current_count++;
        tmp = queue.poll();
        while(tmp != null){
            list.get(depth).add(tmp.getValue());
            current_count--;
            if(tmp.left != null){
                queue.offer(tmp.left);
                next_count++;
            }
            if(tmp.right != null){
                queue.offer(tmp.right);
                next_count++;
            }
            if(current_count == 0){
                list.add(new ArrayList<Integer>());
                current_count = next_count;
                next_count = 0;
                depth++;
            }
            tmp = queue.poll();
        }
        list.remove(list.size() - 1);
        return list;
    }
    // 递归求树的最大深度
    public int maxDepth(TreeNode root){
        if(root == null){
            return 0;
        }else{
            int left = maxDepth(root.left);
            int right = maxDepth(root.right);
            return 1 + Math.max(left, right);
        }
    }
    // 通过bfs递归求树的最小深度
    // 关键：若在某一层，存在一个节点，没有左右孩子节点，此时该层的深度就为这个二叉树最小的深度
    public int minDepth(TreeNode root){
        if (root == null){
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        TreeNode tmp = null;
        int current_count = 0;
        int next_count = 0;
        int depth = 1;
        queue.offer(root);
        current_count++;
        tmp = queue.poll();
        while(tmp != null){
            // 如果该层存在一个没有左右孩子节点的节点则此层的深度是最小的深度
            if(current_count != 0 && tmp.left == null && tmp.right == null){
                return depth;
            }
            current_count--;
           if(tmp.left != null){
               next_count++;
               queue.offer(tmp.left);
           }
           if(tmp.right != null){
               next_count++;
               queue.offer(tmp.right);
           }
           if(current_count == 0){
               current_count = next_count;
               depth++;
               next_count = 0;
           }
           tmp = queue.poll();
        }
        return depth;
    }
    // 通过bfs来求树的最大深度
    // 关键：在什么时候树的深度+1， 当一层中的节点都遍历完的时候，深度就能够加+1了
    public int bdfMaxDepth(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        TreeNode tmp = null;
        int current_count = 0;  // 记录当前层的节点数目
        int next_count = 0;     // 记录下一层的节点数目
        int depth = 0;
        queue.offer(root);
        current_count++;
        tmp = queue.poll();
        while(tmp != null){
            current_count--;
            if(tmp.left != null){
                next_count++;
                queue.offer(tmp.left);
            }
            if(tmp.right != null){
                next_count++;
                queue.offer(tmp.right);
            }
            // 如果当前层的节点数目为0，则说明这一层的节点全部遍历完了，深度可以加1了
            if(current_count == 0){
                depth++;
                current_count = next_count;
                next_count=0;
            }
            tmp = queue.poll();
        }
        return depth;
    }
}
