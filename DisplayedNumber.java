import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

/** 表示する数クラス */
public class DisplayedNumber extends JLabel
{
    /**エラーフラグ*/ 
    public boolean errorflag = false;
    
    /**履歴に表示した文字列を渡すためのarraylist*/
    public ArrayList<String> savedlist = new ArrayList<String>();

    /**最終的な式を格納*/
    public String resultChar = "";

    private String cursorChar = "|";
    private String beforeChar = "";
    private String showChar = "";
    private String tempChar = "";
    
    /**カーソルポインタ*/
    public  int cursorPoint = 0;

    private int strLen = 0;

    private ArithmeticUnit arithmUnit;
    
    /**numlistに初めに格納される文字列を確かめるフラグ*/
    private boolean firstflag = true;

    /**コンストラクタ*/
    public DisplayedNumber()
    {
	super("KeyListenerTest");
	setText("0");
	savedlist.add("");
    }   
    
    /** (表示する)を0にする */
    public void clear()
    {
	cursorPoint = 0;
	resultChar = "";
	setText("0");
    }

    /**文字の連結*/
    public void charConnect(String insertChar)
    {
	tempChar = resultChar;
	strLen = resultChar.length();
	resultChar = resultChar.substring(0,strLen-cursorPoint) + insertChar + resultChar.substring(strLen-cursorPoint,strLen);
	setText("<html><body>" + tempChar.substring(0,strLen-cursorPoint) + insertChar + "<font color = \"#ff0000\",size = \"6\">" + cursorChar + "</font>" + tempChar.substring(strLen-cursorPoint,strLen) + "</body></html>");
    }

    /**文字を1文字削除*/
    public void charDelete()
    {
	tempChar = resultChar;
	strLen = resultChar.length();
	if(strLen != 0 && cursorPoint != strLen)
	{
	    resultChar = resultChar.substring(0,strLen-cursorPoint-1) + resultChar.substring(strLen-cursorPoint,strLen);
	    setText("<html><body>" + tempChar.substring(0,strLen-cursorPoint-1) + "<font color = \"#ff0000\",size = \"6\">" + cursorChar + "</font>" + tempChar.substring(strLen-cursorPoint,strLen) + "</body></html>");
	}
    }

    /**カーソルを左に移動*/
    public void cursorLeft()
    {
	strLen = resultChar.length();
	if(cursorPoint == strLen)
	{
	    return;
	}
	cursorPoint = cursorPoint + 1;
	setText("<html><body>" + resultChar.substring(0,strLen-cursorPoint) + "<font color = \"#ff0000\",size = \"6\">" + cursorChar + "</font>" + resultChar.substring(strLen-cursorPoint,strLen) + "</body></html>");
    }

    /**カーソルを右に移動*/
    public void cursorRight()
    {
	strLen = resultChar.length();
	if(cursorPoint == 0)
	{
	    return;
	}
	cursorPoint = cursorPoint - 1;
	setText("<html><body>" + resultChar.substring(0,strLen-cursorPoint) + "<font color = \"#ff0000\",size = \"6\">" + cursorChar + "</font>" + resultChar.substring(strLen-cursorPoint,strLen) + "</body></html>");
    }

    /**格納されている文字列の読み出し(デバック用)*/
    public void readChar()
    {
	//System.out.println(resultChar);
    }

}
