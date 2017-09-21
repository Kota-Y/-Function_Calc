import javax.swing.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

/** 数字ボタンクラス */
public class OldNumButton extends JButton implements MouseListener{
    /** 割り当てられた数字 */
    private int digit;
    /** 表示する数 */
    private OldDisplayedNumber dispNumber;
    private OldArithmeticUnit arithmUnit;

    /** コンストラクタ */
    public OldNumButton(OldDisplayedNumber number,OldArithmeticUnit arithmUnit,int t){
	super(Integer.toString(t));
	digit =t;
	this.dispNumber = number;
	this.arithmUnit = arithmUnit;
	addMouseListener(this);
    }
    /** 数字ボタンが押された */
    public void mouseClicked(MouseEvent e){
	dispNumber.addSingleDigit(digit);
    }
    public void mouseEntered(MouseEvent e){}
    public void mouseExited(MouseEvent e){}
    public void mousePressed(MouseEvent e){} 
    public void mouseReleased(MouseEvent e){}
}
