/**
 * @author INFITNITY Juejin:https://juejin.cn/user/2788017217999896
 * @date 2022年5月19日下午9:48:01
 */
package com.infinity.question_and_answer;

class A {
	private int a;
	public void setA(int a) {
		this.a = a;
	}
	public int getA() {
		return a;
	}
}
class B extends A {
	private int a;
	public void setA(int a) {
		this.a = a;
	}
//	 public int getA(){
//	 return a;
//	 }
}
public class PersonTest {
	public static void main(String[] args) {
		A c = new B();
		c.setA(5);
		System.out.println(c.getA());
	}
}
