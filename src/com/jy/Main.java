package com.jy;

public class Main {

	public static void main(String[] args) {
		int[] array1 = new int[] { 3, 4, 5, 1, 2 };
		int[] array2 = new int[] { 1, 0, 1, 1, 1 };
		printResult(array1);
		System.out.println();
		printResult(array2);
	}

	/**
	 * 二分法查找最小值
	 * 
	 * @param array
	 *            递增数组的旋转数组
	 * @return 最小值
	 */
	private static int minOfRotateArray(int[] array) {
		// 鲁棒性检查
		if (array == null || array.length == 0)
			throw new RuntimeException("Invalid Input!");

		// 二分法的索引
		int indexStart = 0;
		int indexEnd = array.length - 1;
		int indexMid = indexStart;

		// 二分法查找最小值
		while (array[indexStart] >= array[indexEnd]) {
			// 当前后索引相差1位时，则找到了分界点，即找到了最小值的索引
			if (indexEnd - indexStart == 1) {
				indexMid = indexEnd;
				break;
			}
			indexMid = (indexStart + indexEnd) / 2;
			if (array[indexStart] == array[indexEnd] && array[indexMid] == array[indexStart])
				return minOrder(array, indexStart, indexEnd);
			// 中间的数位于第一个数组中
			if (array[indexMid] >= array[indexStart])
				indexStart = indexMid;
			else if (array[indexMid] <= array[indexEnd]) // 中间的数位于第二个数组中
				indexEnd = indexMid;

		}
		return array[indexMid];
	}

	/**
	 * 顺序查找最小值
	 * 
	 * @param array
	 *            递增数组的旋转数组
	 * @param indexStart
	 *            查找范围开始的位置
	 * @param indexEnd
	 *            查找范围结束的位置
	 * @return 最小值
	 */
	private static int minOrder(int[] array, int indexStart, int indexEnd) {
		int min = array[indexStart];
		for (int i = indexStart; i <= indexEnd; i++) {
			if (array[i] < min)
				min = array[i];
		}
		return min;
	}

	/**
	 * 输出查找出的最小值的结果
	 * 
	 * @param array
	 *            待查找的数组
	 */
	private static void printResult(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.print("最小值是  " + minOfRotateArray(array));
	}

}
