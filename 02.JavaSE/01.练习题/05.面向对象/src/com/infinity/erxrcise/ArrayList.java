/**
 * @author INFITNITY Juejin:https://juejin.cn/user/2788017217999896
 * @date 2022年5月14日上午9:13:46
 */
package com.infinity.erxrcise;
public class ArrayList {
	public int[] copyArray(int[] arr){
		int[] arr1 = new int[arr.length];
		for(int i = 0;i < arr.length;i++) {
			arr1[i] = arr[i];
		}
		return arr1;
	}
	public static void main(String[] args) {
		ArrayList al = new ArrayList();
		int[] arr = {1,3,4};
		System.out.println(arr);
		System.out.println(al.copyArray(arr));		
	}
}
