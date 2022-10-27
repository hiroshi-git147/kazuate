package sannshou;

public class Main {

	public static void main(String[] args) {
		int[] array = makeArray(3);
		for (int i : array) {
			System.out.println(i);
		}
	}

	// 指定した個数のint型配列を作成する
	public static int[] makeArray(int size) {
		int[] newArray = new int[size];
		for (int i = 0; i < newArray.length; i++) {
			newArray[i] = i;
		}

		// メソッド内で作成した配列の参照を
		// 呼び元へ戻す
		return newArray;
	}




}
