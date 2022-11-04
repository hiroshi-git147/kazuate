package kazuate;

import java.util.Scanner;

public class Kazuate{
	final static int answer_size = 4;  // 当てる数。
	static int count = 1; // カウンター

    public static void main(String[] args){
    	int[] comAnswer = comGuess();
    	System.out.print("パソコンの答え；");

    	// デバッグ用(パソコンの答え)
    	for (int com : comAnswer){
    		System.out.print(com);
    	}
    	System.out.println("");

    	System.out.println("4桁の数字を予想してください");

    	int[] userAnswer = userGuess();
    	while (comAnswer != userAnswer) {
    		checkAnswer(comAnswer, userAnswer);
    		// カウントを1増やす
    		count++;
    		userAnswer = userGuess();
    	}


		System.out.println("「正解です！」");
		System.out.println("あなたは" + count + "回で正解しました。」");
		System.out.print("パソコンの答えは：");
    	for (int com : comAnswer){
    		System.out.print(com);

    	}



     }

    // コンピューターが無作為に作成した４桁の数字メソッド
    public static int[] comGuess() {
    	// 10個の要素を持つ配列を作成
    	int[] answer = new int[answer_size];
    	// 4回繰り返す
        for(int i = 0; i < answer.length; i++) {
        	Loop: while(true) {
	        	// trueの場合0～9の数字を生成
	        	answer[i] = (int)(Math.random()*10);
	        	for(int j = 0; j < i; j++) {
	        		// その前までの数値が同じ数値の場合数値代入からやり直し
	        		if(answer[j] == answer[i]) continue Loop;
	        	}
	        	break;
	        }
        }
        return answer;
    }

    // コンソールから入力するプログラム
    public static int guessNumber(int number) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		return n;
	}

    // コンソールから入力した4桁の数字を配列に変換
    public static int[] userGuess() {
    	int[] array = new int[answer_size];

		int user = guessNumber(answer_size);

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

    public static void checkAnswer(int[] comAnswer, int[] userAnswer) {
    	String total;
    	for(int i = 0; i < userAnswer.length; i++) {
		if(comAnswer[i] == userAnswer[i]) {
			total = "○";
		} else {
			total = "X";
		}
		for(int j = 0; j < comAnswer.length; j++) {
			if(comAnswer[j] == userAnswer[i]) {
				total = total.replace("X", "△");
			}
		}
		System.out.print(total);
	}

	// 数を再入力
	System.out.println("");
	System.out.print("[入力]＞");

    }
}
