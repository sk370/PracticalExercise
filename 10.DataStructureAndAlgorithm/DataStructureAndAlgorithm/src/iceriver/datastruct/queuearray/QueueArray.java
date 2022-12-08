package iceriver.datastruct.queuearray;

import java.util.List;
import java.util.Scanner;

public class QueueArray {
  /**
   * 创建队列测试
   * 
   * @param args
   */
  public static void main(String[] args) {
    Queue queue = new Queue(3);
    char key = ' ';// 接收用户输入
    Scanner scanner = new Scanner(System.in);
    boolean loop = true;
    while (loop) {
      System.out.println("s(show)：显示队列");
      System.out.println("e(exit)：退出程序");
      System.out.println("a(add)：添加数据到队列");
      System.out.println("g(get)：从队列中取出数据");
      System.out.println("h(head)：显查看队列头部数据");
      key = scanner.next().charAt(0);
      switch (key) {
        case 's':
          queue.showQueue();
          break;
        case 'a':
          System.out.println("请输入一个数");
          int value = scanner.nextInt();
          queue.addQueue(value);
          break;
        case 'g':
          try{
            int res = queue.getQueue();
            System.out.printf("取出的数据是%d\n", res);
          }catch(Exception e){
              System.out.println(e.getMessage());
          }
          break;
        case 'h':
          try {
            int res = queue.showHead();
            System.out.printf("取出的头部数据是%d\n", res);
          } catch (Exception e) {
            System.out.println(e.getMessage());
          }
          break;
        case 'e':
          scanner.close();
          loop = false;
          System.out.println("程序退出！");
          break;
      }
    }
  }
}

/**
 * 数组模拟队列结构
 */
class Queue {
  private int maxSize;
  private int front;
  private int rear;// 队列尾
  private int[] arr;

  /**
   * 初始化指定大小的队列
   * 
   * @param arrMaxSize
   */
  public Queue(int arrMaxSize) {
    maxSize = arrMaxSize;
    arr = new int[maxSize];
    front = -1;
    rear = -1;
  }

  /**
   * 判断队列是否满
   * 
   * @return
   */
  public boolean isFull() {
    return rear == maxSize - 1;
  }

  /**
   * 判断对列是否空
   * 
   * @return
   */
  public boolean isEmpty() {
    return rear == front;
  }

  /**
   * 添加数据
   * 
   * @param n
   */
  public void addQueue(int n) {
    if (isFull()) {
      System.out.println("队列满，无法添加！");
      return;
    }
    rear++;
    arr[rear] = n;
  }

  /**
   * 取出数据
   * 
   * @return
   */
  public int getQueue() {
    if (isEmpty()) {
      throw new RuntimeException("队列空，不能取数据！");
    }
    front++;
    return arr[front];
  }

  /**
   * 显示队列所有数据
   */
  public void showQueue() {
    if (isEmpty()) {
      System.out.println("队列空，无数据输出！");
      return;
    }
    for (int i = 0; i < arr.length; i++) {
      System.out.printf("arr[%d]=%d\n", i, arr[i]);
    }
  }

  /**
   * 显示队列的头数据
   * 
   * @return
   */
  public int showHead() {
    if (isEmpty()) {
      throw new RuntimeException("队列空，无数据！");
    }
    return arr[front + 1];
  }
}