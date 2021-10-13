package it7.reverse;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution solution = new Solution();
		Scanner in = new Scanner(System.in);
		int result = solution.reverse(in.nextInt());
		System.out.print(result);
	}

}

class Solution {
	public int reverse(int x) {
		int temp = x;
		StringBuffer str = new StringBuffer();
		if (x == -2147483648) {
			return 0;
		}
		if (x < 0) {
			x = -x;
		} else if (x == 0) {
			return 0;
		}
		while (x != 0) {
			str.append(x % 10);
			x /= 10;
		}
		// 借助long类型的数暂时接收反转后的整数
		long res = Long.parseLong(str.toString());
		// 原数是负数，且转换后溢出
		if (temp < 0 && res > 2147483647) {
			return 0;
		}
		// 原数是正数，且转换后溢出，因为这里直接使用2147483647会报错，提示超出范围，
		// 所以我们用相反数进行合法性判定
		if (temp > 0 && -res < -2147483648) {
			return 0;
		}
		// 将符号补上
		if (temp < 0) {
			res = -res;
		}
		return (int) res;
	}
}