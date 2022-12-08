package iceriver.datastruct.sparsearray;

public class SparseArray {
  public static void main(String[] args) {
    // 棋盘游戏：1. 棋盘大小 11*11  2. 0表示没有棋子，1表示黑子，2表示白子

    // 1. 二维数组表示棋盘
    int[][] chessArr = new int[11][11];
    chessArr[1][2] = 1;
    chessArr[2][3] = 2;
    chessArr[4][5] = 2;
    for (int[] rows : chessArr) {
      for (int item : rows) {
        System.out.printf("%d\t",item);
      }
      System.out.println();
    }

    System.out.println("=================");

    // 2. 转化为稀疏数组
    // 2.1 遍历二维数组，计算有多少行，多少列，多少个有效数据
    int sum = 0;
    int row = chessArr.length;
    int col = chessArr[0].length;
    for (int i = 0; i < chessArr.length; i++) {
      for (int j = 0; j < col; j++) {
        if(chessArr[i][j] != 0){
          sum++;
        }
      }
    }
    // 2.2 创建对应大小的稀疏数组
    int parseArr[][] = new int[sum + 1][3];
    // 2.3 设置稀疏数组的首行值
    parseArr[0][0] = row;
    parseArr[0][1] = col;
    parseArr[0][2] = sum;
    int k = 1;
    // 2.4 填入二维数组的有效值
    for (int i = 0; i < chessArr.length; i++) {
      for (int j = 0; j < chessArr.length; j++) {
        if (chessArr[i][j] != 0) {
          parseArr[k][0] = i;
          parseArr[k][1] = j;
          parseArr[k][2] = chessArr[i][j];
          k++;
        }
      }
    }
    // 2.5 查看稀疏数组
    for (int[] rows : parseArr) {
      for (int item : rows) {
        System.out.printf("%d\t", item);
      }
      System.out.println();
    }

    System.out.println("=================");

    // 3. 稀疏数组恢复为二维数组
    // 3.1 读取稀疏数组首行，创建对应大小的二维数组
    int[][] newChessArr = new int[parseArr[0][0]][parseArr[0][1]];
    // 3.2 遍历稀疏数组
    for (int i = 1; i < parseArr.length; i++) {
      newChessArr[parseArr[i][0]][parseArr[i][1]] = parseArr[i][2];
    }
    // 3.3 输出新数组
    for (int[] rows : newChessArr) {
      for (int item : rows) {
        System.out.printf("%d\t", item);
      }
      System.out.println();
    }
  }
}
