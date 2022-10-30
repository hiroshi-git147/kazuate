package test02;
// コンソールから入力した4桁の数字を配列に変換
public class Main {

	public static void main(String[] args) {
		int i = 3489;
		int[] array = new int[4];
		for(int num = 0; num < array.length; num++) {
			switch (num) {
				case (0):
					array[num] = i / 1000;
					break;
				case 1:
					array[num] = i / 100 - (i / 1000 * 10);
					break;
				case 2:
					array[num] = i / 10 - (i / 100 * 10);
					break;
				case 3:
					array[num] = i % 10;
					break;
			}
			System.out.println(num + ":" + array[num]);	
		}
		
//		int j = i / 1000;
//		int k = i / 100 - (i / 1000 * 10);
//		int m = i / 10 - (i / 100 * 10);
//		int n = i % 10;
//		System.out.println(j);
//		System.out.println(k);
//		System.out.println(m);
//		System.out.println(n);
	}

}
