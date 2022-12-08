import java.util.Scanner;

import org.junit.Test;

public class ScannerTest {
  public static void main(String[] args) {    
  }
  @Test
  public void test01(){
    Scanner scanner = new Scanner(System.in);
    String str = scanner.next();
    System.out.println(str);
    scanner.close();
  }
  
}
