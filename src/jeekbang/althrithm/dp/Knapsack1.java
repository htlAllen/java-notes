package jeekbang.althrithm.dp;

public class Knapsack1 {
    public static void main(String[] args){
        KnapsackOfWay1 x = new KnapsackOfWay1();
        x.maxValueOfPack();
    }
}

class KnapsackOfWay1{
    /*
    背包最大容量为9，然后有5个物品分别不同的重要和价值，满足背包最大容量的条件下背包装的东西价值最多
     */
    int[] weight = {2,2,4,6,3};
    int[] value = {3,4,8,9,6};
    int n=5;
    int w=9;
    public void maxValueOfPack(){
        int[][] states = new int[5][w+1];
        for(int i=0; i<5; i++){
            for(int j=0; j<w+1; j++){
                states[i][j] = -1;
            }
        }
        for(int i=0; i<n; i++){
            states[i][0] = 0;
        }
        states[0][0] = 0;
        states[0][weight[0]] = value[0];

        for(int i=1; i<n; i++){
            for(int j=0; j<w+1; j++){
                // 找到当前背包有价值的地方
                if(states[i-1][j] != -1){
                    // (i, j):装入i个物品，重量为j时，最大的价值，关键是要分析出(i,j)如何从上一个状态求得，分析(i,j)的值可能怎么得到
                    // 1. (i, j) = (i-1, j)   //不放把i个物品
                    // 2. (i, j) =   (i-1, j - weight[i]) + value[i]   //背包中装入(i-1）个物品重量为j-weight[i]的最大装，此时装入weight[i],下标就变成了(i,j)
                    // 3. (i, j) = max{(i-1, j),  (i-1, j - weight[i]) + value[i]}

                    // 不放
                    if(j-weight[i]>=0){
                        states[i][j] = Integer.max(states[i-1][j], states[i-1][j -weight[i]] + value[i]);
                    }
                    else{
                        states[i][j] = states[i-1][j];
                    }
                    // 放
                    if(j + weight[i] <= w){
                        states[i][j+weight[i]] = Integer.max(states[i-1][j] + value[i], states[i-1][j+weight[i]]);
                    }
                }

            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<w+1; j++){
                System.out.print(states[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}