package jeekbang.althrithm;

import javafx.util.Pair;

public class BackTrack {
    // 数组的下标代表是第几个皇后，数组的值代表皇后所在的列
    public static void main(String[] args) {
        char[][] x = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        Sudoku a = new Sudoku(x);
        a.solveSudoku(0, a.getLengthOfsudoku());


    }

}

class Sudoku {
    private char[][] board;

    public Sudoku(char[][] x) {
        board = x;
    }

    public void solveSudoku(int count, int length) {
        if (count == length) {
            System.out.println("what??");
            print();
            return;
        }
        // 找出还未被填写的值
        boolean flag = false;
        int row = 0, column = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    row = i;
                    column = j;
                    flag = true;
                    break;
                }
            }
            if(flag){
                break;
            }

        }

        for (int i = 1; i <= 9; i++) {
            char char_i = String.valueOf(i).toCharArray()[0];
            if (isOk(row, column, char_i)) {
                board[row][column] = char_i;
                print();
                System.out.println();
                solveSudoku(count+1, length);
            }
        }
    }

    public boolean isOk(int row, int column, char value) {
        // 判断行列的情况
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == value) {
                    return false;
                }
            if (board[i][column] == value) {
                return false;
            }

        }
        // 判断三宫格的情况
        if (row >= 0 && row <= 2) {
            if (column >= 0 && column <= 2) {
                for (int m = 0; m <= 2; m++) {
                    for (int n = 0; n <= 2; n++) {
                        if (board[m][n] == value) {
                            return false;
                        }
                    }
                }
            }
            if (column >= 3 && column <= 5) {
                for (int m = 0; m <= 2; m++) {
                    for (int n = 3; n <= 5; n++) {
                        if (board[m][n] == value) {
                            return false;
                        }
                    }
                }
            }
            if (column >= 6 && column <= 8) {
                for (int m = 0; m <= 2; m++) {
                    for (int n = 6; n <= 8; n++) {
                        if (board[m][n] == value) {
                            return false;
                        }
                    }
                }
            }
        }
        if (row >= 3 && row <= 5) {
            if (column >= 0 && column <= 2) {
                for (int m = 3; m <= 5; m++) {
                    for (int n = 0; n <= 2; n++) {
                        if (board[m][n] == value) {
                            return false;
                        }
                    }
                }
            }
            if (column >= 3 && column <= 5) {
                for (int m = 3; m <= 5; m++) {
                    for (int n = 3; n <= 5; n++) {
                        if (board[m][n] == value) {
                            return false;
                        }
                    }
                }
            }
            if (column >= 6 && column <= 8) {
                for (int m = 3; m <= 5; m++) {
                    for (int n = 6; n <= 8; n++) {
                        if (board[m][n] == value) {
                            return false;
                        }
                    }
                }
            }
        }
        if (row >= 6 && row <= 8) {
            if (column >= 0 && column <= 2) {
                for (int m = 6; m <= 8; m++) {
                    for (int n = 0; n <= 2; n++) {
                        if (board[m][n] == value) {
                            return false;
                        }
                    }
                }
            }
            if (column >= 3 && column <= 5) {
                for (int m = 6; m <= 8; m++) {
                    for (int n = 3; n <= 5; n++) {
                        if (board[m][n] == value) {
                            return false;
                        }
                    }
                }
            }
            if (column >= 6 && column <= 8) {
                for (int m = 6; m <= 8; m++) {
                    for (int n = 6; n <= 8; n++) {
                        if (board[m][n] == value) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;

    }

    public int getLengthOfsudoku() {
        int length = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    length++;
                }
            }
        }
        return length;
    }

    public void print() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}

class eightQueen{
    int[] result = new int[8];
    int count = 0;

    public void cal8queens(int row) {
        if (row == 8) {
            print8Queens();
            return;
        }
        for (int columns = 0; columns < result.length; columns++) {
            if (isOk(row, columns)) {
                result[row] = columns;
                cal8queens(row + 1);
            }
        }
    }

    public boolean isOk(int row, int column) {
        int leftup = column - 1;
        int rightup = column + 1;
        for (int i = row - 1; i >= 0; i--) {
            if (result[i] == column) {
                return false;
            }
            if (leftup >= 0) {
                if (result[i] == leftup) {
                    return false;
                }
            }
            if (rightup <= result.length) {
                if (result[i] == rightup) {
                    return false;
                }
            }
            leftup--;
            rightup++;
        }
        return true;
    }

    public void print8Queens() {
        char[] print = {'*', '*', '*', '*', '*', '*', '*', '*'};
        for (int i = 0; i < result.length; i++) {
            print[result[i]] = '-';
            System.out.println(print);
            print[result[i]] = '*';
        }
        System.out.println(count++);
    }
}

class BagOf01{
    int max = Integer.MIN_VALUE;
    // 背包所能容纳的重量
    private int w;
    // 物品集合
    private int[] item;
    private int length;
    public void setW(int weight){
        w = weight;
    }
    public void setItems(int[] items){
        item = items;
    }
    public int getLength(){
        return item.length;
    }
    public int getW(){
        return w;
    }
    public int[] getItems(){
        return item;
    }
    public void maxWeight(int citem, int cweight){
        // 当前背包的最大值
        if (cweight > max){
            max = cweight;
        }
        if(citem == getLength()){
            return;
        }
        // 回溯法的关键所在：for循环加递归
        for(int i=0; i<2; i++){
            // i=0:将物品放入背包； i=1将物品不放入背包
            if (i == 0){
                if((cweight + item[citem]) < w){
                    cweight = cweight + item[citem];
                    maxWeight(citem + 1, cweight);
                }
            }
            if (i == 1){
                if(cweight < w){
                    maxWeight(citem + 1, cweight);
                }
            }
        }
    }
}

class Knapsack{
    public void knapsack(int[] weight, int n, int w){
        boolean[][] states = new boolean[n][w+1];
        states[0][0] = true;
        if(weight[0] < w){
            states[0][weight[0]] = true;
        }
        for(int i=1; i<n; i++){
            for(int j=0; j<w+1; j++){
                if(states[i-1][j] == true){
                    // 不加当前的重量
                    states[i][j] = true;
                    // 加上当前的重量
                    if(weight[i]+j <= w){ states[i][weight[i] + j] = true; }
                }
            }
        }
    }
}

