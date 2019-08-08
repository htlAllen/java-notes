package al.lt;

import sun.reflect.generics.tree.Tree;

import java.lang.reflect.Array;
import java.util.*;


public class Entry{
    public static void main(String[] args){
//        // 树相关的测试
//        TreeNode test = new TreeNode(10);
//        TreeNode root = test.createTree();
//        System.out.println(test.maxDepth(root));
//        System.out.println(test.bdfMaxDepth(root));
//        System.out.println(test.bfs2(root));
//        System.out.println(Arrays.toString(Others.maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3)));

        // 修改字串的值
//        char[] q = {'b', 'c', 'w', 'a'};
////        System.out.println(Arrays.toString(q));
////        Arrays.sort(q);
////        System.out.println(Arrays.toString(q));
////        String test = "hello world";
////        char[] testChar = test.toCharArray();
////        testChar[0] = 'H';
////        String test2 = String.valueOf(testChar);
////        System.out.println(test2);
////        ArrayList<String> ww = new ArrayList<String>();
////        ww.add("qqqq");
////        ww.add("wwww");
////        System.out.println(ww);
////        Others qqq = new Others();
////        String[] qq = {"eat", "tea", "tan", "ate", "nat", "bat"};
////        qqq.groupAnagrams(qq);
////        qqq.groupAnagrams2(qq);
////        qqq.toLowerCase("HELLO");
////        char[] aaa = {'a', 'b', 'c', 'd'};
////        qqq.reverseString(aaa);

        Sort sort = new Sort();
        int[] a = {4,7,6,5,3,2,8,1};
        sort.quickSort(a, 0, a.length);
        System.out.println(Arrays.toString(a));
        int[] array = new int[] {7,5,6,4,3};
        sort.heapSort(array);
    }
}
// 其他
class Others{
    // 8.7 找到数组中k个最大的值
    public int findKthLargest(int[] nums, int k){
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
    // 8.6 反转字符串
    public void reverseString(char[] s){
        int first=0, last=s.length - 1;
        char tmp;
        while(first < last){
            tmp = s[last];
            s[last] = s[first];
            s[first] = tmp;
            first++;
            last--;
        }
      System.out.println(Arrays.toString(s));
    }
    // 8.6 将String中的大写字母转为小写
    public void toLowerCase(String str){
        char[] ch = str.toCharArray();
        for(int i=0; i < ch.length; i++){
            if (ch[i] <= 'Z' && ch[i] >= 'A'){
                ch[i] =  (char)(ch[i] + 32);
            }
        }
        System.out.println(String.valueOf(ch));
    }
    // 8.6 字母异位分组--按照计数作为key--非常普通的解法
    public void groupAnagrams(String[] args){
        HashMap<String, List<String>> x =  new HashMap<String, List<String>>();
        int[] m = new int[26];
        for(String str: args){
            // 这一步数组初始化也很棒啊
            Arrays.fill(m, 0);
            for(char c: str.toCharArray()){
                // 这一步精辟啊！ 用数组的下标标识26个字母，用数组的值来标识字母出现的次数
                m[c - 'a']++;
            }
            // 这一步完全没有必要啊，只要想办法把整型数组转化位String类型就可以了啊,StringBuilder与String的区别在于StringBuild可以修改字符串的值
            // 直接如下转化成String就可以了
//            StringBuilder sb = new StringBuilder("");
//            for(int i=0; i<26; i++){
//                sb.append("#");
//                sb.append(m[i]);
//            }
            // 把数组转化位String
            String key = Arrays.toString(m);
            if(!x.containsKey(key)){
                x.put(key, new ArrayList<String>());
            }
            x.get(key).add(str);
        }
        System.out.println(x.values());
        System.out.println(new ArrayList<>(x.values()));
    }
    // 8.6 字符异位分组--按照排序分组--- 非常普通的解法
    public void groupAnagrams2(String[] args){
        HashMap<String, List<String>> x = new HashMap<String, List<String>>();
        for(String str: args){
            char[] strChar = str.toCharArray();
            Arrays.sort(strChar);
            if(!x.containsKey(Arrays.toString(strChar))){
                x.put(Arrays.toString(strChar), new ArrayList<String>());
            }
            x.get(Arrays.toString(strChar)).add(str);
        }
        System.out.println(x.values());
    }
    // 求解两数之和
    // 关键是使用了contains函数，其实本质上一个循环
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
    // 关键是使用了位置标识left，right,并且right-left的值就表示为子串的长度
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

    // K个不同整数的子数组,暴力破解
    public static int subarraysWithKDistinct(int[] A, int K){
        int n = 0;
        for(int i = 0; i < A.length; i++){
            Set<Integer> set = new HashSet<Integer>();
            for(int j = i; j < A.length; j++){
                set.add(A[j]);
                if(set.size() == K){
                    n++;
                }
            }
        }
        return n;
    }

    // 滑动窗口的最大值
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (n * k == 0) return new int[0];
        // 0. 初始化变量
        int[] res = new int[nums.length - k + 1];
        int right = k, index=0;
        // 1. 初始化滑动窗口
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i = 0; i < k; i++){
            list.add(nums[i]);
        }
        res[index++] = Collections.max(list);
        while(right < nums.length){
            list.remove(0);
            list.add(nums[right++]);
            res[index++] = Collections.max(list);
        }
        return res;
    }
    public static int[] maxSlidingWindow2(int[] nums, int k) {
        // 0. 初始化变量
        int n = nums.length;
        if (n * k == 0) return new int[0];
        int[] res = new int[nums.length - k + 1];
        for(int i=0; i < nums.length - k + 1; i++){
            int max = Integer.MIN_VALUE;
            for(int j = i; j < k + i; j++){
                max = Math.max(max, nums[j]);
            }
            res[i] = max;
        }
        return res;
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

// 排序
class Sort{
    // --------------------------------8.8--------------------------------
    // （一）快速排序
    // 1.分而治之（能否使用多线程来进行操作呢） 2. 萝卜填坑 3.这个复杂度我不会算 4. 一个index，一个pivot是写代码的关键
    // 对于快速排序而言，关键在于partition操作
    public void quickSort(int[] args, int startIndex, int endIndex){
        if (startIndex >= endIndex){
            return;
        }
        int index = partition2(args, startIndex, endIndex);
        quickSort(args, startIndex, index - 1);
        quickSort(args, index + 1, endIndex);
    }
    // 使左边的元素比pivot小，使右边的元素比pivot大
    public int partition(int[] args, int startIndex, int endIndex){
        int x = args[startIndex];
        int i = startIndex;
        int j = endIndex;
        int index = startIndex;     // index始终指向坑的位置
        while(i < j) {
            // 这个是关键代码，注意小括号里面的条件
            while(x < args[j] && i < j) j--; //
            if (i < j){
                args[i] = args[j];    //
                index = j;
                i++;

            }
            while(x > args[i] && i < j) i++;
            if (i < j){
                args[j] = args[i];
                index = i;
                j--;

            }
        }
        args[index] = x;
        return index;
    }
    // 交换法实现上诉partition操作
    public int partition2(int[] args, int startIndex, int endIndex){
        // 两个关键的地方，一个是pivot，一个是index
        int pivot = startIndex;
        int index = startIndex + 1;
        for(int i = index; i < endIndex; i++){
            if(args[i] < args[pivot]){
                swap(args, i, index);
                index++;
            }
        }
        swap(args, pivot, index - 1);
        return index-1;
    }
    public void swap(int[] args, int i, int j){
        int tmp;
        tmp = args[i];
        args[i] = args[j];
        args[j] = tmp;
    }

    // （二） 堆排序。1）堆构建：就是从第一个非负叶子节点下沉  2）因为堆顶的元素是最大，所以只需要不断的取堆顶，调整堆就能得到有序数组了
    public void downAdjust(int[] arr, int parentIndex, int length){
        int childIndex = parentIndex * 2 + 1;
        int tmp = arr[parentIndex];
        while(childIndex < length){
            // 孩子节点的寻找
            if((childIndex + 1) < length && arr[childIndex + 1] < arr[childIndex]){
                childIndex++;
            }
            // 比较父和子节点的大小关系,这个是指tmp的指而不是arr[parentIndex];
            if(tmp < arr[childIndex]){
                break;
            }
            arr[parentIndex] = arr[childIndex];
            parentIndex = childIndex;
            childIndex = parentIndex * 2 + 1;
        }
        arr[parentIndex] = tmp;
    }
    public void heapSort(int[] arr){
        // 构建堆
        for(int i = arr.length/2; i >=0; i--){
            downAdjust(arr, i, arr.length);
        }
        System.out.println(Arrays.toString(arr));
        // 取堆顶元素，调正堆
        for(int i = arr.length - 1; i > 0; i--){
            int tmp = arr[0];
            arr[0] = arr[i];
            arr[i] = tmp;
            downAdjust(arr, 0, i);
        }
        System.out.println(Arrays.toString(arr));
    }

}