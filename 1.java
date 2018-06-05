import java.util.Arrays;
import java.util.Comparator;

public class MinNumber {

	public static void main(String[] args) {
		System.out.println(PrintMinNumber(new int[] { 3, 321, 29 }));
	}

	public static String PrintMinNumber(int[] number) {
		Integer[] numbers = new Integer[number.length];
		for (int i = 0; i < number.length; i++) {
			numbers[i] = number[i];
		}
		Arrays.sort(numbers, new MyComparatorStr());
		// for (int i = 0; i < numbers.length; i++) {
		// System.out.println(numbers[i]);
		// }

		StringBuilder ans = new StringBuilder();
		for (int i = 0; i < numbers.length; i++) {
			ans.append(numbers[i]);
		}
		return ans.toString();
	}

}

class MyComparatorStr implements Comparator<Integer> {
	
	/*
	 * 采用方法:比较两个字符串，从前往后，如果相同位置a的数字小,说明a排在前面，反之b在前面。
	 * 假如a是b的子串，则判断更长的b的最后一个字符是否比b的第一个字符小，小则放前面，反之放后面。
	 * */

	@Override
	public int compare(Integer a, Integer b) {
		// System.out.println(a + " " + b);

		if (a == b)
			return 0;

		String f = String.valueOf(a);
		String s = String.valueOf(b);

		int i = 0;
		while (i < f.length() && i < s.length()) {
			if (f.charAt(i) < s.charAt(i)) {
				return -1;
			} else if (f.charAt(i) > s.charAt(i)) {
				return 1;
			}
			i++;
		}
		if (f.length() > s.length()) {
			return f.charAt(f.length() - 1) > f.charAt(0) ? 1 : -1;
		} else {
			return s.charAt(s.length() - 1) > s.charAt(0) ? -1 : 1;
		}

	}

}

