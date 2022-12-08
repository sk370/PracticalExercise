package iceriver.datastruct.sparsearray;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SparseArrayIO {
  public static void main(String[] args) {
    // 棋盘游戏：1. 棋盘大小 11*11 2. 0表示没有棋子，1表示黑子，2表示白子

    // 1. 从磁盘读取数据（使用了文件流）
    // File chessArrFile = new File("D:\\实践练习\\10.DataStructureAndAlgorithm\\DataStructureAndAlgorithm\\src\\iceriver\\datastruct\\sparsearray\\chessArrFile.txt");
    File chessArrFile = new File("src/iceriver/datastruct/sparsearray/chessArrFile.txt");
    System.out.println("开始读取" + chessArrFile.getName());
    FileReader fr = null;
    String str = "";
    try {
      fr = new FileReader(chessArrFile);
      char[] ch = new char[1024];
      int len;
      while ((len = fr.read(ch)) != -1) {
        str += new String(ch, 0, len);
      }
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } finally {
      try {
        fr.close();
        System.out.println(chessArrFile.getName() + "读取完毕");
      } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }
    String[] strArrRows = str.split("\r\n");//大坑点：windows中，换行符为\r\n，单纯以\n分割时，末尾的0会带着\r
    String[] strArrCols = strArrRows[0].split(" ");
    int rows = strArrRows.length;
    int cols = strArrCols.length;
    System.out.println(rows);
    System.out.println(cols);
    int[][] chessArr = new int[rows][cols];

    for (int i = 0; i < rows; i++) {
      String[] temp = strArrRows[i].split(" ");
      for (int j = 0; j < cols; j++) {
        chessArr[i][j] = Integer.parseInt(temp[j]);
        System.out.print(chessArr[i][j] + " ");
      }
      System.out.println();
    } 
  }
}
