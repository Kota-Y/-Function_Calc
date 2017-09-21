import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/** 数字ボタンを生成するクラス */
public class NumButton extends JButton implements MouseListener,KeyListener
{
    /** 割り当てられた数字 */
    private int digit;

    private DisplayedNumber dispNumber;
    private ArithmeticUnit arithmUnit;

    /** コンストラクタ */
    public NumButton(DisplayedNumber number,ArithmeticUnit arithmUnit,int t)
    {
	super(Integer.toString(t));
	digit =t;
	this.dispNumber = number;
	this.arithmUnit = arithmUnit;
	addMouseListener(this);
	addKeyListener(this);
    }
    /** 数字ボタンが押された */
    public void mouseClicked(MouseEvent e)
    {
	dispNumber.charConnect(Integer.toString(digit));
    }
    
    public void mouseEntered(MouseEvent e){}
    public void mouseExited(MouseEvent e){}
    public void mousePressed(MouseEvent e){} 
    public void mouseReleased(MouseEvent e){}

    /**キーが押された場合*/
    public void keyPressed(KeyEvent e)
    {
	int key = e.getKeyCode();
	int mod = e.getModifiersEx();
	int shift = InputEvent.SHIFT_DOWN_MASK;

	if(key == 8) //バックスペース
	{
	    dispNumber.charDelete();
	    return;
	}
	else if(key == 37) //←の処理
	{
	    dispNumber.cursorLeft();
	    return;
	}
	else if(key == 39) //→の処理
	{
	    dispNumber.cursorRight();
	    return;
	}	
	else if(key == 38) //↑の処理
	{
	    return;
	}
	else if(key == 40) //↓の処理
	{
	    return;
	}

	//文字コードの変換
	if((mod & shift) != 0 && (65 <= key && key <= 90)) //大文字→大文字
	{
	    key = key;
	}
	else if(65 <= key && key <= 90) //大文字→小文字
	{
	    key = key + 32;
	}
	else if(96 <= key && key <=105) //(電卓)数字→(標準)数字(NumLock:ON)
	{
	    key = key - 48;
	}
	else if(key == 107) //足し算の変換
	{
	    key = 43;
	}
	else if(key == 109) //引き算の変換
	{
	    key = 45;
	}
	else if(key == 106) //掛け算の変換
	{
	    key = 513;
	}
	else if(key == 111) //割り算の変換
	{
	    key = 47;
	}
	else if(key == 127) //小数点の変換
	{
	    key = 46;
	}

	switch(key) //(電卓)数字→(標準)数字(NumLock:OFF)
	{
	    case 155:
		key = 48; 
		break;
	    case 35:
		key = 49; 
		break;
	    case 225:
		key = 50; 
		break;
	    case 34:
		key = 51; 
		break;
	    case 226:
		key = 52; 
		break;
	    case 65368:
		key = 53; 
		break;
	    case 227:
		key = 54; 
		break;
	    case 36:
		key = 55; 
		break;
	    case 224:
		key = 56; 
		break;
	    case 33:
		key = 57; 
		break;
	}

	if(key == KeyEvent.VK_ESCAPE)
	{
	    System.exit(0);
	}
	else if(key == KeyEvent.VK_ENTER)
	{
	    arithmUnit.setFinish();
	    return;
	}
	else
	{
	    char temp  = (char)key;
	    String disp;
	    if((mod & shift) != 0 && key == 59)
	    {
		disp = "+";
	    }
	    else if(((mod & shift) != 0 && key == 513) || key == 513)
	    {
		disp = "✕";
	    }
	    else if((mod & shift) != 0 && key == 56)
	    {
		disp = "(";
	    }
	    else if((mod & shift) != 0 && key == 57)
	    {
		disp = ")";
	    }
	    else if((mod & shift) != 0 && key == 45)
	    {
		disp = "=";
	    }
	    else if((mod & shift) != 0 && key == 49)
	    {
		disp = "!";
	    }
	    else if((mod & shift) != 0 && key == 44)
	    {
		disp = "<";
	    }
	    else if((mod & shift) != 0 && key == 46)
	    {
		disp = ">";
	    }
	    else if((mod & shift) != 0 && key == 47)
	    {
		disp = "?";
	    }
	    else if((mod & shift) != 0 && key == 92)
	    {
		disp = "_";
	    }
	    else if(key == 47)
	    {
		disp = "÷";
	    }
	    else if(key == 514)
	    {
		disp = "^";
	    }
	    else if(key == 263)
	    {
		disp = " ";
	    }
	    else if((mod & shift) != 0 && key == 32) //shift+space
	    {
		dispNumber.clear();
		return;
	    }
	    else
	    {
		disp = String.valueOf(temp);
	    }
	    //System.out.println(key); //文字コード確認用
	   
	    if(key != 16)
	    {
	        dispNumber.charConnect(disp);
	    }
	}
    }
    
    /**キーが離された場合*/
    public void keyReleased(KeyEvent e)
    {
    }
    
    /**キーが押された場合(主に文字キーの検出)*/
    public void keyTyped(KeyEvent e)
    {
    }


}
