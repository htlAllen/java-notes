package jeekbang.althrithm.dp;

public class Knapsack0 {
    public static void main(String[] args){
        KnapsackOfWay0 x1 = new KnapsackOfWay0();
        x1.maxWeight();

        KnapsackOfWay0Back x2 = new KnapsackOfWay0Back();
        x2.maxWeight();
    }
}

class KnapsackOfWay0{
    int[] weight = {2,2,4,6,3};
    int w = 9;
    int n = 5;
    public void maxWeight(){
        boolean[][] result = new boolean[n][w+1];
        for(int i=0; i<n; i++){
            for(int j=0; j<w+1; j++){
                result[i][j] = false;
            }
        }
        result[0][0] = true;
        if(weight[0] <= w+1){ result[0][weight[0]] = true;}

        for(int i=1; i<n; i++){
            for(int j=0; j<w+1; j++){
                if(result[i - 1][j]){
                    // 不放--抉择
                    result[i][j] = result[i-1][j];
                    // 放--抉择
                    if(j+weight[i] < w+1){result[i][j+weight[i]] = true;}

                }
            }
        }
        int i=0;
        while (i<n) {
            for(int j=0; j<w+1; j++){
                System.out.print(result[i][j]);
                System.out.print(" ");
            }
            System.out.println();
            i++;
        }

    }
}

class KnapsackOfWay0Back{
    int[] weight = {2,2,4,6,3};
    int w = 9;
    int n = 5;
    public void maxWeight(){
//        int[] result = new int[n];
        boolean[] result = new boolean[w + 1];  // 用一个数组来存储状态集合
        result[0] = true;
        result[2] = true;
        for(int i=1; i<n; i++){
            for(int j=0; j<w+1; j++){
                if(result[j] && weight[i] + j < w+1){
                    result[j+weight[i]] = true;
                }
            }
        }
        for(int k=0; k<w+1; k++){
            System.out.print(result[k]);
            System.out.print(" ");
        }
    }
}