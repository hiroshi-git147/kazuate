/*
 * 4桁の数字を作成
 * 同じ数字を使用しない
 *
 * 3重ループにして、無理やりラベル付きbreakをして飛ばしていますが、
 * breakとcontinueの考えを逆にすると2重ループで済むはずです。
 * コメントにあるように
 * // その前までの数値が同じ数値の場合数値代入からやり直しではなく
 *「違う数字だったら設定して次の桁へ進む」
 * と考えると良いと思います。
 * 判断基準を今と逆にするわけです。
 *
 */

package test02;
public class Main {
	public static void main(String[] args) {
		// 4個の要素を持つ配列を作成
		int[] answer = new int[4];
    	// 4回繰り返す
        for(int i = 0; i < answer.length; i++) {
        	// trueの場合0～9の数字を生成
        	answer[i] = (int)(Math.random()*10);
        	for(int j = 0; j < i;) {
            	// trueの場合0～9の数字を生成
            	answer[i] = (int)(Math.random()*10);
        		// その前までの数値が同じ数値の場合数値代入からやり直し
        		if(answer[j] == answer[i]) {
        			j=0;
        			continue;
        		}
        		j++;
        	}
        }
        for(int n = 0; n < answer.length; n++) {
        	System.out.print(answer[n]);
        }
	}
}
