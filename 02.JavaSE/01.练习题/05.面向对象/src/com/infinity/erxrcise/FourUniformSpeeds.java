/**
 * @author INFITNITY Juejin:https://juejin.cn/user/2788017217999896
 * @date 2022年5月14日上午9:33:53
 */
package com.infinity.erxrcise;

public class FourUniformSpeeds {
	public int add(int m, int n) {
		return m + n;
	}
	public int reduce(int m, int n) {
		return m - n;
	}
	public int multiplication(int m,int n) {
		return m * n;
	}
	public double division(int m,int n) {
		if(n == 0) {
			System.out.println("除数为0，请重新输入！");
			return 0.0;
		}else {
			return (double) m /n;
		}
	}
	public static void main(String[] args) {
		FourUniformSpeeds fs = new FourUniformSpeeds();
		System.out.println(fs.division(10, 3));
	}

}
