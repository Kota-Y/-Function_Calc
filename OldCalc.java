import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.io.IOException;

/** 電卓クラス(電卓プログラムのメインクラス) **/
public class OldCalc extends JFrame implements ActionListener{
    /** 数字ボタン. 0から9の10個 */
    private OldNumButton[] numButton;
    /** 演算器号ボタン. + - * / の4つ */
    private OldOpButton[] opButton;
    /** =ボタン */
    private OldEqualButton equalButton;
    /** Cボタン */
    private OldClearButton clearButton;
    /** 表示する数 */
    private OldDisplayedNumber dispNumber;
    /** 演算器 */
    private OldArithmeticUnit arithmUnit;

    private MenuItem mi1,mi2,mi3,mi4,mi5,mi6,mi7,mi8;

    private Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8;

    /** メイン関数 */
    public static void main(String[] args) {
	OldCalc calc = new OldCalc();
	calc.setVisible(true);
    }

    /** 電卓を使えるようにする（コンストラクタ） */
    public OldCalc() {
	initFields();
	initGUI();
	menu();
    }

    private void menu(){
	setTitle("OldCalc 7");

    /** メニューバーの生成 */
    MenuBar mb = new MenuBar();

    /** メニューの生成 */
    // Menu m1 = new Menu("色の変更");
    Menu m2 = new Menu("電卓の切り替え");
    //Menu m3 = new Menu("機能");

    //mi1 = new MenuItem("BLUE");
    //mi2 = new MenuItem("ORANGE");
    //mi3 = new MenuItem("GREEN");
    //mi4 = new MenuItem("RED");
    //mi5 = new MenuItem("PURPLE"); 
    mi6 = new MenuItem("関数電卓に切り替え");
    // mi7 = new MenuItem("この電卓の使い方");
    //mi8 = new MenuItem("関数の説明");


    /** イベントリスナーの登録 */
    //mi1.addActionListener(this);
    //mi2.addActionListener(this);
    //mi3.addActionListener(this);
    //mi4.addActionListener(this);
    //mi5.addActionListener(this);
    mi6.addActionListener(this);
    // mi7.addActionListener(this);
    //mi8.addActionListener(this);

    /** メニューへの追加 */
    //m1.add(mi1);
    //m1.add(mi2);
    //m1.add(mi3);
    //m1.add(mi4);
    //m1.add(mi5);
    m2.add(mi6);
    // m3.add(mi7);
    // m3.add(mi8);

    /** メニューバーへの追加 */
    //mb.add(m1);
    mb.add(m2);
    //mb.add(m3);

    /** メニューバーをフレームに追加 */
    setMenuBar(mb);

    /** ボタンの設定 */
    //btn1 = new Button("BLUE");
    //btn2 = new Button("ORANGE");
    //btn3 = new Button("GREEN");
    //btn4 = new Button("RED");
    //btn5 = new Button("PURPLE"); 
    btn6 = new Button("関数電卓に切り替え");
    //btn7 = new Button("この電卓の使い方");
    //btn8 = new Button("関数");

    /** パネル */
    Panel pn = new Panel();
    pn.setLayout(new GridLayout(1, 3));
    
    //btn1.addActionListener(this);
    //btn2.addActionListener(this);
    //btn3.addActionListener(this);
    //btn4.addActionListener(this);
    //btn5.addActionListener(this);
    btn6.addActionListener(this);
    //btn7.addActionListener(this);
    //btn8.addActionListener(this);

    //pn.add(btn1);
    //pn.add(btn2);
    //pn.add(btn3);
    //pn.add(btn4);
    //pn.add(btn5);
    pn.add(btn6);
    //pn.add(btn7);
    //pn.add(btn8);

    /** 色の変更 */
    setBackground(new Color(220,240,255));
   }
    
    public void actionPerformed(ActionEvent e){

		Object obj = e.getSource();
		/*if(obj==btn1 || obj==mi1){
	    try{
		Runtime rt = Runtime.getRuntime();
		rt.exec("java BlueCalc");
	    }catch(IOException ex){
		ex.printStackTrace();
	    }System.exit(0);
	}else if(obj==btn2 || obj==mi2){
	    try{
		Runtime rt = Runtime.getRuntime();
		rt.exec("java Calc");
	    }catch(IOException ex){
		ex.printStackTrace();
	    }System.exit(0);
	}else if(obj==btn3 || obj==mi3){
	    try{
		Runtime rt = Runtime.getRuntime();
		rt.exec("java GreenCalc");
	    }catch(IOException ex){
		ex.printStackTrace();
	    }System.exit(0);
	}else if(obj==btn4 || obj==mi4){
	    try{
		Runtime rt = Runtime.getRuntime();
		rt.exec("java RedCalc");
	    }catch(IOException ex){
		ex.printStackTrace();
	    }System.exit(0);
	}else if(obj==btn5 || obj==mi5){
	    try{
		Runtime rt = Runtime.getRuntime();
		rt.exec("java PurpleCalc");
	    }catch(IOException ex){
		ex.printStackTrace();
		}System.exit(0); */
	if(obj==btn6 || obj==mi6){
	    try{
		Runtime rt = Runtime.getRuntime();
		rt.exec("java Calc");
	    }catch(IOException ex){
		ex.printStackTrace();
	    }System.exit(0);
	}
    }
    
    /** 電卓の属性を初期化する */
    private void initFields() {
	/* あとで必要なコードを書く */
	numButton = new OldNumButton[10]; // 0から10までのボタンを生成する
	opButton = new OldOpButton[4]; //×,÷,+,-のボタンを生成する
	dispNumber = new OldDisplayedNumber();
	for (int i = 0; i < 10; i++) {
	    numButton[i] = new OldNumButton(dispNumber,arithmUnit,i);
	}
	arithmUnit = new OldArithmeticUnit(dispNumber);
	clearButton = new OldClearButton(dispNumber,arithmUnit); // Cボタンを生成する
	opButton[0] = new OldOpButton("×",arithmUnit,dispNumber); // ×ボタンを生成する
	opButton[1] = new OldOpButton("÷",arithmUnit,dispNumber); // ÷ボタンを生成する
	opButton[2] = new OldOpButton("+",arithmUnit,dispNumber); // +ボタンを生成する
	opButton[3] = new OldOpButton("-",arithmUnit,dispNumber); // -ボタンを生成する
	equalButton = new OldEqualButton(arithmUnit); // =ボタンを生成する

    }
    /** 電卓の表示を初期化する */
    private void initGUI() {
	setSize(300, 250);
	setLocation(70, 700);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	/* あとで必要なコードを書く */

	setLayout(new GridBagLayout()); // GridBagLayoutで配置する
	GridBagConstraints c = new GridBagConstraints(); // 配置制約を指定する
	c.fill = GridBagConstraints.BOTH; // コンポーネントを表示領域の最大サイズにする.
	c.weightx = c.weighty = 1; // 余分の水平・垂直すポースを分配する方法を指定する.
	c.gridx = GridBagConstraints.RELATIVE; // 直前に追加されたコンポーネントの右隣に配置されるように指定する.



	dispNumber.setHorizontalAlignment(SwingConstants.RIGHT); // 数字列を右寄せで配置する


	add(arithmUnit,c);
	c.gridwidth = 4;
	add(dispNumber,c);
	c.gridwidth = 1;


	/* 1行目に, 7,8,9ボタンと, Cボタンを並べる */
	c.gridy = 1; // 1行目に配置する
	add(numButton[7], c); // 1行目の左端に7ボタンを配置する
	add(numButton[8], c); // その右隣に8ボタンを配置する
	add(numButton[9], c); // その右隣に9ボタンを配置する
	c.gridwidth = 2;
	add(clearButton, c); // その右隣に横2マス使ってCボタンを配置する
	c.gridwidth = 1;
	/* 3行目から5行目は配置していない */

	c.gridy = 2;
	add(numButton[4], c); // 1行目の左端に7ボタンを配置する
	add(numButton[5], c); // その右隣に8ボタンを配置する
	add(numButton[6], c); // その右隣に9ボタンを配置する
        add(opButton[0], c);
	add(opButton[1], c);
	c.gridwidth = 1;

	c.gridy = 3;
	add(numButton[1], c); // 1行目の左端に7ボタンを配置する
	add(numButton[2], c); // その右隣に8ボタンを配置する
	add(numButton[3], c); // その右隣に9ボタンを配置する

	c.gridy = 4;
	c.gridwidth = 2;
	add(numButton[0], c);

	c.gridy = 3;
	c.gridheight = 2;
	c.gridwidth = 1;
        add(opButton[2], c);
	c.gridheight = 1;
	add(opButton[3], c);

	c.gridy = 4;
	add(equalButton, c);
    }
}
