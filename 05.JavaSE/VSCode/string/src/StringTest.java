import java.util.Arrays;
import java.util.Scanner;

import org.junit.Test;

public class StringTest {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String sum = "";
            String s = sc.nextLine();
            String[] strs = s.split(",");
            System.out.println(Arrays.toString(strs));
            Arrays.sort(strs);
            for (int j = 0; j < strs.length; j++) {
                if (j == strs.length - 1) {
                    sum += strs[j];
                } else {
                    sum += strs[j] + "，";
                }
            }
            System.out.println(sum);
        }
    }

    @Test
    public void test01() {
        String str1 = "Hello world";
        String str2 = "l";
        System.out.println(str1.contentEquals(str2));
    }

    @Test
    public void test02() {
        Scanner sc = new Scanner(System.in);
        String num = sc.nextLine();
        int line = Integer.parseInt(num);
        int i = 0;
        while (i < line) {
            int sum = 0;
            String s = sc.nextLine();
            String[] strs = s.split(" ");
            for (int j = 1; j < strs.length; j++) {
                sum += Integer.parseInt(strs[i]);
            }
            System.out.println(sum);
            i++;
        }
    }
 


}

