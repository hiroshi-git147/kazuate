package kazuate;

import java.util.Scanner;

public class Test02 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		int[] array = getUserNumber(4);
		for(int i = 0; i < array.length; i++) {
			System.out.println(i + ":" + array[i]);
		}
	}
	
	public static int[] getUserNumber(int number) {
    	Scanner sc = new Scanner(System.in);
    	int[] array = new int[number];
    	System.out.println("4桁の数字を入力してください");
		int user = sc.nextInt();
			
		for(int i = 0; i < array.length; i++) {
			if (array[i] == 0) {
				array[i] = user / 1000;
			} else if (array[i] == 1) {
				array[i] = user / 100 - (user / 1000 * 10);
			} else if (array[i] == 2) {
				array[i] = user / 10 - (user / 100 * 10);
			} else {
				array[i] = user % 10;
			}
		}

    	return array;
    }

}
