import javax.swing.*;
import java.util.Scanner;
import java.util.*;

/**計算を行うクラス*/
public class ArithmeticUnit extends JLabel
{

    // 数字以外のボタンの定義
    public static String OP_PLUS="+";
    public static String OP_MINUS="-";
    public static String OP_TIMES="×";
    public static String OP_DIVIDE="÷";
    public static String FU_KAKKO=" （  ";
    public static String FU_KAKKOTOJI=" ）  ";
    public static String FU_LOG="log";
    public static String FU_LOGX="logx";
    public static String FU_LN="ln";
    public static String FU_SIN="sin";
    public static String FU_COS="cos";
    public static String FU_TAN="tan";
    public static String FU_SINH="sinh";
    public static String FU_COSH="cosh";
    public static String FU_TANH="tanh";
    public static String FU_EXP=" exp";
    public static String FU_PI="π";
    public static String FU_COMBI="xCy";
    public static String FU_PER="xPy";
    public static String FU_ROOT="√";
    public static String FU_KAIJO="n!";
    public static String FU_RUIJO="x^y";
    public static String FU_BUNSU="1/x";
    public static String FU_Y="y";
    public static String FU_10R="10^x";
    public static String FU_RIGHT=" → ";
    public static String FU_LEFT=" ← ";
    public static String FU_BS="B.S ";
    public static String FU_000="000"; 
    public static String FU_DOT=".";
    public static String FU_X ="x";
 
    public String operator, function;

    /**履歴を保管するための変数*/
    public String savedstr;

    /**gnuplotに表示するための変数*/
    public String gnustr;

    /**savedstrに同じ文字列が入らないようにするための変数*/
    public int savedlocation = 0;

    private DisplayedNumber dispNumber;

    /**履歴用の変数*/
    public String output1 = "";
    public String output2 = "";

    /**コンストラクタ*/
    public ArithmeticUnit(DisplayedNumber dispNumber){
	this.dispNumber = dispNumber;
    }

    /**クリアボタンが押された時のメソッド*/
    public void clear(){
	operator = "";
	function = "";
    }

    /**四則演算のボタンが押された時のメソッド*/
    public void setOperator(String operator)
    {
	dispNumber.charConnect(operator);
    }

    /**カッコや矢印、関数のボタンが押された時のメソッド*/
    public void setFunction(String function){
	if(function == FU_BS){
	    dispNumber.charDelete();
	}
	else if(function == FU_KAKKO){
	    dispNumber.charConnect("(");
	}
	else if(function == FU_KAKKOTOJI){
	    dispNumber.charConnect(")");
	}
	else if(function == FU_SIN){
	    dispNumber.charConnect("sin()");
	    dispNumber.cursorLeft();
	}
	else if(function == FU_COS){
	    dispNumber.charConnect("cos()");
	    dispNumber.cursorLeft();
	}
	else if(function == FU_TAN){
	    dispNumber.charConnect("tan()");
	    dispNumber.cursorLeft();
	}
	else if(function == FU_SINH){
	    dispNumber.charConnect("sinh()");
	    dispNumber.cursorLeft();
	}
	else if(function == FU_COSH){
	    dispNumber.charConnect("cosh()");
	    dispNumber.cursorLeft();
	}
	else if(function == FU_TANH){
	    dispNumber.charConnect("tanh()");
	    dispNumber.cursorLeft();
	}
	else if(function == FU_EXP){
	    dispNumber.charConnect("e");
	}
	else if(function == FU_LOG){
	    dispNumber.charConnect("log()()");
	    dispNumber.cursorLeft();
	    dispNumber.cursorLeft();
	    dispNumber.cursorLeft();
	}
	else if(function == FU_LOGX){
	    dispNumber.charConnect("log(10)()");
	    dispNumber.cursorLeft();
	}
	else if(function == FU_LN){
	    dispNumber.charConnect("ln()");
	    dispNumber.cursorLeft();
	}
	else if(function == FU_PI){
	    dispNumber.charConnect("π");
	}
	else if(function == FU_COMBI){
	    dispNumber.charConnect("C()()");
	    dispNumber.cursorLeft();
	    dispNumber.cursorLeft();
	    dispNumber.cursorLeft();
	    dispNumber.cursorLeft();
	}
	else if(function == FU_PER){
	    dispNumber.charConnect("P()()");
	    dispNumber.cursorLeft();
	    dispNumber.cursorLeft();
	    dispNumber.cursorLeft();
	    dispNumber.cursorLeft();
	}
	else if(function == FU_ROOT){
	    dispNumber.charConnect("^(0.5)");
	    dispNumber.cursorLeft();
	    dispNumber.cursorLeft();
	    dispNumber.cursorLeft();
	    dispNumber.cursorLeft();
	    dispNumber.cursorLeft();
	    dispNumber.cursorLeft();
	}
	else if(function == FU_KAIJO){
	    dispNumber.charConnect("()!");
	    dispNumber.cursorLeft();
	    dispNumber.cursorLeft();
	}
	else if(function == FU_RUIJO){
	    dispNumber.charConnect("()^()");
	    dispNumber.cursorLeft();
	    dispNumber.cursorLeft();
	    dispNumber.cursorLeft();
	    dispNumber.cursorLeft();
	}
	else if(function == FU_BUNSU){
	    dispNumber.charConnect("1/()");
	    dispNumber.cursorLeft();
	}
	else if(function == FU_Y){
	    dispNumber.charConnect("y");
	}
	else if(function == FU_10R){
	    dispNumber.charConnect("10^()");
	    dispNumber.cursorLeft();
	}
	else if(function == FU_RIGHT){
	    dispNumber.cursorRight();
	}
	else if(function == FU_LEFT){
	    dispNumber.cursorLeft();
	}
	else if(function == FU_000){
	    dispNumber.charConnect("000");
	}
	else if(function == FU_DOT){
	    dispNumber.charConnect(".");
	}
	else if(function == FU_X){
		dispNumber.charConnect("x");
	}
	
	dispNumber.readChar();
    }
    
    
    /**イコールボタンが押された時のメソッド*/
    public void setFinish()
    {
	if(dispNumber.resultChar.charAt(dispNumber.resultChar.length()-1) != '=' && dispNumber.resultChar.indexOf("x") == -1 && dispNumber.resultChar.indexOf("y") == -1){
	    dispNumber.cursorPoint = 0;	
	    dispNumber.charConnect("=");
	}

	dispNumber.readChar();
	// 文字列にxが含まれているとき
	if(dispNumber.resultChar.indexOf("x") != -1 && dispNumber.resultChar.indexOf("y") != -1)
	    { 
	    try
		{
		gnustr = dispNumber.resultChar.substring(0,dispNumber.resultChar.length());
		// gnuplot用に文字列を変換
		gnustr = gnustr.replaceAll("✕", "*");
		gnustr = gnustr.replaceAll("÷", "/");
		gnustr = gnustr.replaceAll("e", "exp"); 
		gnustr = gnustr.replaceAll("π", "pi"); 
		Gnuoutput gnu = new Gnuoutput();
		gnu.splot(gnustr);
	    }
	    catch(Exception e)
		{
		}
	    }
	else if(dispNumber.resultChar.indexOf("x") != -1){ 
	    try{
		gnustr = dispNumber.resultChar.substring(0,dispNumber.resultChar.length());
		// gnuplot用に文字列を変換
		gnustr = gnustr.replaceAll("✕", "*");
		gnustr = gnustr.replaceAll("÷", "/");
		gnustr = gnustr.replaceAll("e", "exp"); 
		gnustr = gnustr.replaceAll("π", "pi"); 
		Gnuoutput gnu = new Gnuoutput();
		gnu.plot(gnustr);
	    }catch(Exception e){
	    }
	}
	else if(dispNumber.resultChar.indexOf("y") != -1){ 
	    try{
		gnustr = dispNumber.resultChar.substring(0,dispNumber.resultChar.length());
		// gnuplot用に文字列を変換
		gnustr = gnustr.replaceAll("y", "x");
		gnustr = gnustr.replaceAll("✕", "*");
		gnustr = gnustr.replaceAll("÷", "/");
		gnustr = gnustr.replaceAll("e", "exp"); 
		gnustr = gnustr.replaceAll("π", "pi"); 
		Gnuoutput gnu = new Gnuoutput();
		gnu.plot(gnustr);
	    }catch(Exception e){
	    }
	}
	
	//文字列にx,yが存在していない
	if(dispNumber.resultChar.indexOf("x") == -1 && dispNumber.resultChar.indexOf("y") == -1){
	    
	    String ans = rePolishAlithm.rePolish( dispNumber.resultChar );
	    
	    //System.out.println(ans);
	    dispNumber.charConnect(ans);
	    dispNumber.readChar();
	}
	
	// 同じ式を履歴に表示しないための変数に代入
	savedstr = dispNumber.savedlist.get(savedlocation);
	// 直前に代入された文字列と異なる場合
	if(!(savedstr.equals(dispNumber.resultChar))){
	    dispNumber.savedlist.add(dispNumber.resultChar);
	    savedlocation += 1;
        }

	// savedlistに文字列が格納されているとき、output2に改行の情報を入れて一つの文字列として代入
	if(dispNumber.savedlist.size() > 1){
	    for(int m=1; m<dispNumber.savedlist.size(); m++){
		output1 += dispNumber.savedlist.get(m) + "<br />" ;
	    }
	    output2 = "<html><body>" + output1 + "</body></html>";
	}

	Rireki lil = new Rireki();
	lil.set(output2);
	
	output1 = "";
	output2 = "";
	dispNumber.resultChar = "";
    }
}
