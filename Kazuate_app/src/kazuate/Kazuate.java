package kazuate;

import java.util.Scanner;

public class Kazuate{
	final static int ANSWER_SIZE = 4;  // 当てる数。
	static int count = 1; // カウンター

	// メインメソッド
    public static void main(String[] args){
    	int[] comAnswer = comGuess();
    	System.out.print("パソコンの答え；");

    	// デバッグ用(パソコンの答え)
    	for (int com : comAnswer){
    		System.out.print(com);
    	}
    	System.out.println("");

    	System.out.println("4桁の数字を予想してください");
    	System.out.print("[入力]＞");

		int[] userAnswer = userGuess();

		// 判定
		for(int i = 0; i < userAnswer.length; i++) {
 			// パソコンとユーザーの入力した値が一致していないとき
 			while(comAnswer[i] != userAnswer[i]) {
 				// カウントを1増やす
 	    		count++;
 	    		// ヒントをもらう
 	    		getHint(comAnswer, userAnswer);
 	    		// 再入力
 	    		userAnswer = userGuess();
 			}
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
    	// 4個の要素を持つ配列を作成
    	int[] answer = new int[ANSWER_SIZE];
    	// 4回繰り返す
        for(int i = 0; i < answer.length; i++) {
        	answer[i] = (int)(Math.random()*10);
        	for(int j = 0; j < i;) {
            	answer[i] = (int)(Math.random()*10);
        		// その前までの数値が同じ数値の場合数値代入からやり直し
        		if(answer[j] == answer[i]) {
        			j=0;
        			continue;
        		}
        		j++;
        	}
        }
        return answer;
    }

    // コンソールから入力するメソッド
    public static String guessNumber() {
		Scanner sc = new Scanner(System.in);
		String n = sc.nextLine();
		if (n.length() > 4 || n.length() < 4 ) {
			System.out.println("エラー：4桁の数字を入力してください");
			System.out.print("[入力]＞");
			n = guessNumber();
		}
		return n;
	}

    // コンソールから入力した4桁の数字を配列に変換するメソッド
    public static int[] userGuess() {
    	String user = guessNumber();
    	String[] strArray = user.split("");
    	int[] array = new int[4];

		for(int i = 0; i < array.length; i++) {
			array[i] = Integer.parseInt(strArray[i]);
		}
    	return array;
    }

    // ヒント生成メソッド
    public static void getHint(int[] comAnswer, int[] userAnswer) {
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
