/*　問題点
 * ・一回の入力で正解した場合の分岐に不具合発生
 * ・桁は違うが数値が一致しているときは△を表示するプログラムができていない
 */

package kazuate;

import java.util.Scanner;

public class Kazuate{
    public static void main(String[] args){
    	int[] comArray = comGuess(4);
    	System.out.print("パソコンの答え；");
	    
	// デバッグ用
    	for (int com : comArray){
    		System.out.print(com);
    	}
    	System.out.println("");
	
    	System.out.println("パソコンが作成した4桁の数字を予想してください");
    	int[] userArray = getUser(4);
    	int count = 0;
    	while (comArray != userArray) {
    		for(int i = 0; i < comArray.length; i++) {
    			if (comArray[i] == userArray[i]) {
    				System.out.print("○");
    			} else {
    				System.out.print("X");
    			}
    		}
    		count++;
    		System.out.println("");
    		System.out.print("[入力]＞");
    		userArray = getUser(4);
    	}
		
    	System.out.println("「正解です！」");
		System.out.println("あなたは" + count + "回で正解しました。」");
		System.out.print("パソコンの答えは：");
    	for (int com : comArray){
    		System.out.print(com);
    		
    	}
     }
    
    // コンピューターが無作為に作成した４桁の数字メソッド
    public static int[] comGuess(int size) {
    	int count = 4;
    	// 10個の要素を持つ配列を作成
    	int[] comNum = new int[size];
    	// 4回繰り返す
        for(int i = 0; i < count; i++) {
	        Loop: while(true) {
	        	// trueの場合0～9の数字を生成
	        	comNum[i] =new java.util.Random().nextInt(9);
	        	for(int j = 0; j < i; j++) {
	        		// その前までの数値が同じ数値の場合数値代入からやり直し
	        		if(comNum[j] == comNum[i]) continue Loop;
	        	}
	        	break;
	        }
        }
        return comNum;
    }
    
    // コンソールから入力するプログラム
    public static int guessNumber(int number) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		return n;
	}

    // コンソールから入力した4桁の数字を配列に変換
    public static int[] getUser(int number) {
    	int[] array = new int[number];
    	
		int user = guessNumber(4);
		
		for(int i = 0; i < array.length; i++) {
			
			// 入力した数字の1〜4桁の数字を配列0〜3に代入するプログラム
			switch (i) {
				case (0):
					array[i] = user / 1000;
					break;
				case 1:
					array[i] = user / 100 - (user / 1000 * 10);
					break;
				case 2:
					array[i] = user / 10 - (user / 100 * 10);
					break;
				case 3:
					array[i] = user % 10;
					break;
			}
		}

    	return array;
    }
}
