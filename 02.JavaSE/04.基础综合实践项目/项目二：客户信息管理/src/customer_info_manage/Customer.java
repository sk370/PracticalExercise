/**
 * @author INFITNITY Juejin:https://juejin.cn/user/2788017217999896
 * @date 2022年5月15日上午11:45:10
 */
package customer_info_manage;

public class Customer {
	private String name;
	private char gender;
	private int age;
	private String phone;
	private String email;
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return this.name;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Customer(String name, char gender, int age, String phone, String email) {
		super();
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.phone = phone;
		this.email = email;
	}
	public static void main(String[] args) {
//		Customer cs = new Customer("小王", '男', 18, "13098482832", "145228471@qq.com");
//		System.out.println(cs);
	}
}
