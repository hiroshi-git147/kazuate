package kazuate;


import java.util.Random;
import java.util.Scanner;

public class Kazuate{
    public static void main(String[] args){
    	comGuess();
    	int user = getUserNumber();
     }


    // コンピューターが無作為に作成した４桁の数字メソッド
    public static void comGuess() {
    	Random rnd = new Random();
    	int count = 4;
    	// 10個の要素を持つ配列を作成
    	int[] newArray = new int[10];

    	// 4回繰り返す
        for(int i = 0; i < count; i++) {


        Loop: while(true) {
        	// trueの場合0～9の数字を生成
        	newArray[i] = rnd.nextInt(9);

        	for(int j = 0; j < i; j++) {
        		// その前までの数値が同じ数値の場合数値代入からやり直し
        		if(newArray[j] == newArray[i]) continue Loop;
        	}
        	break;
        }
        System.out.print(newArray[i]);
        }

    }

    public static int getUserNumber() {
    	Scanner sc = new Scanner(System.in);
    	System.out.println("4桁の数字を入力してください");
    	int user;
    	while(true) {
    		try {
	    		user = sc.nextInt();
	    		break;
	    	} catch(Exception e) {
				System.out.println("数字を入力してください");
				sc.next();
	    	}
    	}

    	return user;
    }
}