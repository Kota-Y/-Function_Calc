import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.io.IOException;

/** 電卓クラス(電卓プログラムのメインクラス) **/
public class GreenCalc extends JFrame implements ActionListener {
    /** 数字ボタン. 0から9の10個 */
    private NumButton[] numButton;
    /** 演算器号ボタン. + - * / の4つ */
    private OpButton[] opButton;

    private FuButton[] fuButton;

    /** =ボタン */
    private EqualButton equalButton;
    /** Cボタン */
    private ClearButton clearButton;
    /** 表示する数 */
    private DisplayedNumber dispNumber;
    /** 演算器 */
    private ArithmeticUnit arithmUnit;

    private MenuItem mi1,mi2,mi3,mi4,mi5,mi6,mi7,mi8,mi9,mi10;

    private Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn10;

    /** 色の基準 */
   /**関数の背景色、5以上195以下で*/
    int co1 = 60;
    int co2 = 195; 
    int co3 = 50;   
 /** 演算の背景色、225以下で */  
    int co4 = 0;
    int co5 = 0;
    int co6 = 0;
  /**数字の背景色、160以下で*/
    int co7 = 0;
    int co8 = 0;
    int co9 = 0;


    /** メイン関数 */
    public static void main(String[] args){
    Rireki rir = new Rireki();
	GreenCalc calc = new GreenCalc();
	rir.setVisible(true);	
	rir.expose();	
	calc.setVisible(true);
    }

    /** 電卓を使えるようにする（コンストラクタ） */
    public GreenCalc() {
	initFields();
	initGUI();
	menu();
    }

      private void menu(){
	setTitle("Calc 7");

    /** メニューバーの生成 */
    MenuBar mb = new MenuBar();

    /** メニューの生成 */
    Menu m1 = new Menu("色の変更");
    Menu m2 = new Menu("電卓の切り替え");
    Menu m3 = new Menu("機能");
    Menu m4 = new Menu("お問い合わせホーム");

    mi1 = new MenuItem("BLUE");
    mi2 = new MenuItem("ORANGE");
    mi3 = new MenuItem("GREEN");
    mi4 = new MenuItem("RED");
    mi5 = new MenuItem("PURPLE"); 
    mi6 = new MenuItem("通常の電卓に切り替え");
    mi7 = new MenuItem("この電卓の使い方");
    mi8 = new MenuItem("関数の説明");
    mi9 = new MenuItem("お問い合わせ");
    mi10 = new MenuItem("アンケートのご案内");


    /** イベントリスナーの登録 */
    mi1.addActionListener(this);
    mi2.addActionListener(this);
    mi3.addActionListener(this);
    mi4.addActionListener(this);
    mi5.addActionListener(this);
    mi6.addActionListener(this);
    mi7.addActionListener(this);
    mi8.addActionListener(this);
    mi9.addActionListener(this);
    mi10.addActionListener(this);
    
    /** メニューへの追加 */
    m1.add(mi1);
    m1.add(mi2);
    m1.add(mi3);
    m1.add(mi4);
    m1.add(mi5);
    m2.add(mi6);
    m3.add(mi7);
    m3.add(mi8);
    m4.add(mi9);
    m4.add(mi10);

    /** メニューバーへの追加 */
    mb.add(m1);
    mb.add(m2);
    mb.add(m3);
    mb.add(m4);

    /** メニューバーをフレームに追加 */
    setMenuBar(mb);

 
    /** ボタンの設定 */
    btn1 = new Button("BLUE");
    btn2 = new Button("ORANGE");
    btn3 = new Button("GREEN");
    btn4 = new Button("RED");
    btn5 = new Button("PURPLE"); 
    btn6 = new Button("電卓に切り替え");
    btn7 = new Button("この電卓の使い方");
    btn8 = new Button("関数の説明");
    btn9 = new Button("お問い合わせ");
    btn10 = new Button("アンケートのご案内");

    /** パネル */
    Panel pn = new Panel();
    pn.setLayout(new GridLayout(1, 3));
    
    btn1.addActionListener(this);
    btn2.addActionListener(this);
    btn3.addActionListener(this);
    btn4.addActionListener(this);
    btn5.addActionListener(this);
    btn6.addActionListener(this);
    btn7.addActionListener(this);
    btn8.addActionListener(this);
    btn9.addActionListener(this);
    btn10.addActionListener(this);

    pn.add(btn1);
    pn.add(btn2);
    pn.add(btn3);
    pn.add(btn4);
    pn.add(btn5);
    pn.add(btn6);
    pn.add(btn7);
    pn.add(btn8);
    pn.add(btn9);
    pn.add(btn10);

    /** 色の変更 */
    setBackground(new Color(70,70,70));
 
   }
    // それぞれのボタンが押された時のメソッド
    public void actionPerformed(ActionEvent e){

	Object obj = e.getSource();

	if(obj==btn1 || obj==mi1){
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
		Runtime rs = Runtime.getRuntime();
		rs.exec("java GreenCalc");
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
	    }System.exit(0);
	}else if(obj==btn6 || obj==mi6){
	    try{
		Runtime rt = Runtime.getRuntime();
		rt.exec("java OldCalc");
	    }catch(IOException ex){
		ex.printStackTrace();
	    }System.exit(0);
	}else if(obj==btn7 || obj==mi7){
	    try{
		Runtime rt = Runtime.getRuntime();
		rt.exec("java Howtouse");
	    }catch(IOException ex){
		ex.printStackTrace();
	    }
	}else if(obj==btn8 || obj==mi8){
	    try{
		Runtime rt = Runtime.getRuntime();
		rt.exec("java Discription");
	    }catch(IOException ex){
		ex.printStackTrace();
	    }
	}else if(obj==btn9 || obj==mi9){
	    try{
		Runtime rt = Runtime.getRuntime();
		rt.exec("java Contact_Us");
	    }catch(IOException ex){
		ex.printStackTrace();
	    }
	}else if(obj==btn10 || obj==mi10){
	    try{
		    Runtime rt = Runtime.getRuntime();
		rt.exec("java Questionnaire");
		}catch(IOException ex){
		    ex.printStackTrace();
		}
	}
	}
    

    

    /** 電卓の属性を初期化する */
    private void initFields() {
	numButton = new NumButton[50]; 
	opButton = new OpButton[4]; //×,÷,+,-のボタンを生成する

	fuButton = new FuButton[50];

	dispNumber = new DisplayedNumber();
	for (int i = 0; i < 50; i++) {
	    numButton[i] = new NumButton(dispNumber,arithmUnit,i);
	}
	arithmUnit = new ArithmeticUnit(dispNumber);
	clearButton = new ClearButton(dispNumber,arithmUnit); // Cボタンを生成する
	opButton[0] = new OpButton("✕",dispNumber,arithmUnit); // ×ボタンを生成する
	opButton[1] = new OpButton("÷",dispNumber,arithmUnit); // ÷ボタンを生成する
	opButton[2] = new OpButton("+",dispNumber,arithmUnit); // +ボタンを生成する
	opButton[3] = new OpButton("-",dispNumber,arithmUnit); // -ボタンを生成する

	fuButton[0] = new FuButton("ln",dispNumber,arithmUnit);
	fuButton[1] = new FuButton("logx",dispNumber,arithmUnit);
	fuButton[2] = new FuButton("log",dispNumber,arithmUnit);
	fuButton[3] = new FuButton("sinh",dispNumber,arithmUnit);
	fuButton[4] = new FuButton("cosh",dispNumber,arithmUnit);
	fuButton[5] = new FuButton("tanh",dispNumber,arithmUnit);
	fuButton[6] = new FuButton("sin",dispNumber,arithmUnit);
	fuButton[7] = new FuButton("cos",dispNumber,arithmUnit);
	fuButton[8] = new FuButton("tan",dispNumber,arithmUnit);
	fuButton[9] = new FuButton(" exp",dispNumber,arithmUnit);
	fuButton[10] = new FuButton("xCy",dispNumber,arithmUnit);
	fuButton[11] = new FuButton("xPy",dispNumber,arithmUnit);
	fuButton[12] = new FuButton("x^y",dispNumber,arithmUnit);
	fuButton[13] = new FuButton("n!",dispNumber,arithmUnit);
	fuButton[14] = new FuButton("10^x",dispNumber,arithmUnit);
	fuButton[15] = new FuButton("1/x",dispNumber,arithmUnit);
	fuButton[16] = new FuButton("y",dispNumber,arithmUnit);
	fuButton[17] = new FuButton("√",dispNumber,arithmUnit);
	fuButton[18] = new FuButton("π",dispNumber,arithmUnit);
	fuButton[19] = new FuButton(" → ",dispNumber,arithmUnit);
	fuButton[20] = new FuButton(" ← ",dispNumber,arithmUnit);
	fuButton[21] = new FuButton(" （  ",dispNumber,arithmUnit);
	fuButton[22] = new FuButton(" ）  ",dispNumber,arithmUnit);
	fuButton[23] = new FuButton("B.S ",dispNumber,arithmUnit);
	fuButton[24] = new FuButton("000",dispNumber,arithmUnit);
	fuButton[25] = new FuButton(".",dispNumber,arithmUnit);
	fuButton[26] = new FuButton("x",dispNumber,arithmUnit);

	equalButton = new EqualButton(dispNumber,arithmUnit); // =ボタンを生成する



    }
 /** 電卓の表示を初期化する */
    public void initGUI() {
	setSize(610, 402);
	setLocation(70, 700);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	/* あとで必要なコードを書く */

	setLayout(new GridBagLayout()); // GridBagLayoutで配置する
	GridBagConstraints c = new GridBagConstraints(); // 配置制約を指定する
	c.fill = GridBagConstraints.BOTH; // コンポーネントを表示領域の最大サイズにする.
	c.weightx = c.weighty = 1; // 余分の水平・垂直すポースを分配する方法を指定する.
	c.gridx = GridBagConstraints.RELATIVE; // 直前に追加されたコンポーネントの右隣に配置されるように指定する.


	dispNumber.setHorizontalAlignment(SwingConstants.RIGHT); // 数字列を右寄せで配置する
	dispNumber.setFont(new Font("MONOSPACED",Font.PLAIN, 23));

	add(arithmUnit,c);
	c.gridwidth = 9;
	add(dispNumber,c);
	c.gridwidth = 1;

	dispNumber.setForeground(new Color(0,0,0));


	c.gridy = 1;
	add(fuButton[2], c);
	add(fuButton[3], c);
	add(fuButton[6], c);
	add(fuButton[9], c);
	add(fuButton[20], c);
	add(fuButton[19], c);
	add(fuButton[21], c);
	add(fuButton[22], c);
	add(fuButton[23], c);

	fuButton[2].setBackground(new Color(co1-5,co2+20,co3+45));
	fuButton[3].setBackground(new Color(co1,co2+25,co3+50));
	fuButton[6].setBackground(new Color(co1+5,co2+30,co3+55));
	fuButton[9].setBackground(new Color(co1+10,co2+35,co3+60));
	fuButton[2].setForeground(Color.white);
	fuButton[3].setForeground(Color.WHITE);
	fuButton[6].setForeground(Color.WHITE);
	fuButton[9].setForeground(Color.WHITE);

	fuButton[20].setBackground(new Color(co1,co2,co3));
	fuButton[19].setBackground(new Color(co1,co2,co3));
	fuButton[21].setBackground(new Color(co1,co2,co3));
	fuButton[22].setBackground(new Color(co1,co2,co3));
	fuButton[23].setBackground(new Color(co1+5,co2+5,co3+5));
	fuButton[20].setForeground(Color.white);
	fuButton[19].setForeground(Color.white);
	fuButton[21].setForeground(Color.white);
	fuButton[22].setForeground(Color.white);
	fuButton[23].setForeground(Color.orange);




	c.gridy = 2;
	add(fuButton[1], c);
	add(fuButton[4], c);
	add(fuButton[7], c);
	add(fuButton[18], c);


	fuButton[1].setBackground(new Color(co1,co2+25,co3+50));
	fuButton[4].setBackground(new Color(co1+5,co2+30,co3+55));
	fuButton[7].setBackground(new Color(co1+10,co2+35,co3+60));
	fuButton[18].setBackground(new Color(co1+15,co2+40,co3+65));

	fuButton[1].setForeground(Color.white);
	fuButton[4].setForeground(Color.white);
	fuButton[7].setForeground(Color.white);
	fuButton[18].setForeground(Color.white);

	add(numButton[7], c); 
	add(numButton[8], c); 
	add(numButton[9], c); 

	numButton[7].setBackground(new Color(co4,co5+25,co6+50));
	numButton[8].setBackground(new Color(co4+5,co5+30,co6+55));
	numButton[9].setBackground(new Color(co4+10,co5+35,co6+60));
	numButton[7].setForeground(Color.WHITE);
	numButton[8].setForeground(Color.WHITE);
	numButton[9].setForeground(Color.WHITE);

	c.gridwidth = 2;
	add(clearButton, c); 

	clearButton.setBackground(new Color(co7+10,co8+10,co9+10));
	clearButton.setForeground(Color.blue);
	
	c.gridwidth = 1;


	c.gridy = 3;
	add(fuButton[0], c);
	add(fuButton[5], c);
	add(fuButton[8], c);
	add(fuButton[17], c);

	fuButton[0].setBackground(new Color(co1+5,co2+30,co3+55));
	fuButton[5].setBackground(new Color(co1+10,co2+35,co3+60));
	fuButton[8].setBackground(new Color(co1+15,co2+40,co3+65));
	fuButton[17].setBackground(new Color(co1+20,co2+45,co3+70));

	fuButton[0].setForeground(Color.WHITE);
	fuButton[5].setForeground(Color.WHITE);
	fuButton[8].setForeground(Color.WHITE);
	fuButton[17].setForeground(Color.WHITE);

	add(numButton[4], c); 
	add(numButton[5], c); 
	add(numButton[6], c); 

	numButton[4].setBackground(new Color(co4+5,co5+30,co6+55));
	numButton[5].setBackground(new Color(co4+10,co5+35,co6+60));
	numButton[6].setBackground(new Color(co4+15,co5+40,co6+65));
	numButton[4].setForeground(Color.WHITE);
	numButton[5].setForeground(Color.WHITE);
	numButton[6].setForeground(Color.WHITE);

        add(opButton[0], c);
	add(opButton[1], c);

	opButton[0].setBackground(new Color(co7+15,co8+15,co9+15));
	opButton[0].setForeground(Color.white);
	opButton[1].setBackground(new Color(co7+20,co8+20,co9+20));
	opButton[1].setForeground(Color.white);
	c.gridwidth = 1;



	c.gridy = 4;
	add(fuButton[10], c);
	add(fuButton[13], c);
	add(fuButton[14], c);
	add(fuButton[15], c);



	fuButton[10].setBackground(new Color(co1+10,co2+35,co3+60));
	fuButton[13].setBackground(new Color(co1+15,co2+40,co3+65));
	fuButton[14].setBackground(new Color(co1+20,co2+45,co3+70));
	fuButton[15].setBackground(new Color(co1+25,co2+50,co3+75));
	fuButton[10].setForeground(Color.WHITE);
	fuButton[13].setForeground(Color.WHITE);
	fuButton[14].setForeground(Color.WHITE);
	fuButton[15].setForeground(Color.WHITE);

	add(numButton[1], c); 
	add(numButton[2], c); 
	add(numButton[3], c); 

	numButton[1].setBackground(new Color(co4+10,co5+35,co6+60));
	numButton[2].setBackground(new Color(co4+15,co5+40,co6+65));
	numButton[3].setBackground(new Color(co4+20,co5+45,co6+70));
	numButton[1].setForeground(Color.WHITE);
	numButton[2].setForeground(Color.WHITE);
	numButton[3].setForeground(Color.WHITE);

	c.gridy = 5;
	add(fuButton[11], c);
	add(fuButton[12], c);
	add(fuButton[26], c);
	add(fuButton[16], c);

	fuButton[11].setBackground(new Color(co1+15,co2+40,co3+65));
	fuButton[12].setBackground(new Color(co1+20,co2+45,co3+70));
	fuButton[26].setBackground(new Color(co1+25,co2+50,co3+75));
	fuButton[16].setBackground(new Color(co1+30,co2+55,co3+80));
	fuButton[11].setForeground(Color.WHITE);
	fuButton[12].setForeground(Color.WHITE);
	fuButton[26].setForeground(Color.WHITE);
	fuButton[16].setForeground(Color.WHITE);

	add(numButton[0], c); 
	add(fuButton[24], c);
	add(fuButton[25], c);

	numButton[0].setBackground(new Color(co4+15,co5+40,co6+65));
	fuButton[24].setBackground(new Color(co4+20,co5+45,co6+70));
	fuButton[25].setBackground(new Color(co4+25,co5+50,co6+75));
	numButton[0].setForeground(Color.white);
	fuButton[24].setForeground(Color.white);
	fuButton[25].setForeground(Color.WHITE);

	c.gridy = 4;
	c.gridheight = 2;
	c.gridwidth = 1;
        add(opButton[2], c);

	opButton[2].setBackground(new Color(co7+20,co8+20,co9+20));
	opButton[2].setForeground(Color.white);

	c.gridheight = 1;
	add(opButton[3], c);

	opButton[3].setBackground(new Color(co7+25,co8+25,co9+25));
	opButton[3].setForeground(Color.white);

	c.gridy = 5;
	add(equalButton, c);

	equalButton.setBackground(new Color(co7+30,co8+30,co9+30));
	equalButton.setForeground(Color.white);


	for(int l=0; l<4; l++){
	opButton[l].setFont(new Font("Dialog",Font.BOLD, 16));
	}
	for(int m=0; m<10; m++){
	numButton[m].setFont(new Font("Dialog",Font.BOLD, 16));
	}
	for(int i=0; i<27; i++){
	fuButton[i].setFont(new Font("Dialog",Font.BOLD, 16));
	}
	equalButton.setFont(new Font("Dialog",Font.BOLD, 16));
	clearButton.setFont(new Font("Dialog",Font.BOLD, 16));

    }
 

}

