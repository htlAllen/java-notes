package jeekbang.althrithm.dp;

public class Knapsack2 {
    public static void main(String[] args){
//        KnapsackOfWay2 x = new KnapsackOfWay2();
//        x.maxValueOfPack();
        System.out.println("---------------------------------------------------分割线---------------------------------------------");
        KnapsackOfWay2Backup x2 = new KnapsackOfWay2Backup();
        x2.maxValueOfPack();
    }
}

class KnapsackOfWay2{
    /*
    背包最大容量为9，然后有5个物品分别不同的重要和价值，满足背包最大容量的条件下背包装的东西价值最多
    */
    int[] weight = {2,2,4,6,3};
    int[] value = {3,4,8,9,6};
    int n=5;
    int w=9;
    public void maxValueOfPack(){
        int[][] states = new int[n][w+1];
        for(int i=0; i<n; i++){
            for(int j=0; j<w+1; j++){
                states[i][j] = -1;
            }
        }
        states[0][0] = 0;
        if(weight[0] <= w){
            states[0][weight[0]] = value[0];
        }

        for(int i=1; i<n; i++){
            // 全部选择不放
            for(int j=0; j<w+1; j++){
                if(states[i-1][j] != -1){
                    states[i][j] = states[i-1][j];
                }
            }
            // 全部选择放，放的时候要考虑最大值的问题
            for(int j=0; j<w+1; j++){
                if(states[i-1][j] != -1){
                    if(weight[i]+j <= w){
                        // 这一行代码是dp的关键
                        states[i][j+weight[i]] = Integer.max(states[i-1][j+weight[i]], states[i-1][j] + value[i]);
                    }
                }
            }
        }
        System.out.println("------------打印数组------------------------------------------------------");
        for(int i=0; i<n; i++){
            for(int j=0; j<w+1; j++){
                System.out.print(states[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
        System.out.println("------------打印对应的物品------------------------------------------------------");
        // 初始化
        int max = 0;
        int k = 0;
        // 求得最大值
        for(int j=w; j>=0; j--){
            if(max < states[4][j]){
                max = states[4][j];
                k=j;
            }
        }
        for(int i=n-1; i>=1; i--){
            // 没有购买第i个物品
            if(i == 1){
                if(states[i-1][k] == max){
                    System.out.println("没买" + i);
                    System.out.println("买了" + (i-1));
                }
                // 买了第i个物品
                else if(states[i-1][k - weight[i]] + value[i] == max){
                    System.out.println("买了" + i);
                    System.out.println("没了"+ (i-1));
                    max = states[i-1][k - weight[i]];
                    k = k - weight[i];
                }
                break;
            }
            if(states[i-1][k] == max){
                System.out.println("没买" + i);
            }
            // 买了第i个物品
            else if(states[i-1][k - weight[i]] + value[i] == max){
                System.out.println("买了" + i);
                max = states[i-1][k - weight[i]];
                k = k - weight[i];
            }
        }
    }
}


class KnapsackOfWay2Backup{
    /*
    背包最大容量为9，然后有5个物品分别不同的重要和价值，满足背包最大容量的条件下背包装的东西价值最多
    */
    int[] weight = {2,2,4,6,3};
    int[] value = {3,4,8,9,6};
    int n=5;
    int w=9;

    public void maxValueOfPack(){
        /*
        * 解题思路： 1. 划分阶段--for实现   2. 阶段所能做出的决策--if语句实现   3. 不同决策导致不同的状态--数组来实现
        */
        // 存储状态，数组的下标标识重量，数组的值表示价值
        int[] states = new int[w+1];

        // 初始化,观察第一个物品，并存储对应的状态
        for(int i=0; i<w+1; i++){
            states[i] = -1;
        }
        // 抉择：不放入第一个物品
        states[0] = 0;
        // 抉择：放入第一个物品
        if(weight[0] < w+1){
            states[weight[0]] = value[0];
        }

        // 划分阶段
        for(int i=1; i<n; i++){
            // 抉择：不放入第i个物品
            for(int j=0; j<w+1; j++){
                if(states[j] != -1){
                    states[j] = states[j];
                }
            }
            // 抉择：放入第i个物品
            for(int j=w; j>=0; j--){
                if(j+weight[i] <= w){
                    if(states[j] != 1){
                        states[j + weight[i]] = Integer.max(states[j] + value[i], states[j + weight[i]]);
                    }
                }
            }

            // 抉择：放入第i个物品
//            for(int j=0; j<w+1; j++){    // 这个是错误的解法
//                if(states[j] != -1 ){
//                    if(j + weight[i] < w+1){
//                        states[j+weight[i]] = Integer.max(states[j+weight[i]], states[j] + value[i]);
//                    }
//                }
//            }
        }

        for(int i=0; i<w+1; i++){
            System.out.print(states[i]);
            System.out.print(" ");
        }
    }
}