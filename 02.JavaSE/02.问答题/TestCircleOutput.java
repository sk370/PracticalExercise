public class TestCircleOutput{
  public static void main(String[] args){
    label: for (int i = 1; i <= 4; i++) {
            for (int j = 1; j <= 10; j++) {
                if (j % 4 == 0) {
                    continue label;
                }
                System.out.print(j + "\t");
            }
            System.out.println("*");
        }
  }
}