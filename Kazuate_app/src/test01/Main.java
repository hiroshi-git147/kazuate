package kazuate;

public class Test {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		int[] comArray = comGuess(4);
		for(int i = 0; i < comArray.length; i++) {
			System.out.println(i + ":" + comArray[i]);
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

}
