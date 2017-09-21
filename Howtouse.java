import javax.swing.*;

/** 電卓の使い方を説明するウィンドウを表示 */
public class Howtouse extends JFrame{
    
    /**メインメソッド*/
    public static void main(String[] args){
	Howtouse frame = new Howtouse("使い方");
	frame.setVisible(true);
    }
    
    /**コンストラクタ*/
    Howtouse(String text) {
	setTitle(text);
	setSize(600,402);
	setLocation(930, 700);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	String sep = System.getProperty("line.separator");
	
	JLabel label = new JLabel("<html><body>【色の変更】<br />　この関数電卓では、関数電卓の色を任意の色に変えることができます。メニューバーにある「色の変更」から任意の色を選ぶことで、選択した色の関数電卓が表示されます。色は、BLUE,ORANGE,RED,GREEN,REDの５色から相互的に切り替えることができます。<br /><br />【通常の電卓への切り替え】<br />　メニューバーで「電卓の切り替え」→「通常の電卓に切り替え」の順にボタンを押すと、通常の電卓に切り替わります。また、通常の電卓から関数電卓に戻ることも可能です。<br /><br />【グラフの表示】<br />　式の中に「x」もしくは「y」がある状態で「=」もしくはEnterキーを押すと、gnuplotによりその式の表す2次元グラフを表示します。この際、式中の「×」,「÷」,「e」,「π」はgnuplot用にそれぞれ「*」,「/」,「exp」「pi」としてgnuplotに出力されます。なお、電卓に表示されている式中に「x」「y」の両方がある場合、自動的に3次元でグラフを表示するようになっています。ただし、先述した文字の切換以外はgnuplotに適した入力をしないとグラフを出力しません。<br /><br />【キーボード入力】<br />　この関数電卓では、キーボードでの入力に対応しています。また、電卓上の「B.S(バックスペース)ボタン」、「=ボタン」はそれぞれキーボードのバックスペースキー、Enterキーに対応しています。<br /><br />【履歴の表示】<br />　関数電卓を起動した際に、関数電卓ウィンドウの右隣りのウィンドウに履歴用のウィンドウが同時に立ち上がるようになってあります。ここには、電卓上で「=ボタン」（もしくはEnterキー）が押された際に、直後の計算結果を含む式全体が表示されるようになってあります。電卓側で新たに計算しても表示された式は履歴として履歴ウィンドウに残ります。<br /><br /></body></html>");

	add(label);

}
}
