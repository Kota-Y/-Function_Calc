import javax.swing.*;

/** 関数の定義や正しい入力方法を説明するウィンドウを表示 */
public class Discription extends JFrame{
   
   public static void main(String[] args){
	Discription frame = new Discription("関数の説明");
	frame.setVisible(true);
    }

    Discription(String text) {
	setTitle(text);
	setSize(600,520);
	setLocation(930, 580);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


	String sep = System.getProperty("line.separator");

	JLabel label = new JLabel("<html><body>　【exp】 : 自然対数を示す.<br /><br />　【π】 : 円周率を示す.<br /><br />　【√】 : √ボタンを押した後,数値を入力することで平方根の値を示す.<br /><br />　【1/x】 : 1/xボタンを押した後,数値を入力することで逆数を示す.<br /><br />　【sin】 : sinボタンを押した後,数値を入力することで三角関数sinの値を示す.<br /><br />　【cos】 : cosボタンを押した後,数値を入力することで三角関数cosの値を示す.<br /><br />　【tan】 : tanボタンを押した後,数値を入力することで三角関数tanの値を示す.<br /><br />　【10^x】 : 10^xボタンを押した後,10の乗数である数値を入力することで10のx乗を示す.<br /><br />　【sinh】 : sinhボタンを押した後,数値を入力することで逆三角関数sinhの値を示す.<br /><br />　【cosh】 : coshボタンを押した後,数値を入力することで逆三角関数coshの値を示す.<br /><br />　【tanh】 : tanhボタンを押した後,数値を入力することで逆三角関数tanhの値を示す.<br /><br />　【n!】 : n!ボタンを押した後,数値を入力することで階乗を示す.<br /><br />　【log】 : logボタンを押した後,一つ目の数値を入力し→ボタンを押す.そのあと２つ目の数値を入力することで一つ目の数字を底とした対数を示す.<br /><br />　【logx】 : logxボタンを押した後,数値を入力することで底を10とした対数を示す.<br /><br />　【ln】: lnボタンを押した後,数値を入力することで底をeとした対数を示す.<br /><br />　【xCy】: xCyボタンを入力した後,xである整数値を入力し→ボタンを押す.次にyである整数値を入力することで,xある数から,y個をを選ぶ場合の組み合わせの数を示す.(x>=y)<br /><br />　【xPy】 : xPyボタンを入力した後,xである整数値を入力し→ボタンを押す.次にyである整数値を入力することで,x個からr個取った順列を示す.(x>=y)</body></html>");
	
	add(label);
  }
}
